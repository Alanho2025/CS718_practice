package payrollapplication;

public class SalesEmployee extends Employee {
    double sales;
    double commission;
    public SalesEmployee(String name, double sales , double commission ) {
        super(name, "sales");
        this.sales = sales;
        this.commission = commission;
    }
    @Override
    public double salary() {
        return sales*commission + payBonus();
    }

    public double payBonus() {
        double bonusRate = Math.random();
        double bonusSale = bonusRate * sales;
        double bonus = commission * bonusSale;
        return bonus;
    }
}
