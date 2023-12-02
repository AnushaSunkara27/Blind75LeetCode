package Binary;

import java.util.Arrays;

public class MissingNumberInArray {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if(nums[n-1] != n) return n;
        
        int j = 0;
        for(int i: nums) {
            if(i != j) {
                return j;
            }
            j++;
        }
        return -1;
    }

    
}
