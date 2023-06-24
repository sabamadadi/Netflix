package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class TVShow {
    /*
     *The TVShow should have a title , genre, release year, duration and a rating.
     *The TVShow should have an ArrayList of the cast.
     */

    String title;
    String genre;
    int release_year;
    int duration;
    int rating;
    static boolean correct;
    static ArrayList<String> cast = new ArrayList<String>();

    public TVShow() {
        correct = true;
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Title");
        title = cs.nextLine();
        System.out.println("Enter Genre");
        genre = cs.nextLine();
        System.out.println("Enter Release year");
        release_year = Integer.parseInt(cs.nextLine());
        if(release_year < 0 || release_year > 2023) {
            System.out.println("Invalid input");
            correct = false;
            return;
        }
        System.out.println("Enter Duration in minutes");
        duration = Integer.parseInt(cs.nextLine());
        if(duration < 0) {
            System.out.println("Invalid input");
            correct = false;
            return;
        }
        System.out.println("Enter Rating");
        rating = Integer.parseInt(cs.nextLine());
        if(rating < 0) {
            System.out.println("Invalid input");
            correct = false;
        }
    }

    public void show() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Release Year: " + release_year);
        System.out.println("Duration: " + duration);
        System.out.println("Rating: " + rating);
        return;
    }

    public boolean EQ(TVShow show) {
        if(show.duration != duration) {
            return false;
        }
        if(!show.title.equals(title)) {
            return false;
        }
        if(!show.genre.equals(genre)) {
            return false;
        }
        if(show.release_year != release_year) {
            return false;
        }
        if(show.rating != rating) {
            return false;
        }

        return true;
    }
}