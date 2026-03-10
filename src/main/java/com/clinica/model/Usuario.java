    package com.clinica.model;

    public class Usuario {
        private String login;
        private String senha;
        private String nome;
        private String email; 

        public Usuario() {}
    

        public Usuario(String login, String senha) {
            this.login = login;
            this.senha = senha;
        }

        
        public String getNome() {
            return nome;
            
        }

        public String getLogin() {
            return login;
        }

        public String getSenha() {
            return senha;
        }

        public String getEmail() {
            return email;
        }


        public void setNome(String nome) {
            this.nome = nome;
        }

        
        public void setLogin(String login) {
            this.login = login;
        }

         public void setSenha(String senha) {
            this.senha = senha;
        }

         public void setEmail(String email) {
            this.email = email;
        }

    }