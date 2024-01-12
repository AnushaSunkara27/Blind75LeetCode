package Recursion;

public class XpowerN {
    
    public static int xpowerN(int n, int x) {
        if(n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        return x * xpowerN(n-1, x);
    }

    public static void main(String[] args) {
        int n = 5;
        int x = 2;

        System.out.println(xpowerN(n, x));
    }
}
