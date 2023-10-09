package com.example.MySports.controladores;

import com.example.MySports.entidades.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RutaControlador {
    @GetMapping("/")
    public String showIndex() {
        return "layouts/app";
    }

    @GetMapping("/registro")
    public String showRegistro(Model m) {
        m.addAttribute("user", new User());
        return "pages/registro";
    }

    @RequestMapping("/processForm")
    public String showCustomerData(@Valid @ModelAttribute("user") User use, BindingResult thebindingresult) {
        if (thebindingresult.hasErrors()) {
            return "pages/registro";
        } else {
            return "pages/registro";
        }


    }
}
