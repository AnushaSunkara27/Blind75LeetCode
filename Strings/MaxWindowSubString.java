package Strings;

import java.util.HashMap;
import java.util.Map;

public class MaxWindowSubString {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length()   == 0)   {
            return "";
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int requiredChars = t.length();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (targetMap.containsKey(currentChar)) {
                targetMap.put(currentChar, targetMap.get(currentChar) - 1);
                if (targetMap.get(currentChar) >= 0) {
                    requiredChars--;
                }
            }

            while (requiredChars == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    targetMap.put(leftChar, targetMap.get(leftChar) + 1);
                    if (targetMap.get(leftChar) > 0) {
                        requiredChars++;
                    }
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

}
