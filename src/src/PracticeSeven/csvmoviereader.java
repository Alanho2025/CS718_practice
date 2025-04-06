package PracticeSeven;
import PracticeSeven.movie;
import PracticeSeven.moviewriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class csvmoviereader extends movieReader {
    public static void main(String[] args) {
        new csvmoviereader().start();
    }
    // TODO Implement this with a Scanner
    @Override
    protected movie[] loadMovies(String fileName) {
        List<movie> movies = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {

            // We read the number of movies from the first line. Alternatively we could use a collection, such as a List.
            // That way we wouldn't need to know how many movies there were in advance.
            String firstLine = scanner.nextLine();
            int len = "Number of movies: ".length();
            String sNumMovies = firstLine.substring(len);
            int numMovies = Integer.parseInt(sNumMovies);
            movie[] films = new movie[numMovies];

            scanner.useDelimiter(",|\\r\\n");
            for (int i = 0; i < films.length; i++) {

                films[i] = new movie(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.next());

            }

            return films;

        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }
}
