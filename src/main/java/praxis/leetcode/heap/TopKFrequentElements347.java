package praxis.leetcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements347 {
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 1, 1, 2};

        System.out.println(topKFrequent(nums, 2));

    }

    public static List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static List<Integer> topKFrequent1(int[] nums, int k) {

        Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] q1, int[] q2) {

                return q2[1] - q1[1];
            }
        });
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        List<Integer> result = new ArrayList<Integer>();
        while (result.size() < k) {
            result.add(queue.poll()[0]);
        }
        return result;
    }

    // does not work
    public static List<Integer> topKFrequent2(int[] nums, int k) {

        Map<Integer, NumCount> numCountMap = new HashMap<>();
        Queue<NumCount> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            NumCount numCount = numCountMap.get(num);

            if (numCount == null) {
                numCount = new NumCount(num);
                numCountMap.put(num, numCount);
                pq.offer(numCount);
            } else {
                numCount.count++;
            }
            System.out.println(pq);
        }

        System.out.println(pq.peek());

        return null;
    }

    public static class NumCount implements Comparable<NumCount> {
        public int num;

        public int count;

        public NumCount(int num) {

            this.num = num;
            this.count = 1;
        }

        @Override
        public int compareTo(NumCount o) {

            return this.count - o.count;
            // return o.count - this.count;
        }

        @Override
        public String toString() {

            return String.format("%s:%s", num, count);
        }
    }

}
