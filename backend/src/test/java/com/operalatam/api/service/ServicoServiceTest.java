package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class ServicoServiceTest {

    private final ServicoService service = new ServicoService();

    @Test
    void getServico_ReturnsNull() {
        assertNull(service.getServico("test"));
    }

    @Test
    void criarServico_ReturnsSuccessMessage() {
        assertEquals("Serviço criado", service.criarServico("test"));
    }

    @Test
    void deletarServico_ReturnsSuccessMessage() {
        assertEquals("Serviço deletado", service.deletarServico(1L));
    }
}