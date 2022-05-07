public class Fibonacci {

    public static void main(String[] args) {
        int n = 15;
        fibonacciIterativo(n);
        System.out.println();
        System.out.println("fibonacciRecursivo");

        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacciRecursivo(i) + " ");
        }
        System.out.println("Tiempo de fibonacci Recursivo:"+ System.currentTimeMillis());
    }

    public static void fibonacciIterativo(int n) {
        System.out.println("fibonacciIterativo:");
        int anterior1 = 0;
        int anterior2 = 1;
        int actual;
        System.out.print(anterior1 + " " + anterior2 + " ");
        for (int i = 3; i <= n; i++) {
            actual = anterior1 + anterior2;
            anterior1 = anterior2;
            anterior2 = actual;

            System.out.print(actual + " ");
        }
        System.out.println("Tiempo de fibonacci Iterativo:"+ System.currentTimeMillis());

    }

    public static int fibonacciRecursivo(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }

}