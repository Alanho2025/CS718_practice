package quizMarker;

import java.io.IOException;

public class MultiChoiceQuestion implements IQuestion{
    String question = "Which of the following is true about Java interfaces?";
    String[] possibile_answer = new String[]{"All methods in interfaces must be public", "An interface method can have protected visibility","Fields in interfaces are by default private", "Interface methods cannot throw exceptions"};
    String correct_answer = "B";

    public MultiChoiceQuestion(String question, String[] possibile_answer, String correct_answer) {
        this.question = question;
        this.possibile_answer = possibile_answer;
        this.correct_answer = correct_answer;
    }



    public void printQuestion(){
        char letter = 'A';
        System.out.println(question);
        for(String answer : possibile_answer){
            System.out.println(letter + ") " + answer);
            letter ++;
        }
    }
    public boolean isValidAnswer(String UserAnswer){
        char letter = UserAnswer.charAt(0);
        return !((letter >= 'A' && letter <= 'D')||(letter >= 'a' && letter <= 'd'));
    }
    public boolean isCorrect(String UserAnswer){
        UserAnswer = UserAnswer.toUpperCase();
        return correct_answer.equals(UserAnswer);
    }
}
