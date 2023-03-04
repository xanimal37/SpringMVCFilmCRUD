package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(path= {"/", "home.do"})
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
		Film film = filmDAO.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/findFilmById.jsp");
		return mv;
	}
	
}
