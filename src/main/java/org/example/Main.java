package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //don't limit yourself to our template ***


    static NetflixService service;

    public static void main(String[] args) {
        service = new NetflixService();

        while(true) {
            if(runMenu()) {
                break;
            }
        }
    }

    public static void showTVShows(ArrayList<TVShow> shows) {
        for(int i = 0; i < shows.size(); i++) {
            shows.get(i).show();
        }
        return;
    }
    public static void showMovies(ArrayList<Movie> shows) {
        for(int i = 0; i < shows.size(); i++) {
            shows.get(i).show();
        }
        return;
    }

    public static boolean runMenu(){
        Scanner cs = new Scanner(System.in);
        if(service.currentUser == null) {
            System.out.println("1. User Login");
            System.out.println("2. User Register");
            System.out.println("3. Exit");
            int input = Integer.parseInt(cs.nextLine());

            if(input == 1) {
                service.login();
            }
            else if(input == 2) {
                service.createAccount();
            }
            else if(input == 3) {
                return true;
            }
            else {
                System.out.println("Invalid input");
            }
        }
        else {
            System.out.println("1. Add TVShow");
            System.out.println("2. Add Movie");
            System.out.println("3. Search TVShows by title");
            System.out.println("4. Search TVShows by genre");
            System.out.println("5. Search TVShows by release year");
            System.out.println("6. Search Movies by title");
            System.out.println("7. Search Movies by genre");
            System.out.println("8. Search Movies by release year");
            System.out.println("9. Search Favorite TVShows by title");
            System.out.println("10. Search Favorite TVShows by genre");
            System.out.println("11. Search Favorite TVShows by release year");
            System.out.println("12. Search Favorite Movies by title");
            System.out.println("13. Search Favorite Movies by genre");
            System.out.println("14. Search Favorite Movies by release year");
            System.out.println("15. Add TVShow to Favorites");
            System.out.println("16. Watch TVShow");
            System.out.println("17. Show Favorite TVShows");
            System.out.println("18. Get Recomendation TVShows");
            System.out.println("19. Add Movie to Favorites");
            System.out.println("20. Watch Movie");
            System.out.println("21. Show Favorite Movies");
            System.out.println("22. Get Recomendation Movies");
            System.out.println("23. Logout");

            int input = Integer.parseInt(cs.nextLine());

            if(input == 1) {
                service.addTVShow();
            }
            else if(input == 2) {
                service.addMovie();
            }
            else if(input == 3) {
                ArrayList<TVShow> Ans = service.searchByTitleTVShow();
                showTVShows(Ans);
            }
            else if(input == 4) {
                ArrayList<TVShow> Ans = service.searchByGenreTVShow();
                showTVShows(Ans);
            }
            else if(input == 5) {
                ArrayList<TVShow> Ans = service.searchByReleaseYearTVShow();
                showTVShows(Ans);
            }
            else if(input == 6) {
                ArrayList<Movie> Ans = service.searchByTitleMovie();
                showMovies(Ans);
            }
            else if(input == 7) {
                ArrayList<Movie> Ans = service.searchByGenreMovie();
                showMovies(Ans);
            }
            else if(input == 8) {
                ArrayList<Movie> Ans = service.searchByReleaseYearMovie();
                showMovies(Ans);
            }
            else if(input == 9) {
                ArrayList<TVShow> Ans = service.currentUser.searchByTitleTVShow();
                showTVShows(Ans);
            }
            else if(input == 10) {
                ArrayList<TVShow> Ans = service.currentUser.searchByGenreTVShow();
                showTVShows(Ans);
            }
            else if(input == 11) {
                ArrayList<TVShow> Ans = service.currentUser.searchByReleaseYearTVShow();
                showTVShows(Ans);
            }
            else if(input == 12) {
                ArrayList<Movie> Ans = service.currentUser.searchByTitleMovie();
                showMovies(Ans);
            }
            else if(input == 13) {
                ArrayList<Movie> Ans = service.currentUser.searchByGenreMovie();
                showMovies(Ans);
            }
            else if(input == 14) {
                ArrayList<Movie> Ans = service.currentUser.searchByReleaseYearMovie();
                showMovies(Ans);
            }
            else if(input == 15) {
                service.currentUser.addToFavoritesTVShow();
            }
            else if(input == 16) {
                service.currentUser.watchTvShow();
            }
            else if(input == 17) {
                service.currentUser.viewFavoritesTVShow();
            }
            else if(input == 18) {
                ArrayList<TVShow> Ans = service.currentUser.getRecommendationTVShows();
                showTVShows(Ans);
            }
            else if(input == 19) {
                service.currentUser.addToFavoritesMovie();
            }
            else if(input == 20) {
                service.currentUser.watchMovie();
            }
            else if(input == 21) {
                service.currentUser.viewFavoritesMovie();
            }
            else if(input == 22) {
                ArrayList<Movie> Ans = service.currentUser.getRecommendationMovies();
                showMovies(Ans);
            }
            else if(input == 23) {
                service.logout();
            }
            else {
                System.out.println("Invalid input");
            }
        }
        return false;
    }
}
