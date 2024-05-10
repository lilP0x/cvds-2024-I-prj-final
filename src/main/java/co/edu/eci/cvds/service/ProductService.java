package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import java.util.Optional; 


import java.util.List;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public List<Product> getProductsByName(String name) {
        return productRepository.findByNombre(name);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProduct(String name){
        return productRepository.findByNombre(name).get(1);
    }

     public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);

    }

    public Product updateProduct(String id, Product product) {
        Optional<Product> existingProductOpt = productRepository.findById(id);

        if (existingProductOpt.isPresent()) { // Si el producto existe
            Product existingProduct = existingProductOpt.get();

            existingProduct.setNombre(product.getNombre());
            existingProduct.setValor(product.getValor());
            existingProduct.setDescuento(product.getDescuento());
            existingProduct.setDescripcionBreve(product.getDescripcionBreve());
            existingProduct.setDescripcionTecnica(product.getDescripcionTecnica());
            existingProduct.setCategoria(product.getCategoria());
            existingProduct.setImpuesto(product.getImpuesto());
            existingProduct.setTipoUsuario(product.getTipoUsuario());
            existingProduct.setIconUrl(product.getIconUrl());

            return productRepository.save(existingProduct); // Guardar y devolver el producto
        } else {
            throw new RuntimeException("Product with ID " + id + " not found"); // Lanzar excepción si no se encuentra
        }
    }
} 
