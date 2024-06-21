package aed;

public class TrieAlumnos {

    private nodoAlumnos raiz;
    private int cantidadNodos;

    public class nodoAlumnos {
        nodoAlumnos[] hijos;
        Character valorActual;
        Integer materiasInscriptas; // indica el fin de la palabra si es distinto de null

        public nodoAlumnos() {
            this.hijos = new nodoAlumnos[256];
        }
    }

    public TrieAlumnos() {
        this.raiz = new nodoAlumnos();
        this.cantidadNodos = 0;
    }

    public boolean pertenece(String palabra) {

        if (palabra == null || palabra.length() == 0) {
            return false;
        }

        nodoAlumnos nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) { // Recorre la palabra por caracteres
            char caracter = palabra.charAt(i); // charAT(i) devuelve el char en la posición i
            int indice = (int) caracter; // (int) char devuelve el código ASCII del char

            if (nodoActual.hijos[indice] == null) { // get(indice) devuelve el hijo en la posición indice
                return false; // si el array en el indice es null, la letra no existe
            }
            nodoActual = nodoActual.hijos[indice]; // caso contrario, nodo actual pasa a ser el nodo en
        } // la posición "indice" del array (la siguiente letra)
        return nodoActual != null && (nodoActual.materiasInscriptas != null);
        // materiasDeCarrera hace las de fin de palabra
    }

    public void agregar(String palabra) {
        nodoAlumnos nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            int indice = (int) caracter;

            if (nodoActual.hijos[indice] != null) { // Si la letra ya está definida, continua por ahí
                nodoActual = nodoActual.hijos[indice];
            } else {
                nodoAlumnos nuevoNodo = new nodoAlumnos(); // Si no está definida, la define
                nodoActual.hijos[indice] = nuevoNodo;
                nodoActual = nuevoNodo;
                cantidadNodos++;
            }
        }
        if (nodoActual.materiasInscriptas == null) {
            nodoActual.materiasInscriptas = 0;
        }
    }

    // recibe el string a buscar y el trie de Alumnos
    public nodoAlumnos buscarAlumno(String palabra) {

        nodoAlumnos nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            int indice = (int) caracter;

            if (nodoActual.hijos[indice] != null) {
                nodoActual = nodoActual.hijos[indice];
            }
        }
        return nodoActual;
    }

    public int tamañoTrie() {
        return cantidadNodos;
    }

    // public class iteradorLexiDeAlumnos {
    // private nodoAlumnos _actual;

    // public iteradorLexiDeAlumnos() {
    // nodoAlumnos _actual;
    // }

    // public boolean haySiguiente() {
    // return (_actual.hijos != null);
    // }

    // public Character siguiente() {
    // Character adevolver = _actual.valorActual;
    // int i = 0;
    // while (i < 256 && _actual.hijos.get(i) == null) {
    // // if(_actual.hijosmaterias.get(i) != null){
    // _actual = _actual.hijos.get(i);
    // // }
    // }
    // return adevolver;
    // }
    // }
}
