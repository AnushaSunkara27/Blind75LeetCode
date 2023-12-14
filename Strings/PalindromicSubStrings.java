package Strings;

public class PalindromicSubStrings {
    public static int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i< s.length(); i++) {
            int l = i;
            int r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res += 1;
                l -= 1;
                r += 1;
            }
            l = i;
            r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res += 1;
                l -= 1;
                r += 1;
            }
            
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "abc";
        System.out.println(countSubstrings(input));
    }
}
