package aed;

import java.util.*;

public class TrieAlumnos {

    private nodoAlumnos raiz;
    private int cantidadNodos;

    public class nodoAlumnos {
        private nodoAlumnos[] hijos;
        private boolean fin;
        public int cantidadMateriasInscripto;

        public nodoAlumnos() {
            this.hijos = new nodoAlumnos[256];
            this.fin = false;
            this.cantidadMateriasInscripto = 0;
        }

        public int cantMateriasInscriptas() {
            return this.cantidadMateriasInscripto;
        }
    }

    public TrieAlumnos() {
        this.cantidadNodos = 0;
        this.raiz = new nodoAlumnos();
    }

    public boolean pertenece(String palabra) {
        nodoAlumnos nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            int indice = (int) caracter;

            if (nodoActual.hijos[indice] == null) {
                return false;
            }
            nodoActual = nodoActual.hijos[indice];
        }
        return (nodoActual != null && (nodoActual.fin != false));
    }

    public void agregar(String palabra) { // inscribir a la facu
        nodoAlumnos actual = raiz;
        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            int indice = (int) caracter;

            if (actual.hijos[indice] != null) {
                actual = actual.hijos[indice];
            } else {
                nodoAlumnos nuevoNodo = new nodoAlumnos();
                actual.hijos[indice] = nuevoNodo;
                actual = nuevoNodo;
                cantidadNodos++;
            }
        }
        actual.fin = true;
    }

    public void inscribir(String palabra) { // inscribir a materias
        nodoAlumnos alumno = buscarUltimo(this, palabra);
        alumno.cantidadMateriasInscripto++;

    }

    public void desinscribir(String alumno) {
        nodoAlumnos actual = buscarUltimo(this, alumno);
        actual.cantidadMateriasInscripto--;
    }

    public nodoAlumnos buscarUltimo(TrieAlumnos trieAlumnos, String palabra) {
        nodoAlumnos actual = this.raiz;
        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            int indice = (int) caracter;
            while (i != (palabra.length() - 1)) { // i llega hasta el anteultimo y actualiza actual a el ultimo
                actual = actual.hijos[indice];
                // actualiza para tener la instancia de carrera
            }
        }
        return actual;
    }

    public int tamañoTrie() {
        return cantidadNodos;
    }
}
