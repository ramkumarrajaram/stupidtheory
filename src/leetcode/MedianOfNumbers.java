package leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MedianOfNumbers {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfNumbers() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);

       // ArrayList
    }
}