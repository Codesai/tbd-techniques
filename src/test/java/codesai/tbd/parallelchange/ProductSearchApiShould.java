package codesai.tbd.parallelchange;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSearchApiShould {

    @Test
    public void search_by_price_range() {
        final List<Product> products = ProductSearchApi.search(100, 5000);
        assertThat(products).hasSize(2);
    }
}
