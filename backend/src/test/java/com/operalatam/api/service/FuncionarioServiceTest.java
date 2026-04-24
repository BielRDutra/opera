package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class FuncionarioServiceTest {

    private final FuncionarioService service = new FuncionarioService();

    @Test
    void getFuncioanrio_ReturnsNull() {
        assertNull(service.getFuncioanrio("test"));
    }

    @Test
    void criarFuncionario_ReturnsSuccessMessage() {
        assertEquals("Gênero criado", service.criarFuncionario("test"));
    }

    @Test
    void deletarFuncionario_ReturnsSuccessMessage() {
        assertEquals("Gênero deletado", service.deletarFuncionario(1L));
    }
}