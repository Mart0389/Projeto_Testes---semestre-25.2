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
        if (isVazio(usuario.getLogin())) {
            return "usuário sem código";
        }
        
        //TC009
        if (isVazio(usuario.getNome())) {
            return "usuário sem nome";
        }

        //TC010
        if (isVazio(usuario.getSenha())) {
            return "usuário sem senha";
        }

        //TC011
        if (isVazio(usuario.getEmail())) {
            return "usuário sem e-mail";
        }
        
        //TC012
        if (isVazio(usuario.getDataCadastro())) {
            return "usuário sem data de cadastro";
        }

        //TC007
        repository.salvar(usuario);
        
        return "usuário cadastrado com sucesso";
    }

    private boolean isVazio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }
}