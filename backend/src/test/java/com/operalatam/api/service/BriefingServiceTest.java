package com.operalatam.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class BriefingServiceTest {

    private final BriefingService service = new BriefingService();

    @Test
    void getBriefing_ReturnsNull() {
        assertNull(service.getBriefing("test"));
    }

    @Test
    void criarBriefing_ReturnsSuccessMessage() {
        assertEquals("Briefing criado", service.criarBriefing("test"));
    }

    @Test
    void deletarBriefing_ReturnsSuccessMessage() {
        assertEquals("Briefing deletado", service.deletarBriefing(1L));
    }
}