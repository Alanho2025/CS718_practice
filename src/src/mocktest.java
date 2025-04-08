import PracticeFour_exception.Keyboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class mocktest {
    public static void main(String[] args) {
        new mocktest().start();
    }

    public void start() {
        hashmap();
        readFile();
        //customexception();
        checkDay(Day.SATURDAY);
    }
    //practical test 1 Create a class called Person with fields name and age.
    //Use inheritance to create a Student class with additional fields: studentId and major.
    public class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public class Student extends Person {
        int studentId;
        String major;
        public Student(String name, int age, int studentId, String major) {
            super(name, age);
            this.studentId = studentId;
            this.major = major;
        }
    }

    //practical test 2 Write a method to read a text file line by line and print only the lines that contain the word "Java".
    public void readFile(){
        File myFile = new File("students.txt");
        try (Scanner scanner = new Scanner(myFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.contains("Java")) {
                    System.out.println(line);
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }

    //practical test 3  Implement a program that stores student names and grades in a HashMap, and then prints the list sorted by names.
    public void hashmap(){
        //Create a Hashmap
        HashMap<String,Integer> map = new HashMap<>();

        //Adding songs as key-value pairs
        map.put("Alan", 86);
        map.put("Beck", 76);
        map.put("Annie", 56);
        map.put("Soul", 96);
        map.put("Duck", 44);

        TreeMap<String,Integer> treeMap = new TreeMap<>(map);
        System.out.println(map);
        System.out.println(treeMap);
    }

    //practical test 4
    public void customexception() throws InvalidAgeException {
        int age = Integer.valueOf(Keyboard.readInput());
        if(age<0){
            throw new InvalidAgeException("age cannot be negative");
        }
    }

    //practical test 5
    public void checkDay(Day day) {
        switch(day) {
            case SATURDAY:
            case SUNDAY:
                System.out.println("It's the weekend!");
                break;
            default:
                System.out.println("It's a weekday.");
        }
    }
}
