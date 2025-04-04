package practicalOne;
import practicalOne.Keyboard;
//this application creates for practice Lab 3 ex 08
//Step includes below:
//generate a random number between 1 and 100.
//Declare a variable name guess
//initialize guess = 0;
//if guess not correct, Ask the user to enter the guess
//Greater than the value -> too high / less than the value -> too low / equal Perfect
//when end of the program print "Game over"
public class guessNumber {
    public static void main(String[] args) {
        guessNumber guessNumber = new guessNumber();
        guessNumber.start();
    }
    public void start() {
        int aim_value = generate_value();
        System.out.println("Game Started");
        int guess_value = 0;
        while (true) {
            System.out.println("Type your guess: ");
            try{
                guess_value = Integer.valueOf(Keyboard.readInput());
                comparison(aim_value,guess_value);
            }catch(NumberFormatException e){
                System.out.println("Type again");
            }
            if(aim_value == guess_value){
                break;
            }
        }
        System.out.println("Game Over");
    }
    //generate a random value for guessing
    public int generate_value(){
        return (int)(Math.random()*100);
    }
    //comparison the guess value amd aim value
    public void comparison(int aim_value, int guess_value){
        if(aim_value > guess_value){
            System.out.println("your number is less than the guess number");
        } else if (aim_value < guess_value) {
            System.out.println("your number is greater than the guess number");
        } else{
            System.out.println("Perfect");
        }
    }
}
