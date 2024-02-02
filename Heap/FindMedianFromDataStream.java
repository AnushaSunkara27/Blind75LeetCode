package Heap;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> maxHeap; // Left half
    PriorityQueue<Integer> minHeap; // Right half

    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num); // Add to the left half

        minHeap.offer(maxHeap.poll()); // Move the largest element of the left half to the right half

        // Ensure that the size of the left half is greater than or equal to the size of the right half
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll()); // Move the smallest element of the right half to the left half
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
