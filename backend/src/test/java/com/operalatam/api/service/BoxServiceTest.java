package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class BoxServiceTest {

    private final BoxService service = new BoxService();

    @Test
    void getBox_ReturnsNull() {
        assertNull(service.getBox("test"));
    }

    @Test
    void criarBox_ReturnsSuccessMessage() {
        assertEquals("Box criado", service.criarBox("test"));
    }

    @Test
    void deleteBox_ReturnsSuccessMessage() {
        assertEquals("Box deletado", service.deleteBox(1L));
    }
}