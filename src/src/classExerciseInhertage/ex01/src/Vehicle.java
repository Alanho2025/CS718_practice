package classExerciseInhertage.ex01.src;
public abstract class Vehicle {
    protected String vehicleType;
    protected int mass;
    protected double speed;


    public Vehicle(String vehicleType, int mass, double speed){
        this.vehicleType = vehicleType;
        this.mass = mass;
        this.speed = speed;
    }


    public double calculateMaxMomentum() {
        return mass * speed;
    }

    @Override
    public String toString(){
        return "This " + vehicleType + " weighs " + mass + "kg and can speed up to " + speed + "m/s.";
    }

}
