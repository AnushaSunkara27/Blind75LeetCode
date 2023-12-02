package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            for(int j = i+1; j< nums.length; j++) {
                for(int k=j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        List<Integer> tripletArray = new ArrayList<>();
                        tripletArray.add(nums[i]);
                        tripletArray.add(nums[j]);
                        tripletArray.add(nums[k]);
                        Collections.sort(tripletArray);
                        if(!hashSet.contains(tripletArray)) {
                            result.add(tripletArray);
                        }
                        hashSet.add(tripletArray);
                    }
                }
            }
        }
        return result;
    }

    // Time complexity is O(n^2 + logM) 
    public List<List<Integer>> threeSumBetter(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> tripletHashSet = new HashSet<>();

        for(int i=0; i< nums.length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j=i+1; j< nums.length; j++) {
                int thirdValue = -(nums[i] + nums[j]);
                if(hashSet.contains(thirdValue)) {
                    List<Integer> tripletArray = new ArrayList<>();
                    tripletArray.add(nums[i]);
                    tripletArray.add(nums[j]);
                    tripletArray.add(thirdValue);
                    Collections.sort(tripletArray);
                    if(!tripletHashSet.contains(tripletArray)) {
                        result.add(tripletArray);
                        tripletHashSet.add(tripletArray);
                    }
                    hashSet.add(nums[j]);
                } else {
                    hashSet.add(nums[j]);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            //remove duplicates:
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            //moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
