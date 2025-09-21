package Service;

import Interface.ProductService;
import Repository.ProductRepository;
import models.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public double getTotalValue(List<Product> products) {
        return productRepository.getTotalValue(products);
    }

    @Override
    public Optional<Product> getMostExpensiveProduct(List<Product> products) {
        return products.stream()
                .max((p1, p2) -> Double.compare(p1.price(), p2.price()));
    }
}
