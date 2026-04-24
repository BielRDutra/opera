package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AeronaveServiceTest {

    private final AeronaveService service = new AeronaveService();

    @Test
    void getAeronave_ReturnsNull() {
        assertNull(service.getAeronave("test"));
    }

    @Test
    void criarAeronave_ReturnsSuccessMessage() {
        assertEquals("Aeronave criada", service.criarAeronave("test"));
    }

    @Test
    void deletarAeronave_ReturnsSuccessMessage() {
        assertEquals("Aeronave deletada", service.deletarAeronave(1L));
    }
}