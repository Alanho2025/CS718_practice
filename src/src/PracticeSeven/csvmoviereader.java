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
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;  // 跳過空行

                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.err.println("Invalid CSV format in line: " + line);
                    continue;
                }

                try {
                    String title = parts[0].trim();
                    int year = Integer.parseInt(parts[1].trim());
                    int duration = Integer.parseInt(parts[2].trim());
                    String director = parts[3].trim();
                    movies.add(new movie(title, year, duration, director));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing numbers in line: " + line);
                }
            }
            System.out.println("Movies loaded successfully from " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + fileName);
        }
        return movies.toArray(new movie[0]);
    }
}
