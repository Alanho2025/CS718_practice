package PracticeEight;

import java.util.Arrays;
import java.util.Iterator;

public class ArroaytoStrings {
    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "four", "five", "six", "seven"};

        normal_for_loop(array);
        enhance_for_loop(array);
        iterator(array);


    }
    private static void normal_for_loop(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    private static void enhance_for_loop(String[] array) {
        for (String element : array) {
            System.out.println(element);
        }
    }
    private static void iterator(String[] array) {
        Iterator<String> iterator = Arrays.asList(array).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
