package classExerciseInhertage.ex02.src;
/**
 *  Exercise Two -  Please examine all the classes in the ex02 folder carefully to understand the classes.
 *                  For this exercise, you only need to modify this VehicleManager class.
 */
public class VehicleManager {
    public static void main(String[] args) {
        VehicleManager prog = new VehicleManager();

        /** TODO: 1. Create a vehicle array called "vehicles" to hold three elements.
         *           You will be creating three objects, horse, car and truck, and store them into the array respectively.
         *           The horse weights 300kg and the horse can run at a speed of 24.44m/s.
         *           The car weights 1500kg and the car can run at a speed of 55.56m/s.
         *           The fuel capacity for car is 55L.
         *           The truck weights 12000kg and the truck can run at a speed of 50.0m/s.
         *           The fuel capacity for car is 33000L.
         */
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Horse("horse", 300, 24.44);
        vehicles[1] = new Car("car" , 1500, 55.56, 55);
        vehicles[2] = new Truck("truck", 12000, 50.0, 33000);

        prog.printVehicleDetails(vehicles);
        System.out.println();

        double largestMomentum = prog.findLargestMomentum(vehicles);
        System.out.println("The largest momentum is " + largestMomentum + "kgm/s.");
        System.out.println();

        prog.fillUpVehicle(vehicles);


    }


    /** TODO: 2. Create the printVehicleDetails() method that takes the "vehicles" array as the input.
     *           This method should iterate through the array and print out the vehicle details by using the toString() method.
     */
    private void printVehicleDetails(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i]);
        }
    }

    /** TODO: 3. Create the findLargestMomentum() method that takes the "vehicles" array as the input.
     *           This method should iterate through the array and find out the largest momentum value from all vehicles.
     *           Hint: calculateMaxMomentum() method from Vehicle class can be useful.
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

    /** TODO: 4. Create the fillupVehicle() method that takes the "vehicles" array as the input.
     *           This method should iterate through the array to check if the vehicle can be filled up by fuels.
     *           If so, it should call the fillUp() method to top up the vehicle.
     *           Hint: carefully examine all vehicle classes and the IFuel interface to see how this can be achieved.
     */
    private void fillUpVehicle(Vehicle[] vehicles) {
        for (int i = 1; i < vehicles.length; i++) {
            if(vehicles[i] instanceof IFuel){
                ((IFuel)vehicles[i]).fillUp();
            }
        }
    }

}
