package payrollapplication;

public abstract class Employee {
    private static int count = 0;
    protected int employeeId;
    protected String name, type;

    //TODO: 1.i. Create the constructor with two string arguments 'name' & 'type'
    public Employee(String name, String type) {
        this.name = name;
        this.type = type;
    }

    //TODO: 1.ii. Create the getter methods for name, type and id
    public void getter(String name, String type, int employeeId) {
        this.name = name;
        this.type = type;
        this.count = employeeId;
    }

    //TODO: 1.iii. Create an abstract 'salary' method which will return a double
    public abstract double salary();

    //TODO: 1.iv. Implement the toString method which will return employee's name, id and the type.

    public String toString(int employeeId) {
         return name + " (ID:"+ employeeId + ") is a " + type + " employee";
    }




    //TODO: 7.i. Create earnsMoreThan method to compare the salary of two employees
    protected boolean earnsMoreThan(Employee other){
        return this.salary() > other.salary();
    }

    public String getName() {
        return name;
    }
}