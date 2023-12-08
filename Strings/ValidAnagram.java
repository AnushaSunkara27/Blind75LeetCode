package Strings;

import java.util.HashMap;

public class ValidAnagram {
    
    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        for(char i: s.toCharArray()) {
            hashMap1.put(i, hashMap1.getOrDefault(i, 0)+1);
        }
        for(char j: t.toCharArray()) {
            hashMap2.put(j, hashMap2.getOrDefault(j, 0)+1);
        }

        if(hashMap1.equals(hashMap2)) {
            return true;
        }

        return false;

    }

    public boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> hashMap1 = new  HashMap<>();

        if(s.length() != t.length()) return false;

        for(char i: s.toCharArray()) {
            hashMap1.put(i, hashMap1.getOrDefault(i, 0)+1);
        }

        for(char j: t.toCharArray()) {
          if(hashMap1.containsKey(j) && hashMap1.get(j)>0) {
            hashMap1.put(j, hashMap1.getOrDefault(j,0)-1);
          } else {
            return false;
          }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
