package algoritmos;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        fibonacciIterativo(n);
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacciRecursivo(i) + " ");
        }
    }
    
    public static void fibonacciIterativo(int n) {
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
    }
    
    public static int fibonacciRecursivo(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
    }
}
