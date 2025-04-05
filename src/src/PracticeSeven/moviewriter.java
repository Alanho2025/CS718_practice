package PracticeSeven;
import java.io.*;
import java.util.*;
import PracticeFour.Keyboard;

public class moviewriter {
    public static void main(String[] args) {
        new moviewriter().start();
    }
    public void start() {
        // Get a file name from the user
        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();

        // Create and fill Movies array
        movie[] films = getmovieData();

        // Saves the movies
        saveMovies(fileName, films);
    }
    /**
     * Returns an array with a bunch of hard-coded movie data
     */
    private movie[] getmovieData() {
        movie[] films = new movie[19];
        films[17] = new movie("The Intouchables",2011,112,"Olivier Nakache and Eric Toledano");
        films[6] = new movie("From Russia With Love",1963,110,"Terence Young");
        films[14] = new movie("The Long Voyage Home",1940,105,"John Ford");
        films[9] = new movie("Easy Rider",1969,94,"Dennis Hopper");
        films[3] = new movie("Dark Shadows",2012,113,"Tim Burton");
        films[10] = new movie("Walk the Line",2005,136,"James Mangold");
        films[5] = new movie("The Help",2011,137,"Tate Taylor");
        films[0] = new movie("Meet the Parents",2000,107,"Jay Roach");
        films[7] = new movie("The King's Speech",2011,118,"Tom Hooper");
        films[8] = new movie("Charlie and the Chocolate Factory",2005,115,"Tim Burton");
        films[2] = new movie("Alice In Wonderland",2009,109,"Tim Burton");
        films[4] = new movie("The Iron Lady",2011,105,"Phylliday Lloyd");
        films[11] = new movie("Kaikohe Demolition",2004,52,"Florian Habicht");
        films[12] = new movie("Brokeback Mountain",2005,134,"Ang Lee");
        films[13] = new movie("Gladiator",2000,154,"Ridley Scott");
        films[1] = new movie("The Parent Trap",1961,129,"David Swift");
        films[15] = new movie("Happy-Go-Lucky",2008,118,"Mike Leigh");
        films[16] = new movie("The Big Wedding",2013,89,"Justin Zackham");
        films[18] = new movie("Searching for Sugar Man",2012,86,"Malik Bendjelloul");
        return films;
    }
    /**
     * Saves the movies to the given file.
     */
    protected void saveMovies(String fileName, movie[] films) {
        //This opens a file (whose name is stored in fileName) for writing in binary format.
        //The try block uses try-with-resources, which automatically closes the stream afterward (a good practice to avoid memory leaks).
        //DataOutputStream lets you write primitive types (like int, UTF String, etc.) in a portable, machine-independent way.
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))){
            //First, we write the total number of movies in the array films to the file.
            //This lets the program know how many movies to read later when loading the file.
            out.writeInt(films.length);
            //A for-each loop going through each movie object in the films array.
            for (movie movie : films) {
                //We skip null entries in the array (just in case the array has unused slots).
                if(movie!=null) {
                    out.writeUTF(movie.getName());  // Write the movie's name as a UTF-8 encoded string.
                    out.writeInt(movie.getYear());  // Write the release year of the movie as an integer.
                    out.writeInt(movie.getLengthInMinutes());  // Write the duration of the movie in minutes.
                    out.writeUTF(movie.getDirector());  // Write the director's name as a UTF-8 encoded string.
                }
            }
         System.out.println("Movies saved successfully to " + fileName + "!"); //If everything worked, we print a success message to the console.
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
