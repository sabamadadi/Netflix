package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Movie extends TVShow {
    /*
     *Movie is extended from TVShow and has extra attribute length.
     */
    int length;

    public Movie()
    {
        super();
        if(!correct) {
            return;
        }
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Length");
        length = Integer.parseInt(cs.nextLine());
        if(length < 0) {
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
        System.out.println("Length: " + length);
        return;
    }
    public boolean EQ(Movie show) {
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
        if(show.length != length) {
            return false;
        }

        return true;
    }
}
