package aed;

public class Horario {

    private int hs;
    private int mins;

    public Horario(int hora, int minutos) {
        hs = hora;
        mins = minutos;
    }

    public Horario(Horario horario) {
        new Horario(horario.hora(), horario.minutos());
    }

    public Integer hora() {
        return hs;
    }

    public Integer minutos() {
        return mins;
    }

    @Override
    public String toString() {
        // creamos nuestro toString()
        StringBuffer sbuffer = new StringBuffer(); // creamos instancia de StingBuffer, que es una lista de char

        sbuffer.append(hora().toString() + ":" + minutos().toString()); // seteamos y concatenamos el disenio de nuestro
                                                                        // string

        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {

        boolean OtroEsNulo = (otro == null); // otro es null

        boolean OtroTipo = (otro.getClass() != this.getClass()); // otro es de otra clase

        if (OtroEsNulo || OtroTipo) {
            return false;
        }

        Horario otroH = (Horario) otro; // casteamos

        return hs == otroH.hora() && mins == otroH.minutos();

    }

}
