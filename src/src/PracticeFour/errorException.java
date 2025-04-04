package PracticeFour;



public class errorException {
    public static void main(String[] args) {
        //Question 1 and 2
        simpleexception();
        Stringexception();
        Arrayexception();
    }

    public static void simpleexception() {
        System.out.println("Enter the first number:");
        int first_value = errorCheck();

        //second value check, check the type number is not 0;
        int Type_value = 0;
        System.out.println("Enter the second number:");
        int Second_value = examine_not_zero(Type_value);

        int result = first_value / Second_value;
        System.out.println(result);
    }

    //check if it is number
    public static int errorCheck(){
        int num = 0;
        boolean flag = false;
        while(!flag){
            try{
                num = Integer.valueOf(Keyboard.readInput());
                flag = true;
            } catch(NumberFormatException e){
                System.out.println("Enter an integer!! Type again!!");
            }
        }
        return num;
    }
    //check if it is number
    public static int examine_not_zero(int Second_value){
        boolean state = false;
        while (!state) {
            try {
                Second_value = errorCheck();
                if (Second_value == 0) {
                    throw new ArithmeticException("Cannot divide by zero!! type again");
                }
                state = true;
            }catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
        return Second_value;
    }
    public static void Stringexception(){
        String input = "Apple";
        int bar = 10;
        try{
            System.out.println(input.charAt(bar));
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
    public static void Arrayexception(){
        try {
            int[] numbers = {1, 2, 3, 4, 5};
            int invalidNumber = numbers[10];
            System.out.println("Number at index 10: " + invalidNumber);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}
