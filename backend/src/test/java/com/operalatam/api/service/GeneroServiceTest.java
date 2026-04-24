package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class GeneroServiceTest {

    private final GeneroService service = new GeneroService();

    @Test
    void getGenero_ReturnsNull() {
        assertNull(service.getGenero("test"));
    }

    @Test
    void criarGenero_ReturnsSuccessMessage() {
        assertEquals("Gênero criado", service.criarGenero("test"));
    }

    @Test
    void deletarGenero_ReturnsSuccessMessage() {
        assertEquals("Gênero deletado", service.deletarGenero(1L));
    }
}