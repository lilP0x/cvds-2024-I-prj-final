package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import java.text.NumberFormat;
import java.util.Optional; 


import java.util.List;
import java.util.Locale;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
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

    public double getValueWithDiscount(Product producto) {
        if (producto.getDescuento() > 0) {
            return producto.getValor() - (producto.getValor() * producto.getDescuento());
        }
        return producto.getValor();
    }

    public boolean haveDiscount(Product producto) {
        return producto.getDescuento() > 0;
    }

    public Product getProduct(String name){
        return productRepository.findByNombre(name).get(1);
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);

    }

    public List<Product> getProductsByCategoria(String categoria) {
        return productRepository.findByCategoria(categoria);
    }

    public Product updateProduct(String id, Product product) {
        Optional<Product> existingProductOpt = productRepository.findById(id);

        if (existingProductOpt.isPresent()) { 
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

            return productRepository.save(existingProduct); 
        } else {
            throw new RuntimeException("Product with ID " + id + " not found"); // Lanzar excepción si no se encuentra
        }
    }
} 
