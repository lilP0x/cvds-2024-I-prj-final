package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Carrito;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.repository.CarritoRepository;
import co.edu.eci.cvds.repository.ProductRepository;

import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@SessionScope
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;
    @Autowired
    private ProductRepository productoRepository;

    public void agregarProductoAlCarrito(String productId) {
        Product producto = productoRepository.findById(productId).orElse(null);
        if (producto != null) {
            Carrito carrito = obtenerCarritoActual();
            carrito.getProducts().add(producto);
            //producto.setCarritos(carrito);
            carritoRepository.save(carrito);
        }
    }
    public Carrito obtenerCarritoActual() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession(true);
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        return carrito;
    }

    public List<Product> getProductosEnCarrito() {
        Carrito carrito = obtenerCarritoActual();
        return carrito.getProducts();
    }
}
