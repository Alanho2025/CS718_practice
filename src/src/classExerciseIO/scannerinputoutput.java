package classExerciseIO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class scannerinputoutput {
    private void start() throws IOException {

        File file = new File("customer.txt");

        // Load and display customer
        Customer[] loadedCustomer = readCustomer(file);
        System.out.println("Customer details:");
        System.out.println(loadedCustomer[0]);
        System.out.println(loadedCustomer[1]);

    }
    private Customer[] readCustomer(File file) {
        Customer[] customers = new Customer[2];
        int i = 0;
        try(Scanner scanner = new Scanner(file)){
            scanner.useDelimiter(",|\\r\\n");
            while(scanner.hasNext()){
                customers[i] = new Customer(scanner.next(),scanner.nextInt(),scanner.next(),scanner.nextBoolean());
                i++;

            }

        } catch(IOException e){

        }


        return customers;
    }
    public static void main(String[] args) throws IOException{
        new scannerinputoutput().start();
    }
}
