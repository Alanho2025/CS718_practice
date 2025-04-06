package payrollapplication;

public class PayrollApp {
    public static void main(String[] args) {
        PayrollApp p = new PayrollApp();
        p.start();
    }

    private void start() {
        /*TODO: 4.i. Create an Employee array with the variable name 'employees'.
                Call createEmployee() method to initialise an Employee array.
         */
        Employee[] employees = createEmployee();


        System.out.println("=====================================================");
        System.out.println("Auckland Pizza Store has the following employees");
        System.out.println();
        //TODO: 4.ii. Implement the printEmployeeDetails method
        printEmployeeDetails(employees);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println("Payroll office is paying the salary.");
        System.out.println();
        //TODO: 4.iii. Implement the paySalary method
        paySalary(employees);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println("We have a great year. Let's share the fun!");
        System.out.println("Bonus will be paid to permanent and sales employees.");
        System.out.println();
        //TODO: 5.iii. Implement the payBonus method
        payBonus(employees);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println("The final salary balances:");
        System.out.println();
        //TODO: 6. Implement the printBalance method
        printBalance(employees);
        System.out.println();

        System.out.println("=====================================================");
        //TODO: 7.ii. Implement the getMostRichestEmployee method
        System.out.print("The richest employee in the company is: " + getMostRichestEmployee(employees).getName());
        System.out.println();
        System.out.println();

    }
    private Employee getMostRichestEmployee(Employee[] employees) {

            if (employees == null || employees.length == 0) return null;

            Employee richest = employees[0];

            for (int i = 1; i < employees.length; i++) {
                if (employees[i].earnsMoreThan(richest)) {
                    richest = employees[i];
                }
            }

            return richest;

    }



    private void printBalance(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee instanceof PermanentEmployee) {
                System.out.println("The balance output of " + employee.name + " is $" + (employee.salary() + 100));
            } else {
                System.out.println("The balance output of " + employee.name + " is $" + employee.salary());
            }
        }
    }



    private void printEmployeeDetails(Employee[] employees) {
        int employeeId = 0;
        for (Employee employee : employees) {
            employeeId++;
            System.out.println(employee.toString(employeeId));
        }

    }

    private void paySalary(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.name + " receives " + employee.salary());
        }
    }

    private void payBonus(Employee[] employees) {
        int employeeId = 0;
        double bonus = 0;
        for (Employee employee : employees) {
            employeeId++;
            if(employee instanceof SalesEmployee) {
                System.out.println(employee.toString(employeeId));
                SalesEmployee salesEmp = (SalesEmployee) employee;
                bonus = salesEmp.payBonus();
                System.out.println("$" + bonus + " is paid");
            } else if (employee instanceof PermanentEmployee) {
                System.out.println(employee.toString(employeeId));
                PermanentEmployee permEmp = (PermanentEmployee) employee;
                bonus = permEmp.payBonus(100.0);  // 假設給固定 base
                System.out.println("$" + bonus + " is paid");
            }
        }
    }




    private Employee[] createEmployee() {
        Employee[] employees = new Employee[20];
        employees[0] = new PermanentEmployee("Andrew", 120050);
        employees[1] = new SeasonalEmployee("Brian", 688, 22.56);
        employees[2] = new SalesEmployee("Cathy", 600000, 0.20);
        employees[3] = new PermanentEmployee("David", 100500);
        employees[4] = new PermanentEmployee("Emma", 60050);
        employees[5] = new SalesEmployee("Franky", 200000, 0.18);
        employees[6] = new SalesEmployee("Gill", 1005000, 0.22);
        employees[7] = new SeasonalEmployee("Helen", 833, 21.55);
        employees[8] = new SalesEmployee("Ian", 500000, 0.18);
        employees[9] = new SeasonalEmployee("James", 800, 25);
        employees[10] = new SeasonalEmployee("Kevin", 100, 50.0);
        employees[11] = new PermanentEmployee("Lynda", 54321);
        employees[12] = new SeasonalEmployee("Michael", 556, 22.22);
        employees[13] = new SeasonalEmployee("Nancy", 2000, 23);
        employees[14] = new PermanentEmployee("Olivia", 77000);
        employees[15] = new PermanentEmployee("Peter", 63900);
        employees[16] = new SeasonalEmployee("Queen", 713, 23.33);
        employees[17] = new SeasonalEmployee("Richard", 1500, 21.34);
        employees[18] = new PermanentEmployee("Steve", 90000);
        employees[19] = new PermanentEmployee("Tyne", 100500);

        return employees;
    }

}

