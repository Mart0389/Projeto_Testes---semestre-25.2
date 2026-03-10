package com.clinica.repository;

import com.clinica.model.Usuario;

public interface UsuarioRepository {
 Usuario buscarPorLogin(String login);
    
 void salvar(Usuario usuario);
 
}