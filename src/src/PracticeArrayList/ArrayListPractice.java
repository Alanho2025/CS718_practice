package PracticeArrayList;
// this program is to practice ArrayList method including add, set, remove, clear, contains and indexof
// this program also tries the common data type such as String, number and object

import java.util.ArrayList;

public class ArrayListPractice {
    public static void main(String[] args) {
        //Simple Array with String
        ArrayList<String> StringArrayList = new ArrayList<>(5);
        for (int i = 0; i <= 5; i++) {
            DefaultElement(StringArrayList,i);
        }
        System.out.println("Original Array: " + StringArrayList);
        Addelement(StringArrayList, 3);
        System.out.println("Add one element Array: " + StringArrayList);
        System.out.println("Get third element in Array: " + StringArrayList.get(2));
        System.out.println("Reomve fourth element in Array: " + StringArrayList.remove(3));
        System.out.println("Current Array: " + StringArrayList);
        System.out.println("check Array size: " + StringArrayList.size());
        System.out.println("If Array contains Apple: " + StringArrayList.contains("Apple"));
        StringArrayList.set(0, "star"); // modify the array[0] element
        System.out.println("Array update first set: " + StringArrayList);

        //Simple Array with number
        ArrayList<Integer> IntegerArrayList = new ArrayList<>(5);
        IntegerArrayList.add(10);
        IntegerArrayList.add(20);
        IntegerArrayList.add(30);
        IntegerArrayList.add(40);
        IntegerArrayList.add(50);
        System.out.println("Original Array: " + IntegerArrayList);
        IntegerArrayList.clear();
        System.out.println("current Array: " + IntegerArrayList);

        //Array with object
        ArrayList<Friend> ObjectArrayList = new ArrayList<>();
        ObjectArrayList.add(new Friend("Alan","0102234568"));
        ObjectArrayList.add(new Friend("Alice","0204233568"));
        ObjectArrayList.add(new Friend("Andrew","0202214568"));
        System.out.println("Current Array: " + ObjectArrayList);

        int indexofSearch = ObjectArrayList.indexOf(new Friend("Alice","0204233568"));

        if (indexofSearch != -1) {
            String name = ObjectArrayList.get(indexofSearch).getName();
            System.out.println("The name is " + name);
        }

        ObjectArrayList.remove(0);
        System.out.println("After removal: " + ObjectArrayList);

        ObjectArrayList.remove(new Friend("Alice","0204233568"));
        System.out.println("After removal: " + ObjectArrayList);



    }

    private static void DefaultElement(ArrayList<String> StringArrayList, int index) {
        switch (index) {
            case 1:
                StringArrayList.add(ArrayContent.Apple.toString());
                break;
                case 2:
                    StringArrayList.add(ArrayContent.Banana.toString());
                    break;
                    case 3:
                        StringArrayList.add(ArrayContent.Orange.toString());
                        break;
                        case 4:
                            StringArrayList.add(ArrayContent.Pear.toString());
                            break;
                            case 5:
                                StringArrayList.add(ArrayContent.Grape.toString());
                                break;
        }

    }
    private static void Addelement(ArrayList<String> StringArrayList, int index) {

        StringArrayList.add(index, "pineapple");
    }
}
