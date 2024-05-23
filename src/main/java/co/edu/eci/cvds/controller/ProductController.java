package co.edu.eci.cvds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.service.ProductService;

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

    @GetMapping("/administration")
    public String showProductosPrivPage(Model model) {
        List<Product> productos = productService.getAllProducts();
        model.addAttribute("productos", productos);
        return "administration";
    }

    @GetMapping("/create")
    public String createProduct() {
        return "CreateProduct";
    }

    @GetMapping("/read")
    public String showAllProducts(Model model) {
        List<Product> productos = productService.getAllProducts();
        model.addAttribute("productos", productos);
        return "ReadProduct";
    }

    @GetMapping("/delete")
    public String deleteProduct() {
        return "DeleteProduct";
    }
}
