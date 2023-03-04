package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	public Film findFilmById(int filmId) throws SQLException;

	public Actor findActorById(int actorId) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId);

	public List<Film> findFilmByKeyWord(String keyWord) throws SQLException;

	Film createFilm(Film film);

	boolean deleteFilm(int filmId);

	Film updateFilm(int filmId, Film film);


}
