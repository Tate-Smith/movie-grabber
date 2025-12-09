/*
 * Author: Tate Smith
 * Date: 12/2/25
 * Purpose: This project is meant to build a simple command line interface to display
 * information about 4 movie categories Playing, Popular, Top, Upcoming; all of these
 * are fetched from the TMDB movie API
 */

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;

public class MovieGrabber {

	public static void main(String[] args) throws IOException, InterruptedException {
		// get the api key (Put your own API key in here)
		String apiKey = System.getenv("TMDB_API_KEY");
		// if the key doesn't exist it will thrown an exception
		if (apiKey == null) throw new RuntimeException("Missing TMDB_API_KEY environment variable");
		
		// determine what category of movies the user is looking for
		String website = "";
		String category = args[0].toLowerCase();
		if (category.equals("playing")) website = "https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1";
		else if (category.equals("popular")) website = "https://api.themoviedb.org/3/movie/popular?language=en-US&page=1";
		else if (category.equals("top")) website = "https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1";
		else if (category.equals("upcoming")) website = "https://api.themoviedb.org/3/movie/upcoming?language=en-US&page=1";
		else {
			// of the input is invalid then exit the program
			System.out.println("Invalid input");
			System.exit(1);
		}

		try {
			// request the api
			HttpClient client = HttpClient.newHttpClient();
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(website))
					.timeout(Duration.ofSeconds(10))
					.header("accept", "application./json")
					.header("Authorization", "Bearer " + apiKey)
					.build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			// check for api errors
			int status = response.statusCode();
			// if status is 400 or greater it is an error so say that
			if (status >= 400) throw new RuntimeException("API Call Failed " + status + "\n" + response.body());
		
			// store all the data about each movie in an arrayList
			ArrayList<Movie> movies = new ArrayList<>();
			
			// get each JSON object
			JsonObject root = JsonParser.parseString(response.body()).getAsJsonObject();
			
			// get the array
			JsonArray results = root.getAsJsonArray("results");
			
			// loop through each JSON object and make a Movie object out of it
			for (JsonElement n : results) {
				Movie m = new Movie(n);
				
				// add that movie to the movies list
				movies.add(m);
				System.out.println(m.toString());
			}
		}
		catch (IOException e) {
			// if there was a network error when trying to acces the api
			throw new RuntimeException("Network Error: " + e.getMessage(), e);
		}
		catch (InterruptedException e) {
			// if the request was interrupted
			Thread.currentThread().interrupt();
			throw new RuntimeException("API Call Interrupted", e);
		}
	}
}