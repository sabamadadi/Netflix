package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<TVShow> tvshows = new ArrayList<TVShow>();
    static ArrayList<Movie> movies = new ArrayList<Movie>();

    static User currentUser;
    static Authenticator authenticator;

    public NetflixService() {
        authenticator = new Authenticator(this);
        currentUser = null;
    }

    public void addTVShow(){
        // Implement add TV show logic here
        TVShow new_tvshow = new TVShow();
        if(new_tvshow.correct == false) {
            return;
        }
        tvshows.add(new_tvshow);

        return;
    }

    public void addMovie(){
        // Implement add movie logic here
        Movie new_movie = new Movie();
        if(new_movie.correct == false) {
            return;
        }
        movies.add(new_movie);

        return;
    }

    public void createAccount() {
        // Implement create account logic here

        User new_User = authenticator.UserRegister();
        if(new_User != null) {
            users.add(new_User);
        }
        currentUser = new_User;
        return;
    }

    public boolean login() {
        // Implement login logic here
        currentUser = authenticator.Userlogin();

        if(currentUser != null) {
            return true;
        }
        return false;
    }

    public void logout() {
        // Implement logout logic here
        currentUser = null;

        return;
    }

    public ArrayList<TVShow> searchByTitleTVShow() {
        // Implement search by title logic here
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Title");
        String title = cs.nextLine();

        ArrayList<TVShow> Ans = new ArrayList<TVShow>();

        for(int i = 0; i < tvshows.size(); i++) {
            if(tvshows.get(i).title.equals(title)) {
                Ans.add(tvshows.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No TVShow with title of " + title + " exists.");
        }

        return Ans;
    }
    public ArrayList<Movie> searchByTitleMovie() {
        // Implement search by title logic here
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Title");
        String title = cs.nextLine();

        ArrayList<Movie> Ans = new ArrayList<Movie>();

        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).title.equals(title)) {
                Ans.add(movies.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No Movie with title of " + title + " exists.");
        }

        return Ans;
    }

    public ArrayList<TVShow> searchByGenreTVShow() {
        // Implement search by genre logic here
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Genre");
        String genre = cs.nextLine();

        ArrayList<TVShow> Ans = new ArrayList<TVShow>();

        for(int i = 0; i < tvshows.size(); i++) {
            if(tvshows.get(i).genre.equals(genre)) {
                Ans.add(tvshows.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No TVShow with genre of " + genre + " exists.");
        }

        return Ans;
    }
    public ArrayList<Movie> searchByGenreMovie() {
        // Implement search by genre logic here
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Genre");
        String genre = cs.nextLine();

        ArrayList<Movie> Ans = new ArrayList<Movie>();

        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).genre.equals(genre)) {
                Ans.add(movies.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No Movie with genre of " + genre + " exists.");
        }

        return Ans;
    }

    public ArrayList<TVShow> searchByReleaseYearTVShow() {
        // Implement search by release year logic here
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Release year");
        int year = Integer.parseInt(cs.nextLine());

        ArrayList<TVShow> Ans = new ArrayList<TVShow>();

        if(year < 0 || year > 2023) {
            System.out.println("Invalid input");
            return Ans;
        }

        for(int i = 0; i < tvshows.size(); i++) {
            if(tvshows.get(i).release_year == year) {
                Ans.add(tvshows.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No TVShow in year of " + year + " exists.");
        }

        return Ans;
    }
    public ArrayList<Movie> searchByReleaseYearMovie() {
        // Implement search by release year logic here
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Release year");
        int year = Integer.parseInt(cs.nextLine());

        ArrayList<Movie> Ans = new ArrayList<Movie>();

        if(year < 0 || year > 2023) {
            System.out.println("Invalid input");
            return Ans;
        }

        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).release_year == year) {
                Ans.add(movies.get(i));
            }
        }

        if(Ans.size() == 0) {
            System.out.println("No Movie in year of " + year + " exists.");
        }

        return Ans;
    }
}

