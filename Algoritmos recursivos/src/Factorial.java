public class Factorial {
    public static void main(String[] args) {
        int n = 8; //damos el numero que queremos su factorial
        System.out.println(factorialRecursivo(n));
    }

    public static int factorialRecursivo(int n) {
        // Inicio
        if ( n <= 1) {
            return n;  //regresa
        }
        return n * factorialRecursivo(n-1); // regresa
    }
}