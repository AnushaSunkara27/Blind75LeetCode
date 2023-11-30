package Array;

public class FindMinimumInRotatedSortedArray {
    
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        int result = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]) {
                result = Math.min(nums[low], result);
                low = mid + 1;
            } else {
                result = Math.min(nums[mid], result);
                high = mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }
}
