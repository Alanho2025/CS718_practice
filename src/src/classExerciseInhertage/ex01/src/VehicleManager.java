package classExerciseInhertage.ex01.src;
/**
 *  Exercise One - Please examine this class to see what we would like to achieve as the outcome.
 *                 You will be creating several classes and an interface to make this programme executable.
 */

public class VehicleManager {
    public static void main(String[] args) {

        VehicleManager prog = new VehicleManager();

        /**
         *  The following vehicles array holds three vehicle objects, Horse, Car and Truck respectively.
         */
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Horse("horse", 300, 24.44);
        vehicles[1] = new Car("car" , 1500, 55.56, 55);
        vehicles[2] = new Truck("truck", 12000, 50, 33000);

        prog.printVehicleDetails(vehicles);
        System.out.println();

        double largestMomentum = prog.findLargestMomentum(vehicles);
        System.out.println("The largest momentum is " + largestMomentum + "kgm/s.");

        prog.fillUpVehicle(vehicles);


    }



    /**
     * The following method iterates through the vehicles array and print out the details of each vehicle.
     * @param vehicles
     */
    private void printVehicleDetails(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i]);
        }
    }

    /**
     * The following method iterates through the vehicles array and find the largest momentum value from the vehicles.
     * @param vehicles
     * @return largestMomentum
     */
    private double findLargestMomentum(Vehicle[] vehicles) {
        double largestMomentum = vehicles[0].calculateMaxMomentum();
        for (int i = 1; i < vehicles.length; i++) {
            if( vehicles[i].calculateMaxMomentum()> largestMomentum){
                largestMomentum = vehicles[i].calculateMaxMomentum();
            }

        }
        return largestMomentum;
    }


    /**
     * The following method iterates through the vehicles array and check if the vehicle can be filled up with fuel.
     * If so, it will convert the object to have a reference type of IFuel and call the fillUp() method.
     * @param vehicles
     */
    private void fillUpVehicle(Vehicle[] vehicles) {
        for (int i = 1; i < vehicles.length; i++) {
            if(vehicles[i] instanceof IFuel){
                ((IFuel)vehicles[i]).fillUp();
            }
        }
    }
}
