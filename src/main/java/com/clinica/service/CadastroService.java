package com.clinica.service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;

public class CadastroService {

    private UsuarioRepository repository;

    public CadastroService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public String cadastrar(Usuario usuario) {
        // ImplementaçãoTC008 
       
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            return "usuário sem código"; 
        }

        // Implementação para o TC009 
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            return "usuário sem nome";
        }

        repository.salvar(usuario);
        return "Cadastro realizado com sucesso";
    } 
} 