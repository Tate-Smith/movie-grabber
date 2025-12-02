# movie-grabber

A simple command-line application that fetches movie data from **The Movie Database (TMDB)** API and displays it directly in your terminal. This tool supports multiple movie categories and provides a clean, fast way to check what's trending, popular, or coming soon.

---

## Features

* Fetches movies from TMDB by category:

  * **Now Playing**
  * **Popular**
  * **Top Rated**
  * **Upcoming**
* Simple command-line interface using `--type <category>`.
* Graceful error handling for invalid requests, API outages, or network issues.

---

## Requirements

* A programming language runtime (Python, JavaScript, etc.)
* A TMDB API key
* Internet connection

---

## Installation

1. Clone the repository:

   ```bash
   git clone <your-repo-url>
   cd tmdb-cli
   ```

2. Add your TMDB API key as an environment variable:

   ```bash
   export TMDB_API_KEY="your_api_key_here"
   ```

3. Make the CLI script executable (if applicable):

   ```bash
   chmod +x tmdb-app
   ```

---

## Usage

Run the tool from your terminal using the `--type` flag.

Supported types:

* `playing` — now playing movies
* `popular` — popular movies
* `top` — top-rated movies
* `upcoming` — upcoming releases

### Examples

```bash
tmdb-app --type playing
tmdb-app --type popular
tmdb-app --type top
tmdb-app --type upcoming
```

---

## Error Handling

The CLI tool is designed to:

* Detect invalid or missing flags
* Handle network issues cleanly
* Report API failures with informative messages

---

## Project Goals

This project helps practice:

* Consuming REST APIs
* Working with JSON data
* Building CLI applications
* Structuring small but real-world projects

---

## License

This project is released under your preferred license (MIT recommended).
