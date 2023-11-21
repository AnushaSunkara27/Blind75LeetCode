package Array;

public class MaximumSubArray {

    public int maxSubAray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for(int i: nums) {
            if(currSum < 0) {
                currSum = 0;
            }
            currSum +=i;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;

    }
    public static void main(String[] args) {
        int[] nums = {-5,-4,-1,-7,-8};
        MaximumSubArray maxSubArray = new MaximumSubArray();
        System.out.println(maxSubArray.maxSubAray(nums));
    }
}
