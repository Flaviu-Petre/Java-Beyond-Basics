package Repository;

import models.Product;

import java.util.List;

public class ProductRepository {

    public double getTotalValue(List<Product> products) {
        return products.stream()
                .mapToDouble(product -> product.price() * product.quantity())
                .sum();
    }
}
