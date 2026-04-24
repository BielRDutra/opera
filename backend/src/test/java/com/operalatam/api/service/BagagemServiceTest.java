package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class BagagemServiceTest {

    private final BagagemService service = new BagagemService();

    @Test
    void getBagagem_ReturnsNull() {
        assertNull(service.getBagagem("test"));
    }

    @Test
    void criarBagagem_ReturnsSuccessMessage() {
        assertEquals("Etiqueta criado", service.criarBagagem("test"));
    }

    @Test
    void deletarBagagem_ReturnsSuccessMessage() {
        assertEquals("Etiqueta deletado", service.deletarBagagem(1L));
    }
}