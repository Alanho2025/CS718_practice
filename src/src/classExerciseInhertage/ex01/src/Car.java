package classExerciseInhertage.ex01.src;

public class Car extends Vehicle implements IFuel {
    private int fuelTankCapacity;
    public Car(String vehicleType, int mass, double speed, int fuelTankCapacity) {
        super(vehicleType, mass, speed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void fillUp() {
        System.out.println("The car is now full of petrol with " + fuelTankCapacity + "L.");
    }
}
