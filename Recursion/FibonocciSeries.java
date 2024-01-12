package Recursion;

public class FibonocciSeries {

    public static void printFib(int n, int a, int b) {
        if(n == 0) {
            return;
        }
        int c = a+b;
        System.out.println(c);
        printFib(n-1, b, c);
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(0);
        System.out.println(1);
        printFib(n-2, 0, 1);
    }
    
}
