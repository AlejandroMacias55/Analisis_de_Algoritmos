public class Suma {
    public static void main(String[] args) {

        System.out.println(sumaIterativa(7, 16));
    }

    public static int sumaIterativa(int a, int b) {
        int result = b;
        while (a > 0) {
            result++;
            a--;
        }
        return result;
    }


}
