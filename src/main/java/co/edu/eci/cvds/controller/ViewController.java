package co.edu.eci.cvds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @GetMapping("/productos")
    public String getProductosPage() {
        return "productos"; 
    }

}
