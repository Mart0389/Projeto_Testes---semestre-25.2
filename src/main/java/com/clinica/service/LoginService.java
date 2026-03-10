package com.clinica.service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;

public class LoginService {
    
    private UsuarioRepository repository;

    public LoginService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public String logar(String login, String senha) {


        if (login == null || login.trim().isEmpty()) {
        return "O campo login é obrigatório";
    }

    // Validação da Senha (TC_004 - Implementação para o GREEN)
        if (senha == null || senha.trim().isEmpty()) {
            return "O campo senha é obrigatório";
        }

        Usuario usuario = repository.buscarPorLogin(login);
        
             
       //if (usuario != null) //-- adicionado para testar o tc002, tcc003
        
       if (usuario != null && usuario.getSenha().equals(senha)) {

            return "Bem vindo ao sistema";
        }
        return "Usuário ou senha inválidos";
    }
}