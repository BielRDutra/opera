package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class RamalServiceTest {

    private final RamalService service = new RamalService();

    @Test
    void getRamal_ReturnsNull() {
        assertNull(service.getRamal("test"));
    }

    @Test
    void criarRamal_ReturnsSuccessMessage() {
        assertEquals("Ramal criado", service.criarRamal("test"));
    }

    @Test
    void deletarRamal_ReturnsSuccessMessage() {
        assertEquals("Ramal deletado", service.deletarRamal(1L));
    }
}