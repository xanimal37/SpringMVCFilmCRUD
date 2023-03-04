package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Central";
	private static final String user = "student";
	private static final String pw = "student";

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;
		String sql = "SELECT f.id, f.title, f.description, f.release_year, f.language_id, "
				+ "f.rental_duration, f.rental_rate, f.length, f.replacement_cost, f.rating, f.special_features, language.name "
				+ "FROM film f JOIN language ON f.language_id = language.id " + "WHERE f.id=?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pw);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Create the object
				film = new Film();
				// set variables from result
				film.setId(rs.getInt("f.id"));
				film.setTitle(rs.getString("f.title"));
				film.setDescription(rs.getString("f.description"));
				film.setReleaseYear(rs.getInt("f.release_year"));
				film.setLanguageId(rs.getInt("f.language_id"));
				film.setRentalDuration(rs.getInt("f.rental_duration"));
				film.setRentalRate(rs.getDouble("f.rental_rate"));
				film.setLength(rs.getInt("f.length"));
				film.setReplacementCost(rs.getDouble("f.replacement_cost"));
				film.setRating(rs.getString("f.rating"));
				film.setFeatures(rs.getString("f.special_features"));
				film.setLanguage(rs.getString("language.name"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// if a film is found add a list of the actors
		if (film != null) {
			List<Actor> actors = findActorsByFilmId(filmId);
			film.setActors(actors);
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pw);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Create the object
				actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

//	Added this - Kenny
	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pw);
			String sql = "SELECT actor.* FROM actor JOIN film_actor ON actor.id = film_actor.actor_id "
					+ "JOIN film ON film_actor.film_id = film.id WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int filmsId = rs.getInt("id");
				String fName = rs.getString("first_name");
				String lName = rs.getString("last_name");
				Actor actor = new Actor(filmsId, fName, lName);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;

	}

//	Added this - Kenny
	@Override
	public List<Film> findFilmByKeyWord(String keyWord) throws SQLException {
		List<Film> films = new ArrayList<>();
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pw);
			String sql = "SELECT film.*, language.name FROM film JOIN language ON film.language_id = language.id WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyWord + "%");
			stmt.setString(2, "%" + keyWord + "%");

			stmt.setString(1, keyWord);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// Here is our mapping of query columns to our object fields:
				Film film = new Film(); // Create the object
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setLanguage(rs.getString("language.name"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setFeatures(rs.getString("special_features"));
				actors = findActorsByFilmId(film.getId());
				film.setActors(actors);
				films.add(film);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Film createFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteFilm(int filmId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Film updateFilm(int filmId, Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver");
			throw new RuntimeException("Unable to load MySQL Driver class");
		}
	}

}
