package praxis.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};

        System.out.println(findKthLargest(nums, 2));

    }

    public static int findKthLargest(int[] nums, int k) {

        // reverse comparator
        // Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // min heap
        Queue<Integer> pq = new PriorityQueue<>(k);

        for (int num : nums) {

            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        return pq.peek();
    }

}
