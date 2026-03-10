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
        
       if (usuario == null) {
        return "Usuário não possui cadastro no sistema";
    }
    
    // Se o usuário existe, mas a senha não confere (Cenário do TC_005 atual)
    if (!usuario.getSenha().equals(senha)) {
        return "A senha se encontra errada";
    }
    
    return "Bem vindo ao sistema";
}       
       //if (usuario != null) //-- adicionado para testar o tc002, tcc003 
        
       //if (usuario != null && usuario.getSenha().equals(senha)) { -- comentado para implementar o código para TC005

          //  return "Bem vindo ao sistema"; -- comentado para implementar o código para TC005
       // } -- comentado para implementar o código para TC005
       // return "Usuário ou senha inválidos"; -- comentado para implementar o código para TC005
   // } -- comentado para implementar o código para TC005
}