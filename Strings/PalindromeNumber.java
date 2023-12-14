package Strings;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        int temp = x;
        int sum = 0;
        while(x > 0) {
            int rem = x%10;
            sum = sum * 10+ rem;
            x = x/10;
        }
        if(sum == temp) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }
}
