/*
 * Purpose: This class is meant to store all the information about the 
 * movie, like its release date, title, description, and whether ot not
 * it is an adult film
 */

import java.util.ArrayList;

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
	
	private ArrayList<String> getLines(String description) {
		/*
		 * This private method takes in a a string and splits it into multiple lines
		 * when it reaches a certain length, it also splits at a word not a random letter
		 */
		
		ArrayList<String> lines = new ArrayList<String>();
		
		// split the string into all its words
		String[] split = description.strip().split(" ");
		
		String line = "| ";
		String space = " ";
		
		// for every string in the split string add them to a string until it reaches a certain length
		for (String s : split) {
			// if the length will be exceded then add the line to the list and reset the line String
			if (line.length() + s.length() > 96) {
				lines.add(line + space.repeat(98 - line.length()) + " |\n");
				line = "| ";
			}
			// otherwise add the string to the line
			else {
				line += s + " ";
			}
		}
		
		// if there are leftover words after reaching the end
		if (line.length() > 2) lines.add(line + space.repeat(98 - line.length()) + " |\n");
		return lines;
	}
	
	public String toString() {
		/*
		 * This function returns a full description of the movie object including
		 * Title, release Date, description, rating and if it is adult movie or not
		 */

		String space = " ";
		// make it so all ratings are always to 2 decimals
		String r = String.format("%.2f", rating);
		// //print the border
		String str = "+--------------------------------------------------------------------------------------------------+\n";
		// print each variable with a responsive number of spaces afterwards
		str += "| Title: " + title + space.repeat((89 - title.length())) + " |\n";
		str += "| Release Date: " + date + space.repeat((82 - date.length())) + " |\n";
		str += "| Rating: " + r + space.repeat(84) + " |\n";
		// figure out if adult movie is true or false to print the right number of spaces
		str += "| Adult: " + adultMovie; 
		if (adultMovie) str += space.repeat(85);
		else str += space.repeat(84);
		str += " |\n";
		ArrayList<String> lines = getLines(description);
		for (String s : lines) str += s;
		str += "+--------------------------------------------------------------------------------------------------+\n";
		return str;
	}
}
