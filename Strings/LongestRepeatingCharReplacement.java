package Strings;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {

    public int characterReplacement(String input, int k) {
        HashMap<Character,Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;
        int r = 0;
        while(r<input.length()) {
            if(!count.containsKey(input.charAt(r))) {
                count.put(input.charAt(r), 1);
            } else {
                count.put(input.charAt(r),count.get(input.charAt(r))+1);
            }

            int windowSize = r-l+1;
            int maxfreq = Math.max(count.values());
            if(windowSize-maxfreq <= k) {
                r = r+1;
            } else {
                l = l+1;
            }

        }
    }

    public static void main(String[] args) {
        String input = "ABABBA";

    }
}
