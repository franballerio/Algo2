package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;

    private class Nodo {
        // Agregar atributos privados del Nodo
        private Nodo arriba;
        private T valor;
        private Nodo izq;
        private Nodo der;

        // Crear Constructor del nodo
        public Nodo(T elem) {
            valor = elem;
            izq = der = arriba = null;
        }
    }

    public ABB() {
        raiz = null;
    }

    public int cardinal() {
        return contar(raiz);
    }

    private int contar(Nodo n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + contar(n.izq) + contar(n.der);
        }
    }

    public T minimo() {
        return minimoAux(raiz);
    }

    private T minimoAux(Nodo n) {
        if (n.izq == null) {
            return n.valor;
        } else {
            return minimoAux(n.izq);
        }
    }

    public T maximo() {
        return maxAux(raiz);
    }

    private T maxAux(Nodo n) {
        if (n.der == null) {
            return n.valor;
        } else {
            return maxAux(n.der);
        }
    }

    public void insertar(T elem) {
        if (!pertenece(elem)) {
            if (raiz == null) {
                raiz = new Nodo(elem);
            } else {
                insertarNodo(raiz, elem);
            }
        }
    }

    private void insertarNodo(Nodo n, T elem) {
        if (elem.compareTo(n.valor) < 0) {
            if (n.izq != null) {
                insertarNodo(n.izq, elem);
            } else {
                n.izq = new Nodo(elem);
                n.izq.arriba = n;
            }
        } else {
            if (n.der != null) {
                insertarNodo(n.der, elem);
            } else {
                n.der = new Nodo(elem);
                n.der.arriba = n;
            }
        }
    }

    public boolean pertenece(T elem) {
        return perteneceAux(raiz, elem);
    }

    private boolean perteneceAux(Nodo n, T elem) {
        if (n == null) {
            return false;
        }
        if (elem.compareTo(n.valor) == 0) {
            return true;
        } else if (elem.compareTo(n.valor) > 0) {
            return perteneceAux(n.der, elem);
        } else {
            return perteneceAux(n.izq, elem);
        }
    }

    public void eliminar(T elem) {
        raiz = eliminarNodo(raiz, elem);
    }

    private Nodo eliminarNodo(Nodo n, T elem) {
        if (n == null) {
            return null;
        }

        if (elem.compareTo(n.valor) < 0) {
            n.izq = eliminarNodo(n.izq, elem);
        } else if (elem.compareTo(n.valor) > 0) {
            n.der = eliminarNodo(n.der, elem);
        } else {
            if (n.izq == null) {
                return n.der;
            } else if (n.der == null) {
                return n.izq;
            } else {
                T minValue = minimoAux(n.der);
                n.valor = minValue;
                n.der = eliminarNodo(n.der, minValue);
            }
        }
        return n;
    }

    public String toString() {
        String res = toStringAux(raiz);
        return "{" + res.subSequence(0, res.length() - 1) + "}";
    }

    private String toStringAux(Nodo n) {
        if (n == null) {
            return "";
        }
        return toStringAux(n.izq) + n.valor.toString() + "," + toStringAux(n.der);
    }

    private class ABB_Iterador implements Iterador<T> {
        private List<T> elemsOrd;
        private int dedito;

        // Constructor
        public ABB_Iterador() {
            dedito = 0;
            elemsOrd = new ArrayList<>();
            ordenarNodo(raiz, elemsOrd);
        }

        private void ordenarNodo(Nodo n, List<T> list) {
            if (n != null) {
                ordenarNodo(n.izq, list);
                list.add(n.valor);
                ordenarNodo(n.der, list);
            }
        }

        public boolean haySiguiente() {
            return dedito < elemsOrd.size();
        }

        public T siguiente() {
            if (!haySiguiente()) {
                throw new NoSuchElementException("No more elements in the iterator");
            }
            T actual = elemsOrd.get(dedito);
            dedito++;
            return actual;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}
