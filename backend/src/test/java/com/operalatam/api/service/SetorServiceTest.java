package com.operalatam.api.service;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.operalatam.api.model.Setor;
import com.operalatam.api.repository.SetorRepository;

@ExtendWith(MockitoExtension.class)
class SetorServiceTest {

    @Mock
    private SetorRepository setorRepository;

    private SetorService setorService;


    @Test
    void listSetores_WithoutFilter_ReturnsPagedResults() {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);
        Page<Setor> expectedPage = new PageImpl<>(List.of());
        when(setorRepository.findAll(pageable)).thenReturn(expectedPage);

        // Act
        Page<Setor> result = setorService.listSetores(null, 0, 10);

        // Assert
        assertNotNull(result);
        verify(setorRepository).findAll(pageable);
    }

    @Test
    void listSetores_WithFilter_ReturnsFilteredResults() {
        // Arrange
        String filter = "test";
        Pageable pageable = PageRequest.of(0, 10);
        Page<Setor> expectedPage = new PageImpl<>(List.of());
        when(setorRepository.findByNomeContainingIgnoreCase(filter, pageable)).thenReturn(expectedPage);

        // Act
        Page<Setor> result = setorService.listSetores(filter, 0, 10);

        // Assert
        assertNotNull(result);
        verify(setorRepository).findByNomeContainingIgnoreCase(filter, pageable);
    }

    @Test
    void getSetor_WhenExists_ReturnsNome() {
        // Arrange
        String nome = "TestSetor";
        Setor setor = new Setor();
        setor.setNome(nome);
        when(setorRepository.findByNome(nome)).thenReturn(Optional.of(setor));

        // Act
        String result = setorService.getSetor(nome);

        // Assert
        assertEquals(nome, result);
    }

    @Test
    void getSetor_WhenNotExists_ReturnsNull() {
        // Arrange
        String nome = "NonExistent";
        when(setorRepository.findByNome(nome)).thenReturn(Optional.empty());

        // Act
        String result = setorService.getSetor(nome);

        // Assert
        assertNull(result);
    }

    @Test
    void existsByNome_WhenExists_ReturnsTrue() {
        // Arrange
        String nome = "TestSetor";
        Setor setor = new Setor();
        setor.setNome(nome);
        when(setorRepository.findByNome(nome)).thenReturn(Optional.of(setor));

        // Act
        boolean result = setorService.existsByNome(nome);

        // Assert
        assertTrue(result);
    }

    @Test
    void existsByNome_WhenNotExists_ReturnsFalse() {
        // Arrange
        String nome = "NonExistent";
        when(setorRepository.findByNome(nome)).thenReturn(Optional.empty());

        // Act
        boolean result = setorService.existsByNome(nome);

        // Assert
        assertFalse(result);
    }

    @Test
    void createSetorEntity_SavesAndReturnsSetor() {
        // Arrange
        Setor setor = new Setor();
        setor.setNome("TestSetor");
        when(setorRepository.save(setor)).thenReturn(setor);

        // Act
        Setor result = setorService.createSetorEntity(setor);

        // Assert
        assertNotNull(result);
        verify(setorRepository).save(setor);
    }

    @Test
    void deleteSetor_CallsDeleteById() {
        // Act
        String result = setorService.deleteSetor(1L);

        // Assert
        assertEquals("Setor deletado", result);
        verify(setorRepository).deleteById(1L);
    }

    @Test
    void createSetor_CreatesAndReturnsSetor() {
        // Arrange
        String nome = "NewSetor";
        Setor savedSetor = new Setor();
        savedSetor.setNome(nome);
        when(setorRepository.save(any(Setor.class))).thenReturn(savedSetor);

        // Act
        Setor result = setorService.createSetor(nome);

        // Assert
        assertNotNull(result);
        assertEquals(nome, result.getNome());
        verify(setorRepository).save(any(Setor.class));
    }

    @Test
    void listAll_ReturnsAllSetores() {
        // Arrange
        List<Setor> expectedList = List.of(new Setor(), new Setor());
        when(setorRepository.findAll()).thenReturn(expectedList);

        // Act
        List<Setor> result = setorService.listAll();

        // Assert
        assertEquals(2, result.size());
        verify(setorRepository).findAll();
    }

    @Test
    void listAllFiltered_WithoutFilter_ReturnsAll() {
        // Arrange
        List<Setor> expectedList = List.of(new Setor());
        when(setorRepository.findAll()).thenReturn(expectedList);

        // Act
        List<Setor> result = setorService.listAllFiltered(null);

        // Assert
        assertEquals(1, result.size());
        verify(setorRepository).findAll();
    }

    @Test
    void listAllFiltered_WithFilter_ReturnsFiltered() {
        // Arrange
        String filter = "test";
        List<Setor> expectedList = List.of(new Setor());
        Page<Setor> expectedPage = new PageImpl<>(expectedList);
        when(setorRepository.findByNomeContainingIgnoreCase(eq(filter), any(Pageable.class))).thenReturn(expectedPage);

        // Act
        List<Setor> result = setorService.listAllFiltered(filter);

        // Assert
        assertEquals(1, result.size());
    }
}