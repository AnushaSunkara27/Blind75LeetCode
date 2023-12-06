package DynamicProgramming;

public class ClimbingStairs {
  
    // Time complexity is O(n) and space complexity is O(n).
    public int climbStairs(int n) {
        if(n<=2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // Time complexity is O(n) and space complexity is O(1).
    public int climbStairs2(int n) {
        if(n<=2) return n;
        int first = 1, second = 2;
        for(int i=1;i<= n-2; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
  
    public int climbStairsOptimal(int n) {
        int pre = 1;
        int curr = 1;
        int temp = 0;

        for(int i=1; i<n; i++) {
            temp = curr;
            curr = curr+pre;
            pre = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(3));
        System.out.println(obj.climbStairs2(3));
    }

}
