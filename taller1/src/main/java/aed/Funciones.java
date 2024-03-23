package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    boolean esPar(int n) {
        return n % 2 == 0;
    }

    boolean esBisiesto(int n) {
        return n % 400 == 0 || n % 4 == 0 && n % 100 != 0;
    }

    int factorialIterativo(int n) {

        int result = n;

        if (n == 0) {
            return 1;
        }

        for (int i = n - 1; i > 1; i--) {
            result *= i;
        }

        return result;
    }

    int factorialRecursivo(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorialRecursivo(n - 1);
    }

    boolean esPrimo(int n) {

        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    int sumatoria(int[] numeros) {

        int result = 0;

        for (int i = 0; i < numeros.length; i++) {
            result += numeros[i];
        }

        return result;
    }

    int busqueda(int[] numeros, int buscado) {

        int idx = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                idx = i;
            }
        }
        return idx;
    }

    boolean tienePrimo(int[] numeros) {

        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])) {
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    boolean esPrefijo(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    boolean esSufijo(String s1, String s2) {
        String f1 = new StringBuilder(s1).reverse().toString();
        String f2 = new StringBuilder(s2).reverse().toString();

        if (s1.length() > s2.length()) {
            return false;
        }

        return esPrefijo(f1, f2);
    }
}
