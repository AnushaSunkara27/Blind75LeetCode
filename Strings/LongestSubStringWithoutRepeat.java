package Strings;

import java.util.HashMap;

public class LongestSubStringWithoutRepeat {

    public int lengthOfLongestSubString(String input) {
        int length = 0;
        int left = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int right = 0; right < input.length(); right++) {
            if(!hashMap.containsKey(input.charAt(right))) {
                hashMap.put(input.charAt(right), right);
            } else {
                left = Math.max(left, hashMap.get(input.charAt(right))+1);
                hashMap.put(input.charAt(right), right);
            }
            length = Math.max(length, right-left + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        String input = "abba";
        LongestSubStringWithoutRepeat obj = new LongestSubStringWithoutRepeat();
        System.out.println("Length of longest substring is  "+ obj.lengthOfLongestSubString(input));
    }
}
