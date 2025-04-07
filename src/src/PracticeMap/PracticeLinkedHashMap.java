package PracticeMap;

import java.util.*;
public class PracticeLinkedHashMap {
    public static void main(String[] args) throws Exception {
        LinkedHashMap<String, String> linkedmap = new LinkedHashMap<>();

        linkedmap.put("LY2048303","John Wells");
        linkedmap.put("AB0649858","Lori Wells");
        linkedmap.put("AB4453455","David Windston");
        linkedmap.put("CS9857859","John Smith");
        linkedmap.put("LY9475958","Alen Cornworth");

        //print Map content
        printMap(linkedmap);

        //change content with a key
        linkedmap.put("CS9857859","Lydia Apple");
        printMap(linkedmap);


    }

    public static void printMap(LinkedHashMap map){
        int index =1;
        System.out.println("\n THE WAITLIST \n");
        for(Object entryObject : map.entrySet()){
            Map.Entry entry = (Map.Entry) entryObject;

            System.out.println(index + " ID:" + entry.getKey() + " Name:" + entry.getValue());
            index++;
        }
    }
}
