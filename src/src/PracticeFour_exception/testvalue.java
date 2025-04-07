package PracticeFour_exception;

public class testvalue {
    public static void main(String[] args) {
        testvalue test = new testvalue();
        test.question5();
    }
    public void question5(){
        try {
            System.out.print("1: ");
            perform("3");
            System.out.print("A ");
            System.out.println();

            System.out.print("2: ");
            perform("0");
            System.out.print("B ");
            System.out.println();

            System.out.print("3: ");
            perform(null);
            System.out.print("C ");
            System.out.println();

            System.out.print("4: ");
            perform("");
            System.out.print("D ");
            System.out.println();
        } catch (NullPointerException e) {
            System.out.print("E ");
        } catch (Exception e) {
            System.out.print("F ");
        }
    }

    private void perform(String input) {
        try {
            int length = input.length();
            int num1 = Integer.parseInt(input);
            System.out.print("A4 ");
            int num2 = 100 / num1;
            System.out.print("B4 ");
        } catch (NumberFormatException e) {
            System.out.print("C4 ");
        } catch (ArithmeticException e) {
            System.out.print("D4 ");
        } finally {
            System.out.print("E4 ");
        }
        System.out.print("F4 ");
    }
}

//Answer:
//1: A4 B4 E4 F4 A
//2: A4 D4 E4 F4 B
//3: E4 E
