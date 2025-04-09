package MockPracticalTest_DataAnalysis;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File dataFile = new File("Student_grades.csv");
        ArrayList<StudentRecord> studentRecords = new ArrayList<>();
        try (Scanner scanner = new Scanner(dataFile)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // skip header
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String code = parts[1].trim();
                    String name = parts[2].trim();
                    String gStr = parts[3].trim();

                    Grade g;
                    try {
                        g = Grade.valueOf(gStr);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Invalid grade: " + parts[3]);
                        continue;
                    }

                    Course course = new Course(code, name);
                    StudentRecord record = new StudentRecord(id, course, g);
                    studentRecords.add(record);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 測試輸出
        for (StudentRecord sr : studentRecords) {
            System.out.println(sr);
        }


        Map<Grade, Integer> gradeMap = new TreeMap<>();
        gradeMap.put(Grade.APLUS, 9);
        gradeMap.put(Grade.A, 8);
        gradeMap.put(Grade.AMINUS, 7);
        gradeMap.put(Grade.BPLUS, 6);
        gradeMap.put(Grade.B, 5);
        gradeMap.put(Grade.BMINUS, 4);
        gradeMap.put(Grade.CPLUS, 3);
        gradeMap.put(Grade.F, 1);

        double classAverage = 0;

        for(StudentRecord student : studentRecords) {
            classAverage = classAverage + gradeMap.get(student.getGrade());
        }
        classAverage = classAverage / studentRecords.size();
        System.out.println(classAverage);

        File newDataFile = new File("Student_grades_update.csv");
        try(PrintWriter log = new PrintWriter(newDataFile)){
            for (StudentRecord sr : studentRecords) {
                log.println(sr);
                log.print("\n");
            }
            log.println("-----------------\n");
            log.println("Average grade: " + classAverage + "\n");

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
