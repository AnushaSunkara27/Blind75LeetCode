package Array;

import java.util.Arrays;
import java.util.HashMap;

class TwoSum {

    // Time complexity is O(n) - single loop through the array
    // Space complexity is O(n) - Space used by hashMap. In worst case It stores n key-value pairs
    public int[] calculateTwoSum(int[] inputArray, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i < inputArray.length; i++) {
            int difference = target - inputArray[i];
            if(hashMap.containsKey(difference)) {
                result[0] = i;
                result[1] = hashMap.get(difference);
            } else {
                hashMap.put(inputArray[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] inputArray = {2,1,3,5,8};
        int[] result = twoSum.calculateTwoSum(inputArray, 9);
        System.out.println("Result: "+ Arrays.toString(result));
    }
}