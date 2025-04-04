package PracticeSix;


import PracticeFour.Keyboard;

import java.util.*;

public class StringException {
    public static void main(String[] args) throws InvalidWordException, ExceedMaxLengthException {
        System.out.print("Enter a sting of at most 100 characters :");
        String shortSentence = Keyboard.readInput();
        errorcheck(shortSentence);
        String finalword = catchfirstchar(shortSentence);
        System.out.println(finalword);
    }
    public static void errorcheck(String shortSentence) throws ExceedMaxLengthException, InvalidWordException {
        char firstChar = shortSentence.charAt(0);
        if(Character.isDigit(firstChar)){
            throw new InvalidWordException("sentence cannot start with number");
        } else if (shortSentence.length() > 100) {
            throw new ExceedMaxLengthException("over the limit");
        }
    }

    // Catch each first char from the original sentence
    public static String catchfirstchar(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        StringBuilder initials = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                char firstChar = word.charAt(0);
                initials.append(firstChar).append(" ");
            }
        }
        return initials.toString().trim();
    }
}
