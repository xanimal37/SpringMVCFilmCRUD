package com.skilldistillery.film.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.data.FilmDaoJdbcImpl;

class FilmTest {
	
	private FilmDAO filmDAO;

	@BeforeEach
	void setUp() {
		filmDAO = new FilmDaoJdbcImpl();
	}
	
	@AfterEach
	void tearDown() {
		filmDAO=null;
	}
	
	@Test
	@DisplayName("Find Actor By ID test...")
	void test_findActorById() throws SQLException {
		Actor actor = null;
		actor = filmDAO.findActorById(27);
		
		assertEquals("Julia", actor.getFirstName());
	}
	
	@Test 
	@DisplayName("Find Film By ID test...")
	void test_findFilmById() throws SQLException {
		Film film = null;
		film = filmDAO.findFilmById(3);
		
		assertEquals("ADAPTATION HOLES",film.getTitle());
	}
	
	@Test 
	@DisplayName("Add film to Database test...")
	void test_addFilm() {
		Film film = new Film();
		film.setTitle("PUMPKIN WONDERLAND");
		film.setDescription("A pumpkin struggles with garden boundaries and in the process finds love");
		film.setFeatures("Trailers");
		film.setLanguageId(1);
		film.setLength(90);
		film.setRating("PG");
		film.setReleaseYear(1994);
		film.setRentalDuration(3);
		film.setRentalRate(2.99);
		film.setReplacementCost(5.89);
	
		Film newFilm = filmDAO.createFilm(film);
		
		assertEquals(1001,newFilm.getId());
	}
	
	@Test
	@DisplayName("Remove Film from database test...")
	void test_deleteFilm() {
		
		assertEquals(true,filmDAO.deleteFilm(1001));
	}
	
	@Test
	@DisplayName("Update film in database")
	void test_updateFilm() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Find Film by keyword test...")
	void test_findFilmByKeyword() throws SQLException {
		List<Film> result = filmDAO.findFilmByKeyWord("youth");
		System.out.println(result.size());
		
		assertEquals(3,result.size());
	}

}
