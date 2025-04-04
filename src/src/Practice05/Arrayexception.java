package Practice05;

/**
 * A simple program that generates an array of random numbers, then displays
 * one of them (user's choice).
 */


public class Arrayexception {
}


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