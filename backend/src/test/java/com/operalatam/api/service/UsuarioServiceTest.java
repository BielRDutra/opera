package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class UsuarioServiceTest {

    private final UsuarioService service = new UsuarioService();

    @Test
    void getUsuario_ReturnsNull() {
        assertNull(service.getUsuario("test"));
    }

    @Test
    void criarUsuario_ReturnsSuccessMessage() {
        assertEquals("Usuário criado", service.criarUsuario("test"));
    }

    @Test
    void deletarUsuario_ReturnsSuccessMessage() {
        assertEquals("Usuário deletado", service.deletarUsuario(1L));
    }
}