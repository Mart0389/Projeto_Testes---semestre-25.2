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
    private CadastroService cadastroService; // Usando o seu nome de classe

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarUsuarioComSucesso() {
        // Arrange - Dados do TC007
        Usuario novoUsuario = new Usuario("novo_usuario", "senha123");

        // Act
        String resultado = cadastroService.cadastrar(novoUsuario);

        // Assert
        assertEquals("Cadastro realizado com sucesso", resultado);
    }

@Test
void deveRetornarErroQuandoLoginEstiverVazioNoCadastro() {
    // Arrange - TC008
    
    Usuario usuarioSemLogin = new Usuario("", "senha123");

    // Act
    String resultado = cadastroService.cadastrar(usuarioSemLogin);

    // Assert
    assertEquals("O campo login é obrigatório", resultado);
}

@Test
void deveRetornarErroQuandoNomeEstiverVazioNoCadastro() {
    // Arrange - TC009
    
    Usuario usuarioSemNome = new Usuario("login123", "senha123");
    usuarioSemNome.setNome(""); ing resultado = cadastroService.cadastrar(usuarioSemNome);

    // Assert
   
    assertEquals("O campo nome é obrigatório", resultado);
}


}