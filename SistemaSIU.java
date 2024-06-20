package aed;

import aed.TrieCarreras.nodoCarreras;
import aed.ListaEnlazada.*;
import aed.TrieMaterias.*;
import java.util.*;

public class SistemaSIU {

    private TrieCarreras    trieDeCarreras;
    private TrieAlumnos     trieAlumnos;

    enum CargoDocente{
        AY2,
        AY1,
        JTP,
        PROF
    }

    public SistemaSIU(InfoMateria[] infoMaterias, String[] libretasUniversitarias){
        
        trieDeCarreras = new TrieCarreras();        // creamos los tries vacios
        trieAlumnos = new TrieAlumnos();

        for (int i = 0; i < infoMaterias.length; i++) {           // iteramos sobre cada infoMateria (osea entre cada materia general)
            Materia nuevaMateria = new Materia();                // creamos el objeto materia para el aliasing

            for (int j = 0; j < infoMaterias[i].getParesCarreraMateria().length; j++) {                   // iteramos sobre cada (carrera, materia) de una misma materia general
                String nombreCarrera = infoMaterias[i].getParesCarreraMateria()[j].getCarrera();         // accedemos al nombreCarrera
                String nombreMateria = infoMaterias[i].getParesCarreraMateria()[j].getNombreMateria();  // accedemos al nombreMateria

                trieDeCarreras.agregar(nombreCarrera);                                                              // enchufamos la carrera
                nodoCarreras ultNodoCarreras = trieDeCarreras.buscarCarrera(nombreMateria);                        // guardamos el ultimo nodo de la carrera
                
                if (ultNodoCarreras.materiasDeCarrera != null) {                                                 // le enchufamos la materia al trieMaterias de la carrera
                    ultNodoCarreras.materiasDeCarrera.agregar(nombreMateria);
                } else {
                    ultNodoCarreras.materiasDeCarrera = new TrieMaterias();
                    ultNodoCarreras.materiasDeCarrera.agregar(nombreMateria);
                }                                   

                nuevaMateria.agregarCarMat(ultNodoCarreras, nombreMateria);     // agregamos la mausquerramienta misteriosa que nos servira para mas adelante
                                                                               // al obj materia le metemos un puntero al ultimo nodo de carrera y el nombreMateria
                
                ultNodoCarreras.materiasDeCarrera.buscarMateria(nombreMateria).materia = nuevaMateria;      // apuntamos el ultimo nodo de la materia al onjeto materia
            }
        }

        for (int k = 0; k < libretasUniversitarias.length; k++) {           // enchufamos en el trieAlumnos a todas las LU
            trieAlumnos.agregar(libretasUniversitarias[k]);
        }
    }
    
    public void inscribir(String estudiante, String carrera, String materia){
    }

    public void agregarDocente(CargoDocente cargo, String carrera, String materia){
    }

    public int[] plantelDocente(String materia, String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");	    
    }

    public void cerrarMateria(String materia, String carrera){
       /* TrieMaterias trieDelaMActual = this.trieDeCarreras.buscarUltimo(this.trieDeCarreras,carrera).materiasDeCarrera;
        Materia objetoDeMateria = trieDelaMActual.buscarUltimo(trieDelaMActual, materia).instanciademateria;
        trieDelaMActual.eliminar(materia);
        nodo actual = objetoDeMateria.infoMateria.primero(); 
        while(actual.siguiente != null){
            if(actual.valor.t2() != palabra){
                nodoCarreras aBorrar = actual.t1();
                NodoMaterias del = buscarUltimo(aBorrar.materiasDeCarrera,actual1.t2());
                del.instanciademateria = null; 
            }
            actual = actual.siguiente;
        }*/
    return;
    }

    public int inscriptos(String materia, String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public boolean excedeCupo(String materia, String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public String[] carreras(){
        throw new UnsupportedOperationException("Método no implementado aún");	    
    }

    public String[] materias(String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");	    
    }

    public int materiasInscriptas(String estudiante){
        return this.trieAlumnos.buscarUltimo(this.trieAlumnos,estudiante).cantidadMateriasInscripto ; // hay que implementar buscarAlumno en el trieAlumnos	    
    }
    
}
