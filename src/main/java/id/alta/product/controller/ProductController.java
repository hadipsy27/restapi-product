package id.alta.product.controller;

import id.alta.product.entity.Product;
import id.alta.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Object getProductById(@PathVariable Long id){
        try {
            return productRepository.findById(id);
        } catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping
    public Object addProduct(@RequestBody Product p){
        try {
            Product product = productRepository.save(p);
            return product;
        } catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public Object deleteProductById(@PathVariable Long id){
        try {
            Object product = getProductById(id);
            productRepository.deleteById(id);
            return product;
        } catch (Exception e){
            return e.getMessage();
        }
    }
}
