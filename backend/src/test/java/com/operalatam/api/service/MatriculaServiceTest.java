package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class MatriculaServiceTest {

    private final MatriculaService service = new MatriculaService();

    @Test
    void getMatricula_ReturnsNull() {
        assertNull(service.getMatricula("test"));
    }

    @Test
    void criarMatricula_ReturnsSuccessMessage() {
        assertEquals("Matrícula criada", service.criarMatricula("test"));
    }

    @Test
    void deletarMatricula_ReturnsSuccessMessage() {
        assertEquals("Matrícula deletada", service.deletarMatricula(1L));
    }
}