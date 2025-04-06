package quizMarker;

import classExerciseIO.Customer;

public interface IQuestion {
    public void printQuestion();
    public boolean isValidAnswer(String UserAnswer);
    public boolean isCorrect(String UserAnswer);
}
