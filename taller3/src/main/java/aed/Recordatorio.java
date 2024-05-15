package aed;

import java.util.Objects;

public class Recordatorio {

    private String reminder;
    private Fecha date;
    private Horario hs;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        reminder = mensaje;
        date = new Fecha(fecha.dia(), fecha.mes());
        hs = new Horario(horario.hora(), horario.minutos());
    }

    public Recordatorio(Recordatorio recordatorio) {
        reminder = recordatorio.mensaje();
        date = new Fecha(recordatorio.fecha().dia(), recordatorio.fecha().mes());
        hs = new Horario(recordatorio.horario().hora(), recordatorio.horario().minutos());
    }

    public Horario horario() {
        return new Horario(hs.hora(), hs.minutos()); // devuelve una copia de horario llamando a los atributos, asi
                                                     // evitamos aliasing
    }

    // cuando trabajamos con objetos dentro de otros, debemos devolver siempre una
    // nueva copia de las cosas, asi evitar el aliasin

    public Fecha fecha() {
        return new Fecha(date.dia(), date.mes()); // lo mismo que horario
    }

    public String mensaje() {
        return reminder;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(reminder + " @ " + date.toString() + " " + hs.toString());

        return sbuffer.toString(); // como sbuffer era una lista, la convertimos a string
    }

    @Override
    public boolean equals(Object otro) {

        boolean oen = (otro == null);
        boolean cd = this.getClass() != otro.getClass();

        if (cd || oen) {
            return false;
        }

        Recordatorio otroR = (Recordatorio) otro;
        return Objects.equals(reminder, otroR.reminder) && Objects.equals(date, otroR.date)
                && Objects.equals(hs, otroR.hs);
        // tuvimos que usar objects.equals para que funcione ArregloRedimensionable
    }

}
