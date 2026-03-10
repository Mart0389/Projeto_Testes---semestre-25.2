package com.clinica.service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;

public class CadastroService {

    private UsuarioRepository repository;

    public CadastroService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public String cadastrar(Usuario usuario) {
        
        return "Cadastro realizado com sucesso";
    }
}