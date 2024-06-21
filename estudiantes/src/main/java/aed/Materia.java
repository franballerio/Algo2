package aed;

import java.util.ArrayList;
import aed.TrieCarreras.*;

public class Materia {

    public ListaEnlazada<Tupla<nodoCarreras, String>> infoMateria; // lista enlazada de tuplas tipo (puntero carrera,
                                                                    // nombreMateria)

    private int[] profes; // lista de cantidad de profes (Profe, jtp, Ay1, Ay2) y cant alumnos es (250,
                                       // 100, 20, 30)

    private ListaEnlazada<String> inscriptos; // lista enlazada con las LU (esto lo hacemos para facilitar el metodo
                                              // borrar materia)

    public Materia() {

        ListaEnlazada<Tupla<nodoCarreras, String>> nombres = new ListaEnlazada();           // se crea la lista enlazada vacia; O(1)

        infoMateria = nombres;          // asignacion; O(1)

        profes = new int[4];          // creamos el array {0,0,0,0} donde cada posicion es (Profe, jtp, Ay1, Ay2); O(1) 

        ListaEnlazada<String> alumnos = new ListaEnlazada<>();        // creamos la lista enlazada vacia; O(1)

        inscriptos = alumnos;       // asignacion; O(1)
    }

    public void agregarProfe() {
        profes[0]++;        // modificamos una pos del array; O(1)
    }

    public void agregarJTP() {
        profes[1]++;        // modificamos una pos del array; O(1)
    }

    public void agregarAy1() {
        profes[2]++;        // modificamos una pos del array; O(1)
    }

    public void agregarAy2() {
        profes[3]++;        // modificamos una pos del array; O(1)
    }

    public int[] profes(){
        return this.profes;              // devolvemos un atributo; O(1)
    }

    public ListaEnlazada<String> inscriptos(){
        return this.inscriptos;          // devolvemos un atributo; O(1)
    }

    public ListaEnlazada<Tupla<nodoCarreras, String>> infoMateria() {
        return infoMateria;             // devolvemos un atributo; O(1)
    }

    public void agregarCarMat(nodoCarreras ultimoNodoCarrera, String nombreMateria) {
        Tupla<nodoCarreras, String> nueva = new Tupla<nodoCarreras, String>(ultimoNodoCarrera, nombreMateria);
        // creamos (puntero hacia carrera, nombreMateria); O(1)

        infoMateria.agregarAtras(nueva);        // agregamos a la lista enlazada de infoMateria la tupla; O(1)
    }

    public void agregarAlumno(String alumno) {
        inscriptos.agregarAtras(alumno);        // agregamos a la lista enlazada de alumnos; O(1)
    }

    public int cupo() {
        return profes[0] * 250 + profes[1] * 100 + profes[2] * 20 + profes[4] * 30;
        // devolvemos la cantidad de alumnos que soporta la materia; O(1)
    }
}
