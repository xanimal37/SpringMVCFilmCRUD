package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;

//	Added this - Kenny
	public void FilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}

	@RequestMapping(path = { "/", "home.do" })
	public String goHome(Model model) throws SQLException {
//		Film TEST = filmDAO.findFilmById(1);
//		model.addAttribute("TESTFILM", TEST);	
		return "home";
	}

	// this one just loads page - has no parameters
	@GetMapping("findFilmById.do")
	public String loadIDSearch(Model model) throws SQLException {
		return "findFilmById";
	}

	// this one just loads page - has no parameters
	@GetMapping("addFilm.do")
	public String addFilm(Model model) throws SQLException {
		return "addFilm";
	}

	// this one just loads page - has no parameters
	@GetMapping("findFilmByKeyword.do")
	public String loadKeywordSearch(Model model) throws SQLException {
		return "findFilmByKeyword";
	}

	// this method is run if searching for a film by ID
	@RequestMapping(path = "findFilmById.do", params = "id", method = RequestMethod.GET)
	public ModelAndView findFilmById(@RequestParam("id") int id) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(id);
		mv.addObject("film", film);
		mv.setViewName("findFilmById");
		return mv;
	}

	// this method is run if searching for a film by keyword
	@RequestMapping(path = "findFilmByKeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView findFilmById(@RequestParam("keyword") String keyword) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmByKeyWord(keyword);
		mv.addObject("films", films);
		mv.setViewName("findFilmByKeyword");
		return mv;
	}

//	Added this - Kenny	
	@GetMapping("findActorById.do")
	public ModelAndView findActorById(Integer actorId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("findActorById");
		return mv;
	}

//	Added this - Kenny	
	@GetMapping("findActorsByFilmId.do")
	public ModelAndView findActorsByFilmId(Integer filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("findFilmById");
		return mv;
	}

//	Added this - Kenny		
	@PostMapping("updateFilm.do")
	public ModelAndView updateFilm(@ModelAttribute("film") Film film) {
		ModelAndView mv = new ModelAndView();
		boolean success = filmDAO.updateFilm(film.getId(), film);
		if (success) {
			mv.setViewName("updateFilmSuccess");
		} else {
			mv.addObject("errorMessage", "Unable to update film.");
			mv.setViewName("updateFilm");
		}
		return mv;
	}

//	Added this - Kenny	
	@GetMapping("deleteFilm.do")
	public ModelAndView deleteFilm(Integer filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteFilm");
		return mv;
	}
	
	// adds a film
		@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
		public ModelAndView newFilm(@RequestParam("film_title") String title, @RequestParam("film_desc") String desc,
				@RequestParam("film_year") int year, 
				@RequestParam("film_length") int length,
				@RequestParam("film_languageID") int langID, 
				@RequestParam("film_rentalDuration") int duration,
				@RequestParam("film_rate") double rate, 
				@RequestParam("film_repCost") double repCost,
				// ratings is a radio button - can be only one
				@RequestParam("rating") String rating,
				// features are checkboxes - can have more than one
				@RequestParam(name="trailers",defaultValue ="") String trailers, 
				@RequestParam(name="commentaries",defaultValue ="") String commentaries,
				@RequestParam(name="deleted",defaultValue ="") String deleted, 
				@RequestParam(name="behind",defaultValue ="") String behind) throws SQLException { 

			// features, since there is more than one
			// an empty string is ok but null is not
			StringBuilder features = new StringBuilder();
			String[] possibleFeatures = { trailers, commentaries, deleted, behind };
			for (String f : possibleFeatures) {
				if (f != null && f.length()>0) {
					features.append("," + f);
				}
			}
			// if there something in the string, remove the first character, whihc will be a
			// comma
			if (features.length() > 0) {
				features.delete(0, 1);
			}
			System.out.println(features);

			// doing this the tedious way
			Film film = new Film();
			film.setTitle(title);
			film.setDescription(desc);
			film.setFeatures(features.toString());
			film.setLanguageId(langID);
			film.setRating(rating);
			film.setReleaseYear(year);
			film.setLength(length);
			film.setRentalDuration(duration);
			film.setRentalRate(rate);
			film.setReplacementCost(repCost);

			// add film to database
			Film newFilm = filmDAO.createFilm(film);
			ModelAndView mv = new ModelAndView();
			mv.addObject("film", newFilm);
			mv.setViewName("addFilm");

			return mv;
		}


}