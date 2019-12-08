package practice.ds.tree;

import org.junit.Test;
import practice.ds.tree.BinaryTree.TraversalType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
    @Test
    public void insert() {

        int[] data = TreeUtil.fillRandomArray(10);
        System.out.println(Arrays.toString(data));

        BinaryTree tree = TreeUtil.createBinaryTree(data);

        // level order traversal
        int[] arrFromTree = tree.toArray();

        TreeUtil.printTree(arrFromTree);

        // Arrays.stream(arrFromTree).boxed().filter(i -> i !=
        // -1).collect(Collectors.toList()).mapToInt(i -> i).toArray();

        // int[] treeWithTrailingEmptyNodesRemoved =
        // Arrays.stream(arrFromTree).boxed().filter(i -> i != -1)
        // .mapToInt(i -> i).toArray();
        int[] treeWithTrailingEmptyNodesRemoved = Arrays.copyOf(arrFromTree, data.length);

        assertArrayEquals(data, treeWithTrailingEmptyNodesRemoved);
    }

    @Test
    public void insert_treeWithInternalNodesEmpty() {

        int[] data = new int[]{20, 10, 30, 5, 15, -1, -1, 3, 7, -1, 17};
        System.out.println(Arrays.toString(data));

        BinaryTree tree = TreeUtil.createBinaryTree(data);

        // level order traversal
        int[] arrFromTree = tree.toArray();

        TreeUtil.printTree(arrFromTree);

        // Arrays.stream(arrFromTree).boxed().filter(i -> i !=
        // -1).collect(Collectors.toList()).mapToInt(i -> i).toArray();

        int[] treeWithTrailingEmptyNodesRemoved = Arrays.copyOf(arrFromTree, data.length);

        assertArrayEquals(data, treeWithTrailingEmptyNodesRemoved);
    }

    @Test
    public void inOrderTraversal() {

        int[] data = new int[]{5, 3, 21, 2, 4, 19, 25};
        System.out.println(Arrays.toString(data));

        BinaryTree tree = TreeUtil.createBinaryTree(data);
        int[] arrFromTree = tree.toArray();
        TreeUtil.printTree(arrFromTree);

        List<Integer> inOrder = tree.traverseTree(TraversalType.INORDER);

        System.out.println(inOrder);

        assertEquals("[2, 3, 4, 5, 19, 21, 25]", inOrder.toString());

    }

    @Test
    public void preOrderTraversal() {

        int[] data = new int[]{5, 3, 21, 2, 4, 19, 25};
        System.out.println(Arrays.toString(data));

        BinaryTree tree = TreeUtil.createBinaryTree(data);
        int[] arrFromTree = tree.toArray();
        TreeUtil.printTree(arrFromTree);

        List<Integer> preOrder = tree.traverseTree(TraversalType.PREORDER);

        System.out.println(preOrder);

        assertEquals("[5, 3, 2, 4, 21, 19, 25]", preOrder.toString());

    }

    @Test
    public void postOrderTraversal() {

        int[] data = new int[]{5, 3, 21, 2, 4, 19, 25};
        System.out.println(Arrays.toString(data));

        BinaryTree tree = TreeUtil.createBinaryTree(data);
        int[] arrFromTree = tree.toArray();
        TreeUtil.printTree(arrFromTree);

        List<Integer> postOrder = tree.traverseTree(TraversalType.POSTORDER);

        System.out.println(postOrder);

        assertEquals("[2, 4, 3, 19, 25, 21, 5]", postOrder.toString());

    }

}
