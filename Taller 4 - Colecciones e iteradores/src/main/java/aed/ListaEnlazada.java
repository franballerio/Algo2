package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {

    private Nodo primero;
    private int longitud;

    private class Nodo { // definimos la clase nodo, con las caracteristicas
                         // que necesitamos para la lista enlazada doble
        Nodo prev;
        T valor;
        Nodo next;

        public Nodo(T elem) {
            valor = elem;
            prev = null;
            next = null;
        }

        public Nodo copiar() {
            Nodo nuevo = new Nodo(valor);
            nuevo.prev = prev;
            nuevo.next = next;
            return nuevo;
        }
    }

    public ListaEnlazada() {
        // creamos una nueva lista enlazada doble, con el "primer" nodo null
        primero = new Nodo(null);
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        if (primero.valor == null) {
            primero.valor = elem;
            // si es una lista vacia (primer nodo null), le cambia el valor a ese nodo
            // primero
        } else {
            // si la lista es no vacia, creamos un nuevo nodo con elem de valor
            // le enlazamos a .next el nodo primero, luego a primero le enlazamos en .prev
            // el nuevo nodo, a nuevo.prev le enlazamos null para que sea el "primero"
            // y finalmente digo que el nuevo nodo es ahora el primero.
            Nodo nuevo = new Nodo(elem);
            primero.prev = nuevo;
            nuevo.next = primero;
            nuevo.prev = null;
            primero = nuevo;
        }
        longitud++;
    }

    public void agregarAtras(T elem) {
        if (primero.valor == null) {
            primero.valor = elem;
            // si es una lista vacia (primer nodo null), le cambia el valor a ese nodo
            // primero;
        } else {
            Nodo actual = primero;
            while (actual.next != null) {
                actual = actual.next;
            } // iteramos hasta el ultimo elemento

            // ahora hacemos lo mismo que en agregar adelante, pero para el otro lado.
            // pero ahora hay q modificar Nodo actual
            Nodo nuevo = new Nodo(elem);
            actual.next = nuevo;
            nuevo.prev = actual;
            nuevo.next = null;
            actual = nuevo;
        }
        longitud++;

    }

    public T obtener(int i) {
        // iteramos hasta el i-esimo nodo, y devuelvo su valor.
        Nodo actual = primero;
        for (int k = 0; k < i; k++) {
            actual = actual.next;
        }
        return actual.valor;

    }

    public void eliminar(int i) {
        // iteramos hasta el i-esimo nodo.
        Nodo actual = primero;
        for (int k = 0; k < i; k++) {
            actual = actual.next;
        }
        // ahora apunto el nodo adelante de actual al nodo atras de actual, y
        // vice versa. pero hay que ver los casos borde
        // el primer elemento y el ultimo elemento.
        // y si hay un solo elemento

        if (actual.next == null && actual.prev == null) { // unico elemento
            actual.valor = null;
        }
        if (actual.next == null && actual.prev != null) { // ultimo elemento
            actual.prev.next = null;
        }
        if (actual.prev == null && actual.next != null) { // primer elemento
            primero = primero.next;
            primero.prev = null;
        }
        if (actual.prev != null && actual.next != null) { // elemento en el medio
            actual.prev.next = actual.next;
            actual.next.prev = actual.prev;
        }
        longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        // iteramos como en obtener
        Nodo actual = primero;
        for (int k = 0; k < indice; k++) {
            actual = actual.next;
        }
        // ahora cambiamos el valor de ese nodo por el nuevo
        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        // creamos una nueva listaenlazada, y copiamos los atributos
        ListaEnlazada<T> nueva = new ListaEnlazada<>();
        nueva.primero = primero.copiar();
        nueva.longitud = longitud;
        return nueva;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        ;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        // por temas esteticos agrego el primer elemento, itero y luego agrego el ultimo
        // elemento
        sbuffer.append("[" + primero.valor.toString() + ", ");
        // iteramos como en obtener
        Nodo actual = primero.next;
        for (int k = 0; k < longitud - 2; k++) {
            sbuffer.append(actual.valor.toString() + ", ");
            actual = actual.next;
        }
        sbuffer.append(actual.valor.toString() + "]");

        return sbuffer.toString(); // como sbuffer era una lista, la convertimos a string;
    }

    private class ListaIterador implements Iterador<T> {

        private int pos;

        public boolean haySiguiente() {

            return pos != longitud;
        }

        public boolean hayAnterior() {
            return pos != 0;
        }

        public T siguiente() {
            int dedito = pos;
            pos++;
            return obtener(dedito);
        }

        public T anterior() {
            int dedito = pos - 1;
            pos--;
            return obtener(dedito);
        }

    }

    public Iterador<T> iterador() {
        ListaIterador nuevo = new ListaIterador();
        nuevo.pos = 0;
        return nuevo;
    }

}
