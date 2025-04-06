package Practiceten;

import java.util.Map;
import java.util.TreeMap;

public class Mapping {
    private Map<Character, Integer> getCharacterFrequencies(String text) {

        // Ignore case. We need only deal with uppercase letters now, after this line.
        text = text.toUpperCase();

        // Initialize the frequencies map to an appropriate concrete instance
        Map<Character, Integer> frequencies = new TreeMap<>();

        // Loop through all characters in the given string
        for (char c : text.toCharArray()) {
            // If c is alphanumeric...
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {

                // If the map already contains c as a key, increment its value by 1.
                // Otherwise, add it as a new key with the initial value of 1.
                if (frequencies.containsKey(c)) {
                    frequencies.put(c, frequencies.get(c) + 1);
                } else {
                    frequencies.put(c, 1);
                }

            }
        }
        // BONUS: Add any missing keys to the map
        // (i.e. loop through all characters from A-Z and 0-9. If that character doesn't appear in the text,
        // add it as a key here with frequency 0).
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!frequencies.containsKey(c)) {
                frequencies.put(c, 0);
            }
        }
        for (char c = '0'; c <= '9'; c++) {
            if (!frequencies.containsKey(c)) {
                frequencies.put(c, 0);
            }
        }

        return frequencies;
    }
    /**
     * Prints the given map in a user-friendly table format.
     *
     * @param frequencies the map to print
     */
    private void printFrequencies(Map<Character, Integer> frequencies) {

        System.out.println("Char:\tFrequencies:");
        System.out.println("--------------------");

        // Loop through the entire map and print out all the characters (keys)
        // and their frequencies (values) in a table.
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            System.out.println("'" + entry.getKey() + "'\t\t" + entry.getValue());
        }

    }


    /**
     * Main program flow. Do not edit.
     */
    private void start() {
        Map<Character, Integer> frequencies = getCharacterFrequencies(Constants.TEXT);
        printFrequencies(frequencies);
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        new Mapping().start();
    }
}
