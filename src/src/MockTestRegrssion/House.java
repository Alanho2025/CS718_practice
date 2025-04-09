package MockTestRegrssion;

public class House {
    double size;
    double price;

    public House(double size, double price) {
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return "House [ size :" + size + " sqft, Price:" + price + "]";
    }

    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public double getPrice() {
        return price;
    }

}
