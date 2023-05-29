package com.examen.cibertec.service;

import com.examen.cibertec.model.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioDetalleService implements UserDetailsService {

    @Autowired
    private UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usuario user = service.buscarUsuarioPorNomUsuario(username);
        return usuarioPorAutenticacion(user, obtenerAutorizacion());
    }

    private List<GrantedAuthority> obtenerAutorizacion() {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("admin"));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails usuarioPorAutenticacion(usuario usuario,
                                                List<GrantedAuthority> authorityList) {
        return new User(usuario.getNom_usuario(), usuario.getPassword(),
                true, true, true, true, authorityList);
    }
}
