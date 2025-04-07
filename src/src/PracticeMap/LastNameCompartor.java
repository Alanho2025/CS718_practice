package PracticeMap;

import java.util.Comparator;

public class LastNameCompartor implements Comparator {
    public int compare(Object o1, Object o2) {
        String fullName1 = o1.toString();
        String fullName2 = o2.toString();

        String lastName1 = lastName(fullName1);
        String lastName2 = lastName(fullName2);

        return lastName1.compareTo(lastName2);
    }
    private String lastName(String fullName) {
        int lastSpaceIndex = fullName.lastIndexOf(" ");
        return fullName.substring(lastSpaceIndex + 1);
    }
}
