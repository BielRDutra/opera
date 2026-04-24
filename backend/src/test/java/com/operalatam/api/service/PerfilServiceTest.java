package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class PerfilServiceTest {

    private final PerfilService service = new PerfilService();

    @Test
    void getPerfil_ReturnsNull() {
        assertNull(service.getPerfil("test"));
    }

    @Test
    void criarPerfil_ReturnsSuccessMessage() {
        assertEquals("Perfil criado", service.criarPerfil("test"));
    }
}