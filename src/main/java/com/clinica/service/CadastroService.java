package com.clinica.service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;

public class CadastroService {

    private UsuarioRepository repository;

    public CadastroService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public String cadastrar(Usuario usuario) {
        // implementando TC008 para validar 
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
        return "O campo login é obrigatório";
        
    }

    repository.salvar(usuario);
    return "Cadastro realizado com sucesso";
}

}