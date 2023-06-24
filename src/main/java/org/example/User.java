package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    /*
     * The user should contain username password.
     * The user should contain an ArrayList of favorite shows and watch history.
     * FUNCTION: the user should have a function to watch a show and add it to watch history.
     *  *** NOTE: All search functions in user are for searching in favorite shows ***
     */

    static String username;
    static int password;
    static NetflixService service;
    static ArrayList<TVShow> favorites_tvshow = new ArrayList<TVShow>();
    static ArrayList<TVShow> history_tvshow = new ArrayList<TVShow>();
    static ArrayList<Movie> favorites_movie = new ArrayList<Movie>();
    static ArrayList<Movie> history_movie = new ArrayList<Movie>();


    public User(String input_username, int input_password, NetflixService input_service) {
        service = input_service;
        username = input_username;
        password = input_password;
    }

    public ArrayList<TVShow> searchByTitleTVShow() {
        // Implement search by title in favorite shows  logic here
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Title");
        String title = cs.nextLine();

        ArrayList<TVShow> Ans = new ArrayList<TVShow>();

        for(int i = 0; i < favorites_tvshow.size(); i++) {
            if(favorites_tvshow.get(i).title.equals(title)) {
                Ans.add(favorites_tvshow.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No TVShow with title of " + title + " exists.");
        }

        return Ans;
    }
    public ArrayList<TVShow> searchByGenreTVShow() {
        // Implement search by genre in favorite shows  logic here

        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Genre");
        String genre = cs.nextLine();

        ArrayList<TVShow> Ans = new ArrayList<TVShow>();

        for(int i = 0; i < favorites_tvshow.size(); i++) {
            if(favorites_tvshow.get(i).genre.equals(genre)) {
                Ans.add(favorites_tvshow.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No TVShow with genre of " + genre + " exists.");
        }

        return Ans;
    }
    public ArrayList<TVShow> searchByReleaseYearTVShow() {
        // Implement search by release year in favorite shows logic here

        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Release year");
        int year = Integer.parseInt(cs.nextLine());

        ArrayList<TVShow> Ans = new ArrayList<TVShow>();

        if(year < 0 || year > 2023) {
            System.out.println("Invalid input");
            return Ans;
        }

        for(int i = 0; i < favorites_tvshow.size(); i++) {
            if(favorites_tvshow.get(i).release_year == year) {
                Ans.add(favorites_tvshow.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No TVShow in year of " + year + " exists.");
        }

        return Ans;
    }
    public void addToFavoritesTVShow() {
        // Implement add to favorites logic here

        ArrayList<TVShow> shows = service.searchByTitleTVShow();

        for(int i = 0; i < shows.size(); i++) {
            favorites_tvshow.add(shows.get(i));
        }

        return;
    }
    public void watchTvShow() {
        ArrayList<TVShow> shows = service.searchByTitleTVShow();

        for(int i = 0; i < shows.size(); i++) {
            history_tvshow.add(shows.get(i));
        }

        return;
    }
    public void viewFavoritesTVShow() {
        // Implement view favorites logic here

        if(favorites_tvshow.size() == 0) {
            System.out.println("No favorite tvshow");
        }

        for(int i = 0; i < favorites_tvshow.size(); i++) {
            favorites_tvshow.get(i).show();
        }

        return;
    }
    public ArrayList<TVShow> getRecommendationTVShows() {
        // Implement get recommendations logic here
        ArrayList<TVShow> Ans = new ArrayList<TVShow>();

        for(int i = 0; i < favorites_tvshow.size(); i++) {
            boolean flag = true;
            for(int j = 0; j < history_tvshow.size(); j++) {
                if(favorites_tvshow.get(i).EQ(history_tvshow.get(j))) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                Ans.add(favorites_tvshow.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No recomendation found.");
        }

        return Ans;
    }

    public ArrayList<Movie> searchByTitleMovie() {
        // Implement search by title in favorite shows  logic here
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Title");
        String title = cs.nextLine();

        ArrayList<Movie> Ans = new ArrayList<Movie>();

        for(int i = 0; i < favorites_movie.size(); i++) {
            if(favorites_movie.get(i).title.equals(title)) {
                Ans.add(favorites_movie.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No Movie with title of " + title + " exists.");
        }

        return Ans;
    }
    public ArrayList<Movie> searchByGenreMovie() {
        // Implement search by genre in favorite shows  logic here

        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Genre");
        String genre = cs.nextLine();

        ArrayList<Movie> Ans = new ArrayList<Movie>();

        for(int i = 0; i < favorites_movie.size(); i++) {
            if(favorites_movie.get(i).genre.equals(genre)) {
                Ans.add(favorites_movie.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No Movie with genre of " + genre + " exists.");
        }

        return Ans;
    }
    public ArrayList<Movie> searchByReleaseYearMovie() {
        // Implement search by release year in favorite shows logic here

        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Release year");
        int year = Integer.parseInt(cs.nextLine());

        ArrayList<Movie> Ans = new ArrayList<Movie>();

        if(year < 0 || year > 2023) {
            System.out.println("Invalid input");
            return Ans;
        }

        for(int i = 0; i < favorites_movie.size(); i++) {
            if(favorites_movie.get(i).release_year == year) {
                Ans.add(favorites_movie.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No Movie in year of " + year + " exists.");
        }

        return Ans;
    }
    public void addToFavoritesMovie() {
        // Implement add to favorites logic here
        ArrayList<Movie> shows = service.searchByTitleMovie();

        for(int i = 0; i < shows.size(); i++) {
            favorites_movie.add(shows.get(i));
        }

        return;
    }
    public void watchMovie() {
        ArrayList<Movie> shows = service.searchByTitleMovie();

        for(int i = 0; i < shows.size(); i++) {
            history_movie.add(shows.get(i));
        }

        return;
    }
    public void viewFavoritesMovie() {
        // Implement view favorites logic here
        if(favorites_movie.size() == 0) {
            System.out.println("No favorite movie");
        }

        for(int i = 0; i < favorites_movie.size(); i++) {
            favorites_movie.get(i).show();
        }

        return;
    }
    public ArrayList<Movie> getRecommendationMovies() {
        // Implement get recommendations logic here
        ArrayList<Movie> Ans = new ArrayList<Movie>();

        for(int i = 0; i < favorites_movie.size(); i++) {
            boolean flag = true;
            for(int j = 0; j < history_movie.size(); j++) {
                if(favorites_movie.get(i).EQ(history_movie.get(j))) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                Ans.add(favorites_movie.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No recomendation found");
        }

        return Ans;
    }
}
