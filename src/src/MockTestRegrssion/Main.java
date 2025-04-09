package MockTestRegrssion;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File houseData = new File("House_Data.txt");
        String houseDataString = "";
        //creat a map to store house's size and value.
        Map<Double,Double> houseMap = new HashMap<>();
        //scan the data from House_Data.txt file
        try(Scanner data = new Scanner(houseData)){
            houseDataString = data.nextLine();
            while(data.hasNextLine()){
                String line = data.nextLine();
                String[] parts = line.split(","); // use spilt to separate the data.
                houseMap.put(Double.parseDouble(parts[0].trim()), Double.parseDouble(parts[1].trim()));
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        //check if write into map
        System.out.println(houseMap.toString());

        //create HouseDataSet ArrayList to restore map key and value
        ArrayList<House> HouseDataSet = new ArrayList<>();

        for(Map.Entry<Double,Double> entry : houseMap.entrySet()){
            HouseDataSet.add(new House(entry.getKey(), entry.getValue()));
        }

        System.out.println(HouseDataSet.toString());

        //Calculate the average house size
        double averageSizeValue = averageSize(HouseDataSet);
        //Calculate the average house price
        double averagePriceValue = averagePrice(HouseDataSet);
        // set up predict List
        List<Double> priceList = Arrays.asList(210.0, 30.0, 280.0, 45.0, 200.0, 359.0);
        List<Double> finalResult = regression(HouseDataSet,averageSizeValue, averagePriceValue,priceList);
        //output predict result
        System.out.println(finalResult);

        //output result to regression_results.txt
        File regressData = new File("regression_result.txt");
        try(PrintWriter regressionWrite = new PrintWriter(regressData)){
            regressionWrite.print("Input Data \n");
            for(House house : HouseDataSet){
                regressionWrite.print(house + "\n");
            }
            regressionWrite.print("---------------------------------- \n\n");
            regressionWrite.print("Simple Linear Regression Analysis \n\n");
            regressionWrite.print("The average price of the size is " + averageSizeValue + "\n");
            regressionWrite.print("The average price of the house is " + averagePriceValue + "\n");

            regressionWrite.print("---------------------------------- \n\n");
            regressionWrite.print("Predicted House Prices \n\n");
            for(int index = 0; index < priceList.size(); index++){
                regressionWrite.print("Size :" + priceList.get(index).toString() + ", Predicted House Prices "+ finalResult.get(index).toString() + "\n" );
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }

    }
    public static double averageSize(ArrayList<House> HouseDataSet){
        double sum = 0;
        for(House house : HouseDataSet){
            sum += house.getSize();
        }
        return sum/HouseDataSet.size();
    }
    public static double averagePrice(ArrayList<House> HouseDataSet){
        double sum = 0;
        for(House house : HouseDataSet){
            sum += house.getPrice();
        }
        return sum/HouseDataSet.size();
    }

    public static List<Double> regression(ArrayList<House> houseDataSet, double averageSize, double averagePrice, List<Double> newsize){
        List<Double> output = new ArrayList<>();

        double covariance = 0.0;
        double variance_size = 0.0;

        for (House house : houseDataSet) {
            covariance += (house.getSize() - averageSize) * (house.getPrice() - averagePrice);
            variance_size += Math.pow(house.getSize() - averageSize, 2);
        }

        covariance /= houseDataSet.size(); // or houseDataSet.size() - 1
        variance_size /= houseDataSet.size(); // 同上

        double slope = covariance / variance_size;
        double intercept = averagePrice - slope * averageSize;

        for (Double size : newsize) {
            output.add(slope * size + intercept);
        }

        return output;
    }
}
