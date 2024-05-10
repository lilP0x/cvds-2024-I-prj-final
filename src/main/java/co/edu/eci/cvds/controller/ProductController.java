package co.edu.eci.cvds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.service.ProductService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/products") 
public class ProductController { 

    
    @GetMapping("/productos") 
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
    
    
}
