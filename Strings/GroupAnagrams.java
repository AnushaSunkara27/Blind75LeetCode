package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String str: strs) {
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);

            if(!hashMap.containsKey(sortedString)) {
                hashMap.put(sortedString, new ArrayList<>());
            }
            hashMap.get(sortedString).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
