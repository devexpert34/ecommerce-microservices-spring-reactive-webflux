package demo.ecommerce.product.controller;

import demo.ecommerce.product.model.Product;
import demo.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/list")
    public Flux<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/save")
    public Mono<Product> saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/list/empty")
    public Flux<Product> getZeroInventoryProducts() {
        return productRepository.zeroInventoryProducts();
    }

}
