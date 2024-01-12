package Recursion;

public class SumOfNumbers {
    
    public static int sumNumbers(int n, int sum) {
        if(n == 0) {
            return sum;
        }
        return n+ sumNumbers(n-1, sum);

    }

    public static void main(String[] args) {
        int n = 5;
        int sum = 0;
        System.out.println(sumNumbers(n, sum));
    }
}
