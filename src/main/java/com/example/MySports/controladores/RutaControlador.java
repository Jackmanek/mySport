package com.example.MySports.controladores;

import com.example.MySports.entidades.User;
import com.example.MySports.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class RutaControlador {

    @Autowired
    private UserRepository userRepository;


    // Inicio
    @GetMapping("/")
    public String showIndex() {
        return "layouts/app";
    }
    // home
    @GetMapping("/home")
    public String showhome(){
        return "pages/home";
    }
    //Noticias
    @GetMapping("/newFutbol")
    public String showNewsFutbol(){
        return "pages/newFutbol";
    }
    @GetMapping("/newFormula")
    public String showNewsFormula(){
        return "pages/newFormula";
    }
    @GetMapping("/newPadel")
    public String showNewsPadel(){
        return "pages/newPadel";
    }


    //Seleccionar Favoritos
    @GetMapping("/sports")
    public String showSports(){
        return "pages/sports";
    }

    @GetMapping("/registro")
    public String showRegistro(Model m) {
        m.addAttribute("user", new User());
        return "pages/registro";
    }
    @GetMapping("/session")
    public String showSession(Model m) {
        m.addAttribute("user", new User());
        return "pages/session";
    }

    @RequestMapping("/processFormR")
    public String showCustomerData(@Valid @ModelAttribute("user") User use, BindingResult thebindingresult) {
        if (thebindingresult.hasErrors()) {
            return "pages/registro";
        } else {

            return "pages/registro";
        }
    }
    @RequestMapping("/processFormS")
    public String showCustomerData1(@Valid @ModelAttribute("user") User use, BindingResult thebindingresult) {
        if (thebindingresult.hasErrors()) {
            return "pages/session";
        } else {
            userRepository.save(use);
            return "pages/registro";
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid  User use) {
        return new ResponseEntity<>("User registered Successfully!", HttpStatus.OK);
    }
}
