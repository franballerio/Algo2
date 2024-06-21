package aed;


public class TrieMaterias {

    private nodoMaterias raiz;
    private int cantidadNodos;

    public class nodoMaterias {
        nodoMaterias[] hijos;
        Character valorActual;
        Materia materia;                    // indica el fin de la palabra si es distinto de null

        public nodoMaterias() {
            this.hijos = new nodoMaterias[256];
        }
    }

    public TrieMaterias() {
        this.raiz = new nodoMaterias();
        this.cantidadNodos = 0;
    }

    public boolean pertenece(String palabra) {

        if (palabra == null || palabra.length() == 0) {
            return false;
        }

        nodoMaterias nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) {        // Recorre la palabra por caracteres
            char caracter = palabra.charAt(i);              // charAT(i) devuelve el char en la posición i
            int indice = (int) caracter;                    // (int) char devuelve el código ASCII del char

            if (nodoActual.hijos[indice] == null) {         // get(indice) devuelve el hijo en la posición indice
                return false;                               // si el array en el indice es null, la letra no existe
            }
            nodoActual = nodoActual.hijos[indice];          // caso contrario, nodo actual pasa a ser el nodo en
        }                                                   // la posición "indice" del array (la siguiente letra)
        return nodoActual != null && (nodoActual.materia != null); 
                                                            // materiasDeCarrera hace las de fin de palabra
    }

    public void agregar(String palabra) {
        nodoMaterias nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            int indice = (int) caracter;

            if (nodoActual.hijos[indice] != null) { // Si la letra ya está definida, continua por ahí
                nodoActual = nodoActual.hijos[indice];
            } else {
                nodoMaterias nuevoNodo = new nodoMaterias(); // Si no está definida, la define
                nodoActual.hijos[indice] = nuevoNodo;
                nodoActual = nuevoNodo;
                cantidadNodos++;
            }
        }
    }

    // recibe el string a buscar
    public nodoMaterias buscarMateria(String palabra) {
        
        nodoMaterias nodoActual = raiz;

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

    public class iteradorLexiDeMaterias {
        private nodoMaterias _actual;

        public iteradorLexiDeMaterias() {
            nodoMaterias _actual;
        }

        public boolean haySiguiente() {
            return (_actual.hijos != null);
        }

        public Character siguiente() {
            Character adevolver = _actual.valorActual;
            int i = 0;
            while (i < 256 && _actual.hijos[i] == null) {
                // if(_actual.hijosmaterias.get(i) != null){
                _actual = _actual.hijos[i];
                // }
            }
            return adevolver;
        }
        /*
         * aca si bien no es lo mas eficiente ya que va a ser una constante grande (256
         * iteraciones de operaciones O(1)) sigue siendo eficiente contra el nombre de
         * carrera que va a ser algo lineal y potencialmente mucho mas largo
         */

        // public ArrayList<String> Inorder(NodoMaterias RaizdetrieActual){
        // String palabra = "";
        // ArrayList<String> res = new ArrayList<>();
        // for(int i = 0;i < 256;i++){
        // if(RaizdetrieActual.hijosmaterias.get(i) != null){
        // Character char = RaizdetrieActual.hijosmaterias.get(i);
        // palabra.concat(char);
        // }
        // //

        // }

        // }
    }
}