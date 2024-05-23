package co.edu.eci.cvds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.service.ConfigurationService;
import co.edu.eci.cvds.service.ProductService;
import co.edu.eci.cvds.service.CarritoService;
import co.edu.eci.cvds.model.Carrito;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CarritoService carritoService;

    @Autowired
    public ProductController(ProductService productService, CarritoService carritoService) {
        this.productService = productService;
        this.carritoService = carritoService;
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

    
    @GetMapping("/carritoView")
    public String showCarritoView(Model model) {
        List<Product> productosEnCarrito = carritoService.getProductosEnCarrito();
        model.addAttribute("productosEnCarrito", productosEnCarrito);
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


    

    @GetMapping("/carrito")
    public String showCarrito(Model model) {
        // Implementa la lógica para obtener el contenido del carrito y pasarlos al modelo
        List<Product> productosEnCarrito = carritoService.getProductosEnCarrito();
        model.addAttribute("productosEnCarrito", productosEnCarrito);
        return "redirect:/products/productosCat";
    }
    
    @PostMapping("/add-to-cart/{productId}")
    public String addToCart(@PathVariable String productId) {
        carritoService.agregarProductoAlCarrito(productId);
        return "redirect:/products/productosCat";
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

    @GetMapping("/update")
    public String updateProduct() {
        return "UpdateProduct";
    }

    @GetMapping("/delete")
    public String deleteAllProducts(Model model) {
        List<Product> productos = productService.getAllProducts();
        model.addAttribute("productos", productos);
        return "DeleteProduct";
    }

    @GetMapping("/edit/{productId}")
    public String editProduct(@PathVariable String productId, Model model) {
        Product producto = productService.getProductById(productId);
        model.addAttribute("producto", producto);
        return "createProduct";
    }
    
}
