package co.edu.eci.cvds.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/products") 
public class ApiProductController {
    

    @Autowired
    private ProductService productService; 

    @GetMapping
    public List<Product> getAllProducts() { 
        return productService.getAllProducts();
    }

    @GetMapping("/searchByName/{name}") 
    public List<Product> searchProductsByName(@PathVariable String name) { 
        return productService.getProductsByName(name);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }


}
