package codesai.tbd.parallelchange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSearchApi {
    public static final List<Product > products;

    static {
       products = new ArrayList(){{
           add(new Product("book", 120));
           add(new Product("ipad", 5000));
           add(new Product("tv", 10000));
        }};
    }

    public static List<Product> search(Integer minPrice, Integer maxPrice) {
        return products.stream()
                .filter(p -> p.price >= (Integer) minPrice && p.price <= (Integer) maxPrice)
                .collect(Collectors.toList());
    }
}
