package Strings;

import java.util.HashSet;

public class LongestSubStringWithoutRepeat {

    public int lengthOfLongestSubString(String s) {
        HashSet<Character> characters = new HashSet<>();
        int maxCount = 0;
        int i = 0;
        int j = 0;
        int currentCount = 0;
        while(j< s.length()) {
            if(characters.contains(s.charAt(j))) {
                characters.remove(s.charAt(i));
                i++;
            } else {
                characters.add(s.charAt(j));
                j++;
                currentCount = j-i;
                maxCount = Math.max(currentCount, maxCount);
            }
        }
        return maxCount;
    }

    

    public static void main(String[] args) {
        String input = "abcabcbb";
        LongestSubStringWithoutRepeat obj = new LongestSubStringWithoutRepeat();
        System.out.println("Length of longest substring is  "+ obj.lengthOfLongestSubString(input));
    }
}
