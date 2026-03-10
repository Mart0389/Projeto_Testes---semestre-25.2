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
        Usuario usuarioMock = new Usuario("usuário", "123@");
        when(repository.buscarPorLogin("usuário")).thenReturn(usuarioMock);

        String resultado = loginService.logar("usuário", "123@");

        assertEquals("Bem vindo ao sistema", resultado);
    }

    @Test
    void deveRetornarErroQuandoLoginEstiverVazio() {
        String resultado = loginService.logar("", "123@");
        assertEquals("O campo login é obrigatório", resultado);
    }

    @Test
    void deveRetornarErroQuandoSenhaEstiverVazia() {
        String resultado = loginService.logar("usuário", "");
        assertEquals("O campo senha é obrigatório", resultado);
    }

    @Test
    void deveRetornarErroQuandoUsuarioNaoPossuiCadastro() {
        // Simula que o repositório não encontrou o usuário
        when(repository.buscarPorLogin("usuario_inexistente")).thenReturn(null);

        String resultado = loginService.logar("usuario_inexistente", "123@");

        assertEquals("Usuário não possui cadastro no sistema", resultado);
    }

    @Test
    void deveRetornarErroQuandoSenhaSeEncontraErrada() {
        // TC 005
        Usuario usuarioCadastrado = new Usuario("usuario", "123@");
        when(repository.buscarPorLogin("usuario")).thenReturn(usuarioCadastrado);

        String resultado = loginService.logar("usuario", "1234@");

        assertEquals("A senha se encontra errada", resultado);
    }
}