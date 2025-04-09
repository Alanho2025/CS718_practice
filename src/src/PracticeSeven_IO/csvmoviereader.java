package PracticeSeven_IO;


import java.io.*;
import java.util.*;


/**
 * Created by anhyd on 20/03/2017.
 */
public class csvmoviereader extends movieReader{

    @Override
    protected movie[] loadMovies(String fileName) {

        // TODO Implement this with a Scanner
        List<String> movieList = new ArrayList<>();
        File movieFile = new File(fileName);
        try (Scanner scanner = new Scanner(movieFile)) {
            while (scanner.hasNextLine()) {
                movieList.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.getMessage();
        }

        movie[] movies = new movie[movieList.size()];

        for (int i = 0; i < movieList.size(); i++) {
            String movieData = movieList.get(i);

            String[] data = movieData.split(", ");
            String title = data[0];
            int year = Integer.parseInt(data[1]);
            int lengthInMinutes = Integer.parseInt(data[2]);
            String director = data[3];

            // Create a new Movie object and add it to the array
            movies[i] = new movie(title, year, lengthInMinutes, director);
        }

        return movies;

    }

    public static void main(String[] args) {
        new csvmoviereader().start();
    }
}