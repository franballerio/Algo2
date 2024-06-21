package aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrieAlumnosTest {

    private TrieAlumnos trie;

    @BeforeEach
    public void setUp() {
        trie = new TrieAlumnos();
    }

    @Test
    public void testBasicInsertionAndMembership() {
        trie.agregar("123456");
        trie.agregar("654321");
        
        assertTrue(trie.pertenece("123456"));
        assertTrue(trie.pertenece("654321"));
        assertFalse(trie.pertenece("987654"));
    }

    @Test
    public void testInsertionOfDuplicates() {
        trie.agregar("111111");
        trie.agregar("111111");
        trie.agregar("111111");
        
        assertEquals(1, trie.tamañoTrie());
    }

    @Test
    public void testEmptyTrie() {
        assertFalse(trie.pertenece("123456"));
        assertEquals(0, trie.tamañoTrie());
    }

    @Test
    public void testBoundaryTesting() {
        trie.agregar("123456");
        trie.agregar("654321");
        trie.agregar("987654");
        
        assertTrue(trie.pertenece("123456"));
        assertTrue(trie.pertenece("654321"));
        assertTrue(trie.pertenece("987654"));
        assertFalse(trie.pertenece("111111"));
    }

    @Test
    public void testBuscarAlumno() {
        trie.agregar("123456");
        trie.agregar("654321");
        
        TrieAlumnos.nodoAlumnos nodo = trie.buscarAlumno("123456");
        assertNotNull(nodo.materiasInscriptas);
    }
}

