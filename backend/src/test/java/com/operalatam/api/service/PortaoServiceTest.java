package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class PortaoServiceTest {

    private final PortaoService service = new PortaoService();

    @Test
    void getPortao_ReturnsNull() {
        assertNull(service.getPortao("test"));
    }

    @Test
    void criarPortao_ReturnsSuccessMessage() {
        assertEquals("Portão criado", service.criarPortao("test"));
    }

    @Test
    void deletarPortao_ReturnsSuccessMessage() {
        assertEquals("Portão deletado", service.deletarPortao(1L));
    }
}