package classExerciseInhertage.ex01.src;
public class Truck extends Vehicle implements IFuel{
    private int fuelTankCapacity;
    public Truck(String vehicleType, int mass, double speed, int fuelTankCapacity) {
        super(vehicleType, mass, speed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void fillUp() {
        System.out.println("The truck is now full of petrol with " + fuelTankCapacity + "L.");
    }
}
