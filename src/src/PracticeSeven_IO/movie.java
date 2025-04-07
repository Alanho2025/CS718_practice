package PracticeSeven_IO;

public class movie {
    private String name;
    private int year;
    private int lengthInMinutes;
    private String director;

    public movie(String name, int year, int lengthInMinutes, String director) {
        this.name = name;
        this.year = year;
        this.lengthInMinutes = lengthInMinutes;
        this.director = director;
    }

    public String toString() {
        return name + " (" + year + "), " + lengthInMinutes + " minutes, Director: " + director;
    }
    public String toCSVString() {
        return name + ", " + year + ", " + lengthInMinutes + " , " + director;
    }

    public boolean isOlderThan(movie other) {
        return year < other.year;
    }

    public boolean isMoreRecentThan(movie other) {
        return year > other.year;
    }

    public boolean isShorterThan(movie other) {
        return lengthInMinutes < other.lengthInMinutes;
    }

    public boolean isLongerThan(movie other) {
        return lengthInMinutes > other.lengthInMinutes;
    }

    public boolean equals(movie other) {
        return name.equals(other.name)
                && year == other.year
                && lengthInMinutes == other.lengthInMinutes
                && director.equals(other.director);
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public String getDirector() {
        return director;
    }
}
