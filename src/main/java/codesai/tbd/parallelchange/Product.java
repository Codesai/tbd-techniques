package codesai.tbd.parallelchange;

public class Product {

    public final String name;
    public final Integer price;

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "codesai.tbd.parallelchange.Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
