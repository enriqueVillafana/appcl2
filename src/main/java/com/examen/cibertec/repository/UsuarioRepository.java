package com.examen.cibertec.repository;

import com.examen.cibertec.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<usuario, Integer> {
    @Query("select u from usuario u where u.email = ?1")
    usuario findByEmail(String email);

    @Query("select u from usuario u where u.nom_usuario = ?1")
    usuario findByNombreUsuario(String nomUsuario);
}
