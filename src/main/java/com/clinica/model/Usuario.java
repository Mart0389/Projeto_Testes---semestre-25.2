    package com.clinica.model;

    public class Usuario {
        private String login;
        private String senha;
        private String nome;
        private String email; 
        private String dataCadastro;

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


        public String getDataCadastro() {
            return dataCadastro;
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


        public void setDataCadastro(String dataCadastro) {
            this.dataCadastro = dataCadastro;
        }

    }