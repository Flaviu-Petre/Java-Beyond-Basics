package Interface;

import models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    double getTotalValue(List<Product> products);
    Optional<Product> getMostExpensiveProduct (List<Product> products);
}
