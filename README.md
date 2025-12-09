movie-grabber

A lightweight command-line tool that fetches movie data from The Movie Database (TMDB) API and displays it directly in your terminal. It lets you quickly check what’s trending, popular, top-rated, or coming soon.

Features

Fetches movies from TMDB by category:

Now Playing

Popular

Top Rated

Upcoming

Simple CLI usage: MovieGrabber <category>

Graceful error handling for invalid input, network failures, and API errors

Requirements

Java

A TMDB API key

Internet connection

Gson (gson-2.13.1.jar) — required for JSON parsing

Installation

Clone the repository:

git clone https://github.com/Tate-Smith/movie-grabber.git


Export your TMDB API key:

export TMDB_API_KEY="your_api_key_here"


Download gson-2.13.1.jar and add it to your project build path
(available from Maven Central or the Gson GitHub page)

Usage

Run the tool from your terminal (after compiling or running via your IDE).

Supported categories:

playing — now playing

popular — popular movies

top — top-rated

upcoming — upcoming releases

Examples
MovieGrabber playing
MovieGrabber popular
MovieGrabber top
MovieGrabber upcoming

Error Handling

The tool:

Detects invalid or missing categories

Handles network outages cleanly

Reports API errors with descriptive messages
