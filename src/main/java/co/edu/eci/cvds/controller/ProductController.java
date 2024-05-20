package co.edu.eci.cvds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.service.ConfigurationService;
import co.edu.eci.cvds.service.ProductService;
import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequestMapping("/products") 
public class ProductController { 

    
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/Productos") 
    public String showProductosPage() {
        return "productos"; 
    }

    @GetMapping("/{id}")
    public String showProduct(){
        return "producto";
    }
    
    @GetMapping("/carrito")
    public String getMethodName() {
        return "carrito";
    }

    @GetMapping("/productosCat")
    public String showProductosByCategoria(@RequestParam(name = "categoria", required = false) String categoria, Model model) {
    if (categoria != null && !categoria.isEmpty()) {
        List<Product> productosFiltrados = productService.getProductsByCategoria(categoria);
        model.addAttribute("productos", productosFiltrados);
        System.out.println("si filtro");
    } else {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("productos", allProducts);
        System.out.println("else");

    }
    return "productos";
}


    
    
}
