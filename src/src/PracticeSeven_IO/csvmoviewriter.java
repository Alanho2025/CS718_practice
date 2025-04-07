package PracticeSeven_IO;

import java.io.*;


public class csvmoviewriter extends moviewriter {
    public static void main(String[] args) {
        new csvmoviewriter().start();
    }
    // TODO Implement this with a PrintWriter
    @Override
    protected void saveMovies(String fileName, movie[] films) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (movie movie : films) {
                writer.print(movie.getName());
                writer.print(',');
                writer.print(movie.getYear());
                writer.print(',');
                writer.print(movie.getLengthInMinutes());
                writer.print(',');
                writer.println(movie.getDirector());
            }
            System.out.println("Movies saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
