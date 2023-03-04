package com.skilldistillery.film.entities;

import java.util.ArrayList;
import java.util.List;

public class Film {

	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageId;
	private Integer length; // might be null
	private double replacementCost;
	private int rentalDuration;
	private double rentalRate;
	private String rating;
	private String features;
	private String language;
	private List<Actor> actors;

	// constructors
	public Film() {
	}

	public Film(int id, String title, String description, int releaseYear, int languageId, Integer length,
			double replacementCost, int rentalDuration, String rating, String features, double rentalRate,
			String language) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rentalDuration = rentalDuration;
		this.rating = rating;
		this.features = features;
		this.rentalRate = rentalRate;
		this.language = language;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Actor> getActors() {
		// return a copy
		return new ArrayList<Actor>(actors);
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	// overrides
	// User story 5
	@Override
	public String toString() {
		StringBuilder filmStr = new StringBuilder();
		filmStr.append(getTitle() + " | ");
		filmStr.append(getReleaseYear() + " | ");
		filmStr.append(getRating() + " | ");
		filmStr.append(getDescription() + " | ");
		filmStr.append(getLanguage() + " | ");

		// now add the list of actors
		filmStr.append("\n*** Starring: ***\n");

			for (Actor actor : actors) {
				filmStr.append(actor + "\n");
			}

		return filmStr.toString();
	}

}
