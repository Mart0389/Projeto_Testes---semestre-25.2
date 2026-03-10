package com.clinica.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarUsuarioComSucesso() {
        // Arrange - Dados do TC007
        Usuario novoUsuario = new Usuario("novo_usuario", "senha123");

        // Act
        String resultado = usuarioService.cadastrar(novoUsuario);

        // Assert
        // O teste vai dar RED porque o método ainda não existe ou não retorna essa frase
        assertEquals("Cadastro realizado com sucesso", resultado);
        
        // Verifica se o repository realmente tentou salvar o usuário
        verify(repository, times(1)).salvar(novoUsuario);
    }
}