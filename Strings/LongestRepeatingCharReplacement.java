package Strings;

public class LongestRepeatingCharReplacement {

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26]; // Assuming only uppercase English letters
    
        int maxCount = 0;
        int maxLength = 0;
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            char currentChar = s.charAt(j);
            count[currentChar - 'A']++;
    
            // Update maxCount with the most frequent character in the current window
            maxCount = Math.max(maxCount, count[currentChar - 'A']);
    
            // If the window size - maxCount > k, shrink the window from the left
            if (j - i + 1 - maxCount > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
    
            // Update the maxLength
            maxLength = Math.max(maxLength, j - i + 1);
        }
    
        return maxLength;
    }
    

    public static int characterReplacementMyApproach(String s, int k) {
        int i = 0;
        int replacements = k;
        int maxLength = 0;
        int currLength = 0;
        for(int j =0; j < s.length(); j++) {
  
          if(s.charAt(i) == s.charAt(j)) {
            currLength++;
          } else {
            if(replacements != 0) {
              currLength++;
              replacements--;
            } else {
              i++;
              j = i;
              currLength = 0;
            }
          }
          maxLength = Math.max(maxLength, currLength);
  
        }
  
        return maxLength;
      }

    public static void main(String[] args) {
        String input = "ABBB";
        System.out.println(characterReplacement(input, 2));
    }
}
