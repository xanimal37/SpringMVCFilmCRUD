package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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



//	Added this - Kenny	
	@GetMapping("findFilmById.do")
//	@RequestMapping(path= "findFilmById.do", method = RequestMethod.GET)
	public ModelAndView findFilmById(Integer filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("findFilmById");
		mv.addObject("film", filmDAO.findFilmById(0));
		return mv;

		// THIS WAS CAUSING AN ERROR BECAUSE WHEN IT WAS CALLED JUST TO LINK, THERE WAS
		// NO DATA PASSED IN

//		Film film = filmDAO.findFilmById(filmId);
//		mv.addObject("film", film);
		// this is what VIEW RESOLVER in the Film-Site-servlet does for us. If we
		// removed that, we'd have to
		// write this out as "WEB-INF/findFilmById.jsp"
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
	@GetMapping("findFilmByKeyWord.do")
	public ModelAndView findFilmByKeyWord(String keyWord) throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("findFilmByKeyWord");
		return mv;
	}

//	Added this - Kenny	
	@PostMapping("createFilm.do")
	public ModelAndView createFilm(Film film, RedirectAttributes redir) throws SQLException {
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:createFilm");
		return mv;
	}

//	Added this - Kenny	
	@PostMapping("updateFilm.do")
	public ModelAndView updateFilm(Integer filmId, Film film) throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateFilm");
		return mv;
	}

//	Added this - Kenny	
	@PostMapping("deleteFilm.do")
	public ModelAndView deleteFilm(Integer filmId) throws SQLException {
//		boolean filmedDeleted = filmDAO.deleteFilm(filmDAO.findFilmById(filmId));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteFilm");
		return mv;
	}

}
