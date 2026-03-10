package com.clinica.service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;

public class CadastroService {

    private UsuarioRepository repository;

    public CadastroService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public String cadastrar(Usuario usuario) {

        //TC008

        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            return "usuário sem código";
        }
       
        
        //TC007
        repository.salvar(usuario);
        
        return "usuário cadastrado com sucesso";
    }
}