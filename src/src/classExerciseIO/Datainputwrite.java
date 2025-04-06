package classExerciseIO;

import java.io.*;

public class Datainputwrite {
    public static void main(String[] args) throws IOException {
        new Datainputwrite().start();
    }
    public void start() throws IOException {
        File file = new File("customerFile.dat");

        // Save customer
        Customer customerToSave = new Customer("Bob", 42, "123 Some Street", true);
        writeCustomer(customerToSave, file);

        // Load and display customer
        Customer loadedCustomer = readCustomer(file);
        System.out.println("Customer details:");
        System.out.println(loadedCustomer);
    }

    private void writeCustomer(Customer customer, File file) throws IOException {
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeUTF(customer.getName());
            dataOutputStream.writeInt(customer.getAge());
            dataOutputStream.writeUTF(customer.getAddress());
            dataOutputStream.writeBoolean(customer.isSubscribed());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private Customer readCustomer(File file) throws IOException {
        Customer customer;
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            customer = new Customer(dataInputStream.readUTF(), dataInputStream.readInt(), dataInputStream.readUTF(), dataInputStream.readBoolean());
            return customer;
        }
    }
}
