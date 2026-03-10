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

class CadastroServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private CadastroService cadastroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

  @Test // TC007
    void deveCadastrarUsuarioComSucesso() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setLogin("123");
        usuario.setNome("Rock");
        usuario.setSenha("123@");
        usuario.setEmail("rock@gmail.com");

        // Act
        String resultado = cadastroService.cadastrar(usuario);

        // Assert
        assertEquals("usuário cadastrado com sucesso", resultado);
    }

}


