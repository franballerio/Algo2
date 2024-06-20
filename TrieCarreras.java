package aed;

public class TrieCarreras {

    private nodoCarreras raiz;
    private int cantidadNodos;

    public class nodoCarreras {
        nodoCarreras[] hijos;
        Character valorActual;
        TrieMaterias materiasDeCarrera; // indica el fin de la palabra si es distinto de null

        public nodoCarreras() {
            this.hijos = new nodoCarreras[256];
        }
    }

    public TrieCarreras() {
        this.raiz = new nodoCarreras();
        this.cantidadNodos = 0;
    }

    public boolean pertenece(String palabra) {

        if (palabra == null || palabra.length() == 0) {
            return false;
        }

        nodoCarreras nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) { // Recorre la palabra por caracteres
            char caracter = palabra.charAt(i); // charAT(i) devuelve el char en la posición i
            int indice = (int) caracter; // (int) char devuelve el código ASCII del char

            if (nodoActual.hijos[indice] == null) { // get(indice) devuelve el hijo en la posición indice
                return false; // si el array en el indice es null, la letra no existe
            }
            nodoActual = nodoActual.hijos[indice]; // caso contrario, nodo actual pasa a ser el nodo en
        } // la posición "indice" del array (la siguiente letra)
        return nodoActual != null && (nodoActual.materiasDeCarrera != null);
        // materiasDeCarrera hace las de fin de palabra
    }

    public void agregar(String palabra) {
        nodoCarreras nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            int indice = (int) caracter;

            if (nodoActual.hijos[indice] != null) { // Si la letra ya está definida, continua por ahí
                nodoActual = nodoActual.hijos[indice];
            } else {
                nodoCarreras nuevoNodo = new nodoCarreras(); // Si no está definida, la define
                nodoActual.hijos[indice] = nuevoNodo;
                nodoActual = nuevoNodo;
                cantidadNodos++;
            }
        }
        if (nodoActual.materiasDeCarrera == null) { // Si termina la palabra y no hay un // trieMaterias asociado, lo
                                                    // genera
            nodoActual.materiasDeCarrera = new TrieMaterias();
        }
    }

    // recibe el string a buscar y el trie de carreras
    public nodoCarreras buscarCarrera(String palabra) {

        nodoCarreras nodoActual = raiz;

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

    // public class iteradorLexiDeCarreras {
    // private nodoCarreras _actual;

    // public iteradorLexiDeCarreras() {
    // nodoCarreras _actual;
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
