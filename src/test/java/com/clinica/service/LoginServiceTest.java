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

    class LoginServiceTest {

        @Mock
        private UsuarioRepository repository;

        @InjectMocks
        private LoginService loginService;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void deveRealizarLoginComSucesso() {
            // Arrange (Organizar) - Dados do seu TC_001
            Usuario usuarioMock = new Usuario("usuário", "123@");
            when(repository.buscarPorLogin("usuário")).thenReturn(usuarioMock);

            // Act (Agir)
            String resultado = loginService.logar("usuário", "123@");

            // Assert (Afirmar)
            assertEquals("Bem vindo ao sistema", resultado);
        }


        @Test
    void deveRetornarErroQuandoSenhaForIncorreta() {
        // Arrange - Dados do seu TC_002
        Usuario usuarioNoBanco = new Usuario("usuário", "123@");
        when(repository.buscarPorLogin("usuário")).thenReturn(usuarioNoBanco);

        // Act
        String resultado = loginService.logar("usuário", "senha_errada");

        // Assert
        assertEquals("Usuário ou senha inválidos", resultado);
    }

    }