movie-grabber:

  A command-line tool that fetches movie data from The Movie Database (TMDB) API and prints clean, formatted results directly in your terminal. Quickly check what’s now playing, popular, top-rated, or upcoming with a single command.

Features:

  Fetches movies by category:
  
    Now Playing
    
    Popular
    
    Top Rated
    
    Upcoming

  Simple CLI usage: MovieGrabber category
  
  Nicely formatted movie output

  Clear error messages for:
  
    Invalid arguments
    
    Network failures
    
    API errors

Requirements:

  Java 17+
  
  A TMDB API key
  
  Internet connection
  
  gson-2.13.1.jar (JSON parsing)

Installation:

  Clone the repository:
  
  git clone https://github.com/Tate-Smith/movie-grabber.git
  cd movie-grabber
  
  
  Add your TMDB API key as an environment variable:
  
  export TMDB_API_KEY="your_api_key_here"
  
  
  Download gson-2.13.1.jar and place it in your project directory or set it in your IDE’s build path.

Supported categories:

  playing
  
  popular
  
  top
  
  upcoming

Sample Output (Now Playing)
```
+--------------------------------------------------------------------------------------------------+
| Title: Troll 2                                                                                   |
| Release Date: 2025-11-30                                                                         |
| Rating: 6.82                                                                                     |
| Adult: false                                                                                     |
| When a dangerous new troll unleashes devastation across their homeland, Nora, Andreas and        |
| Kris embark on their most perilous mission yet.                                                  |
+--------------------------------------------------------------------------------------------------+

+--------------------------------------------------------------------------------------------------+
| Title: Zootopia 2                                                                                |
| Release Date: 2025-11-26                                                                         |
| Rating: 7.69                                                                                     |
| Adult: false                                                                                     |
| After cracking the biggest case in Zootopia's history, Judy Hopps and Nick Wilde find            |
| themselves on the twisting trail of a great mystery when Gary De’Snake arrives and turns the     |
| metropolis upside down...                                                                        |
+--------------------------------------------------------------------------------------------------+

+--------------------------------------------------------------------------------------------------+
| Title: Five Nights at Freddy's 2                                                                 |
| Release Date: 2025-12-03                                                                         |
| Rating: 6.40                                                                                     |
| Adult: false                                                                                     |
| One year after the nightmare at Freddy Fazbear's Pizza, Abby sneaks out to reconnect with the    |
| animatronics—setting off a new chain of terrifying events.                                       |
+--------------------------------------------------------------------------------------------------+
```
(Your real output will list many more movies)

Error Handling:

  The tool provides clear feedback when:
  
    The category is invalid
    
    The API key is missing
    
    The TMDB service is unavailable
    
    The network connection fails

Project Credit: https://roadmap.sh/projects/tmdb-cli
