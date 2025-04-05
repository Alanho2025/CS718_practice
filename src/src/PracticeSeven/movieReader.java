package PracticeSeven;

import PracticeFour.Keyboard;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class movieReader {
    public static void main(String[] args) {
        new movieReader().start();
    }
    public void start() {
        // Get a file name from the user
        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();

        // Load the movie data
        movie[] films = loadMovies(fileName);

        // Do some stuff with the data to check that its working
        printMoviesArray(films);
        movie mostRecentMovie = getRecentMovie(films);
        movie longestMovie = getLongestMovie(films);
        printResults(mostRecentMovie, longestMovie);
        System.out.println();
        printDirector("Searching for Sugar Man", films);
        printDirector("Liberal Arts", films);
        printDirector("The Intouchables", films);
    }
    protected movie[] loadMovies(String fileName) {
        try (DataInputStream in = new DataInputStream(new FileInputStream(fileName))) {
            // step 1: read movie count in the file
            int movieCount = in.readInt();
            movie[] movies = new movie[movieCount];

            // step by step to read movie information
            for (int i = 0; i < movieCount; i++) {
                String title = in.readUTF();      // read movie title
                int year = in.readInt();          // read movie pop up year
                int duration = in.readInt();      // read lenth minutes
                String director = in.readUTF();   // read the director

                // create an object to save in an array
                movies[i] = new movie(title, year,duration, director);
            }

            System.out.println("Movies loaded successfully from " + fileName + "!");
            return movies;

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new movie[0];  // 若發生錯誤，回傳空陣列避免程式崩潰
        }
    }
    private void printMoviesArray(movie[] film) {
        System.out.println("Movie Collection");
        System.out.println("================");
        // Step 2.  Complete the printMoviesArray() method
        for (movie Film: film){
            System.out.println(Film.toString());
        }
    }
    private movie getLongestMovie(movie[] film){
        // Step 4.  Complete the getLongest() method.
        movie temp=null;
        //enhance for loop
        for (movie m : film) {
            if (m == null) continue; // 防止 null pointer

            if (temp == null || m.isLongerThan(temp)) {
                temp = m;
            }
        }
        return temp;
    }
    private movie getRecentMovie(movie[] film){
        // Step 3.  Complete the getMostRecentMovie() method.
        movie temp=null;
        // normal for loop
        /*for(int i = 1; i<film.length; i++){
            if(film[i].isMoreRecentThan(film[i-1])){
                temp = film[i];
            }
        }*/
        //enhance for loop
        for (movie m : film) {
            if (m == null) continue; // 防止 null pointer

            if (temp == null || m.isMoreRecentThan(temp)) {
                temp = m;
            }
        }
        return temp;
    }
    private void printResults(movie mostRecent, movie longest) {
        System.out.println();
        System.out.println("The most recent movie is: " + mostRecent.toString());
        System.out.println("The longest movie is: " + longest.toString());
    }
    private void printDirector(String movieName, movie[] films) {
        // Step 5. Complete the printDirector() method
        for (movie film : films) {
            if (movieName.equals(film.getName())) {
                System.out.println(movieName + " was directed by " + film.getDirector());
                return;
            }
        }
        System.out.println(movieName + " is not in the collection.");
    }
}
