package PracticeMap;
import java.io.IOException;
import java.util.*;
public class PracticeTreemap {
    public static void main(String[] args) throws Exception {
        /* TreeMap TreeMap_1 = new TreeMap();

        TreeMap_1.put("Andrew", "New Zealand");
        TreeMap_1.put("Alan", "Taiwan");
        TreeMap_1.put("Alice", "Taiwan");
        TreeMap_1.put("Bervely", "China");
        TreeMap_1.put("Anson", "China");

        printTree(TreeMap_1);

        TreeMap TreeMap_2 = new TreeMap(new LastNameCompartor());
        TreeMap_2.put("Andrew He", "New Zealand");
        TreeMap_2.put("Alan Ho", "Taiwan");
        TreeMap_2.put("Alice Yea", "Japan");
        TreeMap_2.put("Bervely Liu", "China");
        TreeMap_2.put("Anson Chang", "Korea");

        printTree(TreeMap_2); */

        TreeMap<String, String> courses = new TreeMap<>();
        // Adding courses
        courses.put("CS101", "Introduction to Computer Science");
        courses.put("MATH201", "Calculus II");
        courses.put("ENG102", "English Literature");
        // Displaying all courses
        System.out.println("Course List: " + courses);
        // Updating a course name
        courses.put("ENG102", "Advanced English Literature");
        // Retrieving a course name by code
        String courseName = courses.get("CS101");
        System.out.println("Course CS101: " + courseName);
        // Removing a course
        courses.remove("MATH201");
        System.out.println("After removing MATH201: " + courses);

        //Advanced TreeMap
        TreeMap<Double, String> TreeMap_GPA = new TreeMap();
        TreeMap_GPA.put(3.75, "Andrew He");
        TreeMap_GPA.put(4.0, "Alan Ho");
        TreeMap_GPA.put(3.5, "Alice He");
        TreeMap_GPA.put(3.25, "Annie Chang");
        TreeMap_GPA.put(3.0, "Thomos Ye");

        printTree(TreeMap_GPA);

        Object lowestGAP = TreeMap_GPA.firstKey();
        Object name = TreeMap_GPA.get(lowestGAP);

        System.out.println("Lowest GAP: " + lowestGAP + " " + name);
        System.out.println();

        Object highest = TreeMap_GPA.lastKey();
        name = TreeMap_GPA.get(highest);

        System.out.println("Highest GAP: " + highest + " " + name);
        System.out.println();

        Object higherKey = TreeMap_GPA.higherKey(3.6);

        System.out.println(higherKey + " GAP is just higher than 3.6");
        System.out.println();

        Object lowerKey = TreeMap_GPA.lowerKey(3.6);

        System.out.println(lowerKey + " GAP is jsut lower than 3.6");
        System.out.println();
    }

    public static void printTree(TreeMap map){
        int index =1;
        System.out.println("\n REGISTERED STUDENTS \n");
        for(Object entryObject : map.entrySet()){
            Map.Entry entry = (Map.Entry) entryObject;

            System.out.println(index + " GPA value:" + entry.getKey() + " Country:" + entry.getValue());
            index++;
        }
        System.out.println();
    }
}
