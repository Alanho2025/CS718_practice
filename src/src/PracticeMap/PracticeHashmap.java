package PracticeMap;

import java.util.*;

public class PracticeHashmap {
    public static void main(String[] args) {
        //Create a Hashmap
        HashMap<String,String> map = new HashMap<>();

        //Adding songs as key-value pairs
        map.put("Satisfaction", "The Rolling Stone");
        map.put("Yesterday", "Ray Charles");
        map.put("Money", "Pink Floyd");
        map.put("The end", "The Doors");
        map.put("Deuce", "KISS");

        //Print the song titles an artists
        System.out.println(map);

        //Replace a Hashmap value with existing mapping
        String artistName = map.put("Yesterday", "The Beatless");
        System.out.println(artistName);
        System.out.println(map);

        //check contains
        artistName = map.replace("hate", "The Rolling Stone");
        System.out.println(artistName);
        System.out.println(map);

        boolean isKey = map.containsKey("Yesterday");
        System.out.println(isKey);
        isKey = map.containsKey("hate");
        System.out.println(isKey);

        //check map size
        int size = map.size();
        System.out.println(size);

        //clear the Hashmap
        map.clear();
        System.out.println(map);

        boolean isempty = map.isEmpty();
        System.out.println(isempty);
    }
}
