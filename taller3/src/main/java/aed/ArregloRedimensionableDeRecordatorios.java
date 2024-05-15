package aed;

import java.util.ArrayList;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private ArrayList<Recordatorio> recordatorios; // usamos de atributo un array de recordatorios

    public ArregloRedimensionableDeRecordatorios() {
        recordatorios = new ArrayList<>(); // crea un array vacio
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        recordatorios = new ArrayList<>(vector.recordatorios);
    }

    public int longitud() {
        return recordatorios.size();
    }

    public void agregarAtras(Recordatorio i) {
        recordatorios.add(i);
    }

    public Recordatorio obtener(int i) {
        return recordatorios.get(i);
    }

    public void quitarAtras() {
        recordatorios.remove(recordatorios.size() - 1);
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        recordatorios.set(indice, valor);

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios a = new ArregloRedimensionableDeRecordatorios(this);

        return a;
    }

}
