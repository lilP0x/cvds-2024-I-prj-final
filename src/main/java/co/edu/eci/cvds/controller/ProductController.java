package co.edu.eci.cvds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.service.ConfigurationService;
import co.edu.eci.cvds.service.ProductService;
import org.springframework.ui.Model;

import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> 82992eeecb8652ccae35a7c0c2df0db9a575f5d2

@Controller
@RequestMapping("/products")
public class ProductController {

<<<<<<< HEAD
    
=======
>>>>>>> 82992eeecb8652ccae35a7c0c2df0db9a575f5d2
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

<<<<<<< HEAD
    @GetMapping("/Productos") 
=======
    @GetMapping("/Productos")
>>>>>>> 82992eeecb8652ccae35a7c0c2df0db9a575f5d2
    public String showProductosPage() {
        return "productos";
    }

    @GetMapping("/{productId}")
    public String getProductDetails(@PathVariable String productId, Model model) {
        Product producto = productService.getProductById(productId);
        model.addAttribute("producto", producto);
        return "producto"; 
    }
    

    @GetMapping("/carrito")
    public String showCarrito(Model model) {
        List<Product> productos = productService.getAllProducts(); // Obtener todos los productos o los productos del carrito
        model.addAttribute("productos", productos);
        return "carrito";
    }

    @GetMapping("/productosCat")
    public String showProductosByCategoria(@RequestParam(name = "categoria", required = false) String categoria, Model model) {
<<<<<<< HEAD
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


    
    
=======
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
>>>>>>> 82992eeecb8652ccae35a7c0c2df0db9a575f5d2
}
