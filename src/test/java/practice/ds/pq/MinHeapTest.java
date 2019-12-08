package practice.ds.pq;

import org.junit.Test;
import practice.ds.tree.TreeUtil;

public class MinHeapTest {
    @Test
    public void insert() throws Exception {

        MinHeap minHeap = new MinHeap(20);

        int[] data = {2, 4, 3, 6, 9, 5, 10, 14};
        minHeap.insert(data);

        TreeUtil.printTree(minHeap.toArray());

        minHeap.insert(1);

        TreeUtil.printTree(minHeap.toArray());

    }

}
