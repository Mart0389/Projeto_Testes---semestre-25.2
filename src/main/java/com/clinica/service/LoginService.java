package com.clinica.service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;

public class LoginService {
    
    private UsuarioRepository repository;

    public LoginService(UsuarioRepository repository) {
        this.repository = repository;
    }

    /**
     * Realiza a lógica de autenticação baseada nos casos de teste TC_001 a TC_006.
     */
    public String logar(String login, String senha) {

        // Validação de campos obrigatórios
        if (isVazio(login)) {
            return "O campo login é obrigatório";
        }

        if (isVazio(senha)) {
            return "O campo senha é obrigatório";
        }

        Usuario usuario = repository.buscarPorLogin(login);

        // Validação de existência do usuário (TC_006)
        if (usuario == null) {
            return "O login se encontra errado";
        }
        
        // Validação de credenciais (TC_005)
        if (!usuario.getSenha().equals(senha)) {
            return "A senha se encontra errada";
        }

        return "Bem vindo ao sistema";
    }

    // Método auxiliar para melhorar a leitura do código
    private boolean isVazio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}