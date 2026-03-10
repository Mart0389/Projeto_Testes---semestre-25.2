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

@Test // TC008
    void deveRetornarErroQuandoCodigoUsuarioEstiverVazio() {
        
        Usuario usuarioSemCodigo = new Usuario();
        usuarioSemCodigo.setLogin(""); 
        usuarioSemCodigo.setNome("Rock");
        usuarioSemCodigo.setSenha("123@");
        usuarioSemCodigo.setEmail("rock@gmail.com");

        // Act
        String resultado = cadastroService.cadastrar(usuarioSemCodigo);

        // Assert
        
        assertEquals("usuário sem código", resultado);
    }

@Test // TC_009
    void deveRetornarErroQuandoNomeEstiverVazioNoCadastro() {
        
        Usuario usuarioSemNome = new Usuario();
        usuarioSemNome.setLogin("123");
        usuarioSemNome.setNome(""); 
        usuarioSemNome.setSenha("123@");
        usuarioSemNome.setEmail("rock@gmail.com");

        // Act
        String resultado = cadastroService.cadastrar(usuarioSemNome);

        // Assert
        
        assertEquals("usuário sem nome", resultado);
    }

    @Test // TC010
    void deveRetornarErroQuandoSenhaEstiverVaziaNoCadastro() {
        // Arrange 
        Usuario usuarioSemSenha = new Usuario();
        usuarioSemSenha.setLogin("123");
        usuarioSemSenha.setNome("Rock");
        usuarioSemSenha.setSenha(""); 
        usuarioSemSenha.setEmail("rock@gmail.com");

        // Act
        String resultado = cadastroService.cadastrar(usuarioSemSenha);

        // Assert
        
        assertEquals("usuário sem senha", resultado);
    }

}




