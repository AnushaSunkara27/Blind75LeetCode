package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i:nums) {
            frequency.put(i, frequency.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<> (
            (a,b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
            minHeap.offer(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while(!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        int[] resultArray = result.stream().mapToInt(Integer::intValue).toArray();
        return resultArray;
    }

    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(topKFrequent(nums, k));

    }

}
