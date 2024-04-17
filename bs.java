package lab4;


public class bs {
    public static int fibonacciIterativo(int n) {
        int f = 0, i = 1;
        for (int j = 1; j <= n; j++) {
            f = f + i;
            i = f - i;
        }
        return f;
    }
    
    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(fibonacciIterativo(5));
        System.out.println(fibonacci(5));
    }
}
