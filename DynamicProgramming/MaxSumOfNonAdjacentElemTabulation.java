package DynamicProgramming;

import java.util.Arrays;

public class MaxSumOfNonAdjacentElemTabulation {

    static int solveUtil(int n, int[] arr, int[] dp) {
        dp[0] = arr[0];

        if(n == 0) return 0;

        for(int i=1; i<n; i++) {
            int pick = arr[i];

            if(i>1) {
                pick += dp[i-2];
            }
            int nonPick = dp[i-1];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[n-1];
    }

    static int solve(int n, int[] arr) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return solveUtil(n, arr, dp);
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
        int n = 4;

        int result = solve(n,arr);
        System.out.println(result);
    }
}
