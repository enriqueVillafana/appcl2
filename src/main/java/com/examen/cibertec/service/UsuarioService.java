package com.examen.cibertec.service;

import com.examen.cibertec.model.usuario;
import com.examen.cibertec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public usuario buscarUsuarioPorNomUsuario(String nom){
        return repo.findByNombreUsuario(nom);
    }

    public usuario buscarUsuarioPorEmail(String email){
        return repo.findByEmail(email);
    }

    public usuario registrarUsuario(usuario user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
