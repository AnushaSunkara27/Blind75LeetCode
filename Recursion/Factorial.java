package Recursion;

public class Factorial {
    
    public static int findFactorial(int n) {

        if(n == 1 || n == 0) {
            return 1;
        }
        int fact1 = findFactorial(n-1);
        int fact_n = n * fact1;
        return fact_n;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(findFactorial(n));
    }
}
