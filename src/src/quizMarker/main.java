package quizMarker;

import PracticeFour.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class main{

    public static void main(String[] args) {
        new main().start();
    }
    public void start() {
        List<MultiChoiceQuestion> questionset = createQuestions();
        String useranswer = "";
        int correct_amount = 0;
        int title_number = 1;
        boolean type_check = false;
        for (MultiChoiceQuestion question : questionset) {
            System.out.println("Question: " + title_number);
            title_number ++;
            System.out.println("Please answer the following question:");
            question.printQuestion();
            while(!type_check) {
                System.out.print("please answer: ");
                useranswer = Keyboard.readInput();
                if (!(question.isValidAnswer(useranswer))) {
                    type_check = true;
                }
                System.out.println("Type again");
            }
            type_check = false;
            System.out.print("Your answer is:" + useranswer);
            System.out.println(" ");
            if (question.isCorrect(useranswer)) {
                System.out.println("Correct");
                correct_amount ++;
            }else{
                System.out.println("Incorrect");
            }
        }
        System.out.print("You answered " + correct_amount + " out of " + questionset.size() + " questions correctly");

    }
    public List<MultiChoiceQuestion> createQuestions(){
        List<MultiChoiceQuestion> questions = new ArrayList<MultiChoiceQuestion>();
        MultiChoiceQuestion Question1 = new MultiChoiceQuestion("Which of the following is true about Java interfaces?", new String[]{"All methods in interfaces must be public", "An interface method can have protected visibility","Fields in interfaces are by default private", "Interface methods cannot throw exceptions"}, "B") ;
        MultiChoiceQuestion Question2 = new MultiChoiceQuestion("Which of the following statements are valid?", new String[]{"An abstract class can extend another abstract class", "An interface can extend a class","An abstract class must have at least one abstract method", "An interface can extend multiple interfaces"}, "A C") ;
        MultiChoiceQuestion Question3 = new MultiChoiceQuestion("Which keyword is used when a class chooses to partially implement an interface?", new String[]{"abstract", "final","extends", "static"}, "A") ;
        questions.add(Question1);
        questions.add(Question2);
        questions.add(Question3);
        return questions;
    }
}
