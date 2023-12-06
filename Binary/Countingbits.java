package Binary;

public class Countingbits {
    
    public int[] countBitsBruteForce(int n) {
        int[] result = new int[n+1];
        result[0] = 0;

        for(int i=1; i<=n; i++) {
            int count = 0;
            int temp = i;
            while(temp > 0) {
                int rem = temp % 2;
                if(rem == 1) {
                    count++;
                }
                temp = temp/2;
            }
            result[i] = count;
        }
        return result;
    }

    public int[] countingBitsOptimal(int n) {
        int[] dp = new int[n+1];
        int offset = 1;
        for(int i=1; i<=n; i++) {
            if(i == offset * 2) {
                offset = i;
            }
            dp[i] = 1 + dp[i-offset];
        }

        return dp;
    }
}
