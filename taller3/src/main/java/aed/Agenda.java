package aed;

public class Agenda {

    private Fecha date;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        date = new Fecha(fechaActual.dia(), fechaActual.mes());
        recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(date.toString() + "\n=====\n"); // agregamos todo menos los recordatorios
        int i = 0;
        while (i < recordatorios.longitud()) {
            if (recordatorios.obtener(i).fecha().equals(date)) {
                sbuffer.append(recordatorios.obtener(i).toString() + "\n");
            }
            i++;
        }
        // usamos un bucle para ir agregando los recordatorios de a uno,
        // pero solo agregamos a sbuffer los que sean de la fecha actual
        return sbuffer.toString();
    }

    public void incrementarDia() {
        date.incrementarDia();

    }

    public Fecha fechaActual() {
        return new Fecha(date.dia(), date.mes());
    }

}
