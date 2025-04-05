package PracticeSeven;

import PracticeFour.Keyboard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PracticeSeven.movie;
import PracticeSeven.moviewriter;


public class csvmoviewriter extends moviewriter {
    public static void main(String[] args) {
        new csvmoviewriter().start();
    }
    // TODO Implement this with a PrintWriter
    @Override
    protected void saveMovies(String fileName, movie[] films) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (movie movie : films) {
                writer.println(movie.toCSVString());
            }
            System.out.println("Movies saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
