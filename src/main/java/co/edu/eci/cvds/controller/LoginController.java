package co.edu.eci.cvds.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final String LOGIN_PAGE = "login/login";

    @Autowired
    public LoginController() {

    }

    @GetMapping("")
    public String login() {
        return LOGIN_PAGE;
    }

    @GetMapping("/register")
    public String register() {
        return "login/register";
    }

     @GetMapping("/losePassword")
    public String losePassword() {
        return "LosePassword";
    }

     @GetMapping("/selectedMode")
    public String selectedMode() {
        return "SelectedMode";
    }

    
    @GetMapping("/administration")
    public String administration() {
        return "Administration";
    }


    @GetMapping("/cotizacion")
    public String cotizacion() {
        return "Cotizacion";
    }

     @GetMapping("/CrudProduct")
    public String crudProduct() {
        return "CrudProduct";
    }

    @GetMapping("/validateCreate")
    public String validateCreate() {
        return "ValidateCreate";
    }

    @GetMapping("/imprimirCotizacion")
    public String imprimirCotizacion() {
        return "ImprimirCotizacion";
    }
}
