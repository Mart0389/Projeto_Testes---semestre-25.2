package com.clinica.model;

public class Usuario {
    private String login;
    private String senha;
    private String nome;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getSenha() { 
        return senha; 
    }

    public String getLogin() {
        return login;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

}