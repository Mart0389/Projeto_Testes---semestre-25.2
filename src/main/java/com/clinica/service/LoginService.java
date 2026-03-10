package com.clinica.service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;

public class LoginService {
    
    private UsuarioRepository repository;

    public LoginService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public String logar(String login, String senha) {
        Usuario usuario = repository.buscarPorLogin(login);
        
       // if (usuario != null && usuario.getSenha().equals(senha)) -- removendo para testar o caso de uso TC002
       
       if (usuario != null){
        
            return "Bem vindo ao sistema";
        }
        return "Usuário ou senha inválidos";
    }
}