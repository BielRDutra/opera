package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class PessoaServiceTest {

    private final PessoaService service = new PessoaService();

    @Test
    void getPessoa_ReturnsNull() {
        assertNull(service.getPessoa("test"));
    }

    @Test
    void criarPessoa_ReturnsSuccessMessage() {
        assertEquals("Pessoa criada", service.criarPessoa("test"));
    }

    @Test
    void deletarPessoa_ReturnsSuccessMessage() {
        assertEquals("Pessoa deletada", service.deletarPessoa(1L));
    }
}