package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	// method checked
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
		List<Film> films = new ArrayList<>(); // list to return
		String sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pw);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyWord + "%");
			stmt.setString(2, "%" + keyWord + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Here is our mapping of query columns to our object fields:
				Film film = new Film(); // Create the object
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setFeatures(rs.getString("special_features"));
				// get the actors associated with the film
				List<Actor> actors = findActorsByFilmId(film.getId());
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
	public boolean deleteFilm(int filmId) {
		// boolean to tell if we successfully deleted a film
		boolean deleted = false;

		// SQL statement
		String sql = "DELETE FROM film WHERE id = ?";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pw);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, filmId);
			int uc = st.executeUpdate();
			// only one film should have been added
			if (uc == 1) {
				// If we made it this far, no exception occurred.
				conn.commit(); // Commit the transaction
				deleted = true;
			} else {
				conn.rollback();
				deleted = false;
			}
		} catch (SQLException e) {
			// Something went wrong.
			System.err.println("Error during insert.");
			e.printStackTrace();
			// Need to roll back, which also throws SQLException.
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
		return deleted;
	}

	@Override
	public boolean updateFilm(int filmId, Film updatedFilm) {
	    Connection conn = null;
	    try {
	        conn = DriverManager.getConnection(URL, user, pw);
	        conn.setAutoCommit(false);
	        String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, "
	                + "rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, "
	                + "rating = ?, special_features = ? WHERE id = ?;";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, updatedFilm.getTitle());
	        stmt.setString(2, updatedFilm.getDescription());
	        stmt.setInt(3, updatedFilm.getReleaseYear());
	        stmt.setInt(4, updatedFilm.getLanguageId());
	        stmt.setInt(5, updatedFilm.getRentalDuration());
	        stmt.setDouble(6, updatedFilm.getRentalRate());
	        stmt.setInt(7, updatedFilm.getLength());
	        stmt.setDouble(8, updatedFilm.getReplacementCost());
	        stmt.setString(9, updatedFilm.getRating());
	        stmt.setString(10, updatedFilm.getFeatures());
	        stmt.setInt(11, filmId);
	        int updateCount = stmt.executeUpdate();
	        if (updateCount == 1) {
	            sql = "DELETE FROM film_actor WHERE film_id = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, filmId);
	            stmt.executeUpdate();
	            sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
	            stmt = conn.prepareStatement(sql);
	            for (Actor actor : updatedFilm.getActors()) {
	                stmt.setInt(1, filmId);
	                stmt.setInt(2, actor.getId());
	                stmt.executeUpdate();
	            }
	            conn.commit();
	        }
	    } catch (SQLException sqle) {
	        sqle.printStackTrace();
	        if (conn != null) {
	            try {
	                conn.rollback();
	            } catch (SQLException sqle2) {
	                System.err.println("Error trying to rollback");
	            }
	        }
	        return false;
	    }
	    return true;
	}
	
	// this creates and adds a film from a Film object
		//film is a copy but we are returning it so should be ok
		@Override
		public Film createFilm(Film film) {
			int filmID=0; //this will get updated with the key when the film is added
			String sql = null;
			if (film != null) {
				//did it this way to make the sql statement easier
				String title = film.getTitle();
				String desc = film.getDescription();
				int year = film.getReleaseYear();
				int langID = film.getLanguageId();
				int duration = film.getRentalDuration();
				double rate = film.getRentalRate();
				int length = film.getLength();
				double cost = film.getReplacementCost();
				String rating =film.getRating();
				String features = film.getFeatures();
					
				sql = "INSERT INTO FILM (title, description,release_year,language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) " + 
						"VALUES('"+title + "','" + desc + "','" + year + "','" + langID +"','"+ duration +"','"+ rate +"','"+ length +"','"+
						cost +"','"+ rating +"','"+ features +"')";
			}
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(URL, user, pw);
				conn.setAutoCommit(false); // Start transaction
				PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				int uc = st.executeUpdate();
				ResultSet keys = st.getGeneratedKeys();
				while (keys.next()) {
			        filmID =  keys.getInt(1);
			        System.out.println(filmID); //DEBUG
			      }

				//only one film should have been added
				if (uc == 1) {
					// If we made it this far, no exception occurred.
					conn.commit(); // Commit the transaction
					
					//add the generated id to the film
					film.setId(filmID);
				}
				else {
					//make it null so a null object is returned and the jsp will display an appropriate message
					film=null;
				}
			} catch (SQLException e) {
				// Something went wrong.
				System.err.println("Error during insert.");
				e.printStackTrace();
				// Need to roll back, which also throws SQLException.
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						System.err.println("Error rolling back.");
						e1.printStackTrace();
					}
				}
			}
			return film;
		}


}