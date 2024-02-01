package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
      int n = nums.length;
      if (n == 0) {
        return 0;
      }

      int[] dp = new int[n];
      Arrays.fill(dp, 1);

      for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
      }

      int maxL = Arrays.stream(dp).max().orElse(1);
      return maxL;
    }

    public int lengthOfLISUsingDP(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
    
        int[] dp = new int[n];
        int len = 0;
    
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
    
            dp[index] = num;
    
            if (index == len) {
                len++;
            }
        }
    
        return len;
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        int len = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }

            dp[index] = num;

            if (index == len) {
                len++;
            }
        }

    return len;
    }
    // Time complexity is O(n^2)
    public int lengthOfLISBrute(int[] nums) {
        int n = nums.length;
        if (n == 0) {
          return 0;
        }
  
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
  
        for (int i = 1; i < n; i++) {
          for (int j = 0; j < i; j++) {
              if (nums[i] > nums[j]) {
                  dp[i] = Math.max(dp[i], dp[j] + 1);
              }
          }
        }
  
      int maxL = Arrays.stream(dp).max().orElse(1);
      return maxL;
      }
}
