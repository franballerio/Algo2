package aed;

public class Fecha {

    // los atributos de las clases son como los observadores de los tads
    private int _d;
    private int _m;


    public Fecha(int dia, int mes) {
        if (isValidFecha(dia, mes)) { // evaluamos que nos pasen dia y mes validos
            _d = dia;
            _m = mes;
            // seteamos los atributos de Fecha y construimos un nuevo objeto Fecha
        }
    }

    private boolean isValidFecha(int d, int m) {
        return d <= diasEnMes(m) && 1 <= d && 1 <= m && m <= 12; // consulta si el dia y mes son validos 
    }

    public Fecha(Fecha fecha) {
        // constructor de Fecha, pero recibe un tipo Fecha ya. Usado para crear copias
        new Fecha(fecha.dia(), fecha.mes());
    }

    public Integer dia() {
        return _d;
    }

    public Integer mes() {
        return _m;
    }

    @Override
    public String toString() {
        // pasamos fecha a string
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(dia().toString() + "/" + mes().toString());

        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otra) {
        // comparamos fecha con otra de la manera fecha.equals(otra)

        boolean oen = (otra == null); // guarda en oen si otra es null o no

        boolean cd = (this.getClass() != otra.getClass()); // guarda en cd si otra tiene otra clase o no

        if (cd || oen) {
            return false;
        }

        Fecha otraf = (Fecha) otra; // casteamos otra para que sea del tipo fecha

        return _d == otraf.dia() && _m == otraf.mes(); // comparamos atributos

    }

    public void incrementarDia() {
        if (_d < diasEnMes(_m)) {
            _d++;
        } else {
            _d = 1;
            _m++;
        }
        if (_m > 12) {
            _m = 1;
        }
        ;
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
