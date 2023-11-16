package Array;

import java.util.HashSet;

public class ContainsDuplicate {

    // Time complexity is O(n) - single loop
    // space complexity is O(n) - Hashset storing the n values
    public boolean findContainsDuplicate(int[] nums) {
        if(nums.length == 0) return false;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i: nums) {
            if(hashSet.contains(i)) {
                return true;
            } else {
                hashSet.add(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,6,1};

        ContainsDuplicate obj = new ContainsDuplicate();
        System.out.println(obj.findContainsDuplicate(nums));
    }
}
