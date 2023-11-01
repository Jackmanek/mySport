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
    @GetMapping("/")
    public String showIndex() {
        return "layouts/app";
    }
    @GetMapping("/home")
    public String showhome(){
        return "pages/home";
    }

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

    @RequestMapping("/login")
    public String showCustomerData(@Valid @ModelAttribute("user") User use, BindingResult thebindingresult) {
        userRepository.findAll();

        if (thebindingresult.hasErrors() || (!userRepository.findAll().get(userRepository.findAll().size()-1).getEmail().equals(use.getEmail())) ) {
            return "pages/registro";
        } else {

            return "pages/sports";
        }


    }

    @PostMapping("/signup")
    public String registerUser(@Valid  @ModelAttribute("user") User use, BindingResult thebindingresult) {

        if(thebindingresult.hasErrors()){
            return "pages/registro";
        }else{
            userRepository.save(use);
            return "User registered Successfully!";
        }
    }
}
