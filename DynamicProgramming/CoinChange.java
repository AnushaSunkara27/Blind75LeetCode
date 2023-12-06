package DynamicProgramming;

public class CoinChange {
  
    //Time complexity is O(n * amount), space complexity is O(amount)
    public int minimumNumOfCoins(int[] coins,int amount) {
        int[] dp = new int[amount+1];
        for(int i=1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<coins.length; j++) {
                if(i >= coins[j] && dp[i-coins[j]] != -1) {
                    min = Math.min(min, dp[i-coins[j]]);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE) ? -1 : 1+min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] coins = {3,5,6};
        System.out.println(obj.minimumNumOfCoins(coins, 6));
    }
}
