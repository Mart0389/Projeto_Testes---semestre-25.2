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
        usuario.setDataCadastro("10/03/2026");
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

    @Test // TC_011
    void deveRetornarErroQuandoEmailEstiverVazioNoCadastro() {
        // Arrange 
        Usuario usuarioSemEmail = new Usuario();
        usuarioSemEmail.setLogin("123");
        usuarioSemEmail.setNome("Rock");
        usuarioSemEmail.setSenha("123@");
        usuarioSemEmail.setEmail(""); 

        // Act
        String resultado = cadastroService.cadastrar(usuarioSemEmail);

        // Assert
        
        assertEquals("usuário sem e-mail", resultado);
    }


   @Test // TC_012
    void deveRetornarErroQuandoDataCadastroEstiverVazia() {
        // Arrange 
        Usuario usuarioSemData = new Usuario();
        usuarioSemData.setLogin("123");
        usuarioSemData.setNome("Rock");
        usuarioSemData.setSenha("123@");
        usuarioSemData.setEmail("rock@gmail.com");
        usuarioSemData.setDataCadastro(""); 

        // Act
        String resultado = cadastroService.cadastrar(usuarioSemData);

        // Assert
        assertEquals("usuário sem data de cadastro", resultado);
    } 
} 




