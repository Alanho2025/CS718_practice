package PracticeFive;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple program that generates an array of random numbers, then displays
 * one of them (user's choice).
 */

/**
 * Gets an array index from the given user. Currently error-prone as it doesn't check whether the user
 * inputs valid numbers of the correct size.
 * <p>
 * TODO Follow these steps:
 * <ol>
 *     <li>Create three new checked Exception classes (i.e. extends Exception):
 *     <ul>
 *         <li>InvalidIndexException</li>
 *         <li>IndexTooLowException</li>
 *         <li>IndexTooHighException</li>
 *     </ul>
 *     </li>
 *     <li>Declare this method to throw these three kinds of exceptions (using the throws clause)</li>
 *     <li>Throw InvalidIndexException if the user doesn't enter an integer</li>
 *     <li>Throw IndexTooLowException if the user enters an integer that's too small to be a valid index</li>
 *     <li>Throw IndexTooHighException if the user enters an integer that's too large to be a valid index</li>
 * </ol>
 */


public class Arrayexception {
    public static void main(String[] args) throws InvalidIndexException, IndexTooHighException, IndexTooLowException {
        //call the Array
        List<Integer> Array = generateArrayList();
        //check value generate success
        System.out.println(Array);
        //User set index

        int index = 0;
        index = checkNumber(Array);

        System.out.println(index);
    }
    public static List<Integer> generateArrayList(){
        List<Integer> list = new ArrayList<>();
        //first value - five value
        for (int i = 0; i < 5; i++) {
            list.add((int)(Math.random()*1000));
        }
        return list;
    }
    public static int checkNumber(List<Integer> list) throws InvalidIndexException, IndexTooHighException, IndexTooLowException {
        int index = 0;
        boolean flag = false;
        while(!flag) {
            try {
                index = checkindex(index,list);
                flag = true;

            }catch(InvalidIndexException e) {
                System.out.println("Error: Invalid input! Please enter an integer.");
            } catch (IndexTooLowException e) {
                System.out.println("Error: Index too low! Must be at least 0.");
            } catch (IndexTooHighException e) {
                System.out.println("Error: Index too high! Max index is " + (list.size() - 1) + ".");
            }

        }
        return list.get(index);
    }
    public static int checkindex (int index,List<Integer> list) throws IndexTooLowException,IndexTooHighException, InvalidIndexException{
        try{
            System.out.println("type your choice of index");
            index = Integer.valueOf(Keyboard.readInput());
            if(index<0){
                throw new IndexTooLowException("Index Too Low");
            }else if(index>list.size()) {
                throw new IndexTooHighException("Index Too High");
            }
            return index;
        }catch(NumberFormatException e){
            throw new InvalidIndexException("Please enter a number");
        }
    }
}


