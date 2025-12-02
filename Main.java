/*
 * Author: Tate Smith
 * Date: 12/2/25
 * Purpose: This project is meant to build a simple command line interface to display
 * information about 4 movie categories Playing, Popular, Top, Upcoming; all of these
 * are fetched from the TMDB movie API
 */

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main {

	public static void main(String[] args) {
		// get the api key (Put your own API key in here)
		String apiKey = System.getenv("TMDB_API_KEY");
		// if the key doesn't exist it will thrown an exception
		if (apiKey == null) throw new RuntimeException("Missing TMDB_API_KEY environment variable");
		
		// determine what category of movies the user is looking for
		String website = "";
		String category = args[1].toLowerCase();
		if (category.equals("now playing")) website = "https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1";
		else if (category.equals("popular")) website = "https://api.themoviedb.org/3/movie/popular?language=en-US&page=1";
		else if (category.equals("top rated")) website = "https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1";
		else if (category.equals("upcoming")) website = "https://api.themoviedb.org/3/movie/upcoming?language=en-US&page=1";
		else {
			// of the input is invalid then exit the program
			System.out.println("Invalid input");
			System.exit(1);
		}
		
		// request the api
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url(website)
		  .get()
		  .addHeader("accept", "application/json")
		  .build();

		Response response = client.newCall(request).execute();
	}

}
