package com.examen.cibertec.controller;

import com.examen.cibertec.model.usuario;
import com.examen.cibertec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/registrar")
    public String registrar(){
        return "auth/registrarusuario";
    }

    @PostMapping("/registrarUsuario")
    public String registrarUsuario(@ModelAttribute usuario user){
        service.registrarUsuario(user);
        return "auth/login";
    }
}
