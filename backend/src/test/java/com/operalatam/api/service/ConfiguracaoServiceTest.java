package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class ConfiguracaoServiceTest {

    private final ConfiguracaoService service = new ConfiguracaoService();

    @Test
    void getConfiguracao_ReturnsNull() {
        assertNull(service.getConfiguracao("test"));
    }

    @Test
    void criarConfiguracao_ReturnsSuccessMessage() {
        assertEquals("Configuração criada", service.criarConfiguracao("test"));
    }

    @Test
    void deletarConfiguracao_ReturnsSuccessMessage() {
        assertEquals("Configuração deletada", service.deletarConfiguracao(1L));
    }
}