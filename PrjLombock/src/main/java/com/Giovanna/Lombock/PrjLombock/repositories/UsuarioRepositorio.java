package com.Giovanna.Lombock.PrjLombock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Giovanna.Lombock.PrjLombock.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
