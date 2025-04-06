package ClassExercise;

import PracticeFour.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class Classexercise1 {
    public static void main(String[] args) {
        Classexercise1 exercises = new Classexercise1();

            //Ex 1.
            System.out.println();
            System.out.println("Exercise 1");
            exercises.printEvenNumberAverage();
            System.out.println();


            //Ex.2
            System.out.println("Exercise 2");
            String userChoice = exercises.getUserInput();
            System.out.println("User's choice is " + userChoice);
            System.out.println();


            //Ex.3
            System.out.println("Exercise 3");
            exercises.printOddNumbers();
            System.out.println();


            //Ex.4
            System.out.println("Exercise 4");
            exercises.printFactorials();
            System.out.println();


        }



        /** Todo: Ex.1 write a method that calculates the average of all even numbers between 1 - 20.
         */
        private void printEvenNumberAverage(){
            int[] number = new int[20];
            for (int i = 0; i < 20; i++) {
                number[i] = i+1;
            }
            int sum = 0;
            int count = 0;
            for (int i = 0; i < number.length; i++) {
                if (number[i] % 2 == 0) {
                    sum += number[i];
                    count++;
                }
            }
            int average = sum / count;
            System.out.println(average);

        }

        /** Todo: Ex.2 write a method prompts the user to enter Y or N.
         *             If user's input is not Y or N, they should be re-prompted.
         */
        private String getUserInput(){
            System.out.print("Please enter a string (Y or N): ");
            while(true){
                String value = Keyboard.readInput();
                if(value.equals("Y") || value.equals("y")){
                    return value;
                }else{
                    System.out.println("type again");
                }
            }
        }

        /** Todo: Ex.3 write a method that prompts the user to enter 2 integers.
         *             Then, print all odd numbers between two given value (inclusive).
         */
        private void printOddNumbers(){
           System.out.print("Please enter the lower limit: ");
           int lower_limit = Integer.parseInt(Keyboard.readInput());
           System.out.print("Please enter the upper limit: ");
           int upper_limit = Integer.parseInt(Keyboard.readInput());
           List<Integer> numbers = new ArrayList<>();
           for (int i = lower_limit; i <= upper_limit; i++) {
               if(i%2!=0){
                   numbers.add(i);
               }
           }
           System.out.println(numbers);
        }

        /** Todo: Ex.4 write a method that prints factorials from 1! to 10!
         */
        private void printFactorials(){
            int factorial = 1;
            for (int i = 1; i <= 10 ; i++) {
                factorial *= i;
                System.out.println(i + "! = " + factorial);
            }
        }
}

