package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {

    private Nodo primero;
    private int largo;

    private class Nodo { // definimos la clase nodo, con las caracteristicas
                         // que necesitamos para la lista enlazada doble
        Nodo prev;
        int valor;
        Nodo next;

        public Nodo(T value) {
            T valor = value;
        }
    }

    public ListaEnlazada() {
        // creamos una nueva lista enlazada doble
        primero = null;
    }

    public int longitud() {
        return largo;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem); // creamos el nodo a agregar

        if (primero == null) {
            primero = nuevo;
            primero.next = null;
            primero.prev = null;
            // como la lista estaba vacia ponemos el nodo en la primer posicion,
            // y apunta a null adelante y atras
        } else {
            primero.next = primero;
            primero = nuevo;
        }
        largo++;
    }

    public void agregarAtras(T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public T obtener(int i) {
        ;
    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
        // Completar atributos privados

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public boolean hayAnterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T anterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}