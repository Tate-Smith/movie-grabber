/*
 * Purpose: This class is meant to store all the information about the 
 * movie, like its release date, title, description, and whether ot not
 * it is an adult film
 */

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Movie {
	private String title;
	private String date;
	private String description;
	private boolean adultMovie;
	private double rating;
	
	public Movie(JsonElement data) {
		// get each section in data and update the instance variables
		JsonObject obj = data.getAsJsonObject();

		adultMovie = obj.get("adult").getAsBoolean();

		description = obj.get("overview").getAsString();
		
		date = obj.get("release_date").getAsString();
		
		title = obj.get("title").getAsString();
		
		rating = obj.get("vote_average").getAsDouble();
	}
	
	public String toString() {
		/*
		 * This function returns a full description of the movie object including
		 * Title, release Date, description, rating and if it is adult movie or not
		 */
		
		String str = "+--------------------------------------------------------------------------------------------------+\n";
		str += "| Title: " + title + " |\n";
		str += "| Release Date: " + date + " |\n";
		str += "| Rating: " + rating + " |\n";
		str += "| Adult: " + adultMovie +  " |\n";
		str += "| Description: " + description + " |\n";
		str += "+--------------------------------------------------------------------------------------------------+\n";
		return str;
	}
}
