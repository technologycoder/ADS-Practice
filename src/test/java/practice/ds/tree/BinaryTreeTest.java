package practice.ds.tree;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import practice.ds.tree.BinaryTree.TraversalType;

public class BinaryTreeTest {

	@Test
	public void insert() {

		int[] data = TreeUtil.fillRandomArray(10);
		System.out.println(Arrays.toString(data));

		BinaryTree tree = TreeUtil.createBinaryTree(data);

		int[] arrFromTree = tree.toArray();

		TreeUtil.printTree(arrFromTree);

		assertArrayEquals(data, arrFromTree);
	}

	@Test
	public void inOrderTraversal() {

		int[] data = TreeUtil.fillRandomArray(10);
		System.out.println(Arrays.toString(data));

		BinaryTree tree = TreeUtil.createBinaryTree(data);
		int[] arrFromTree = tree.toArray();
		TreeUtil.printTree(arrFromTree);

		List<Integer> inorder = tree.traverseTree(TraversalType.INORDER);

		System.out.println(inorder);

	}

	@Test
	public void preOrderTraversal() {

		int[] data = TreeUtil.fillRandomArray(10);
		System.out.println(Arrays.toString(data));

		BinaryTree tree = TreeUtil.createBinaryTree(data);
		int[] arrFromTree = tree.toArray();
		TreeUtil.printTree(arrFromTree);

		List<Integer> preorder = tree.traverseTree(TraversalType.PREORDER);

		System.out.println(preorder);

	}

	@Test
	public void postOrderTraversal() {

		int[] data = TreeUtil.fillRandomArray(10);
		System.out.println(Arrays.toString(data));

		BinaryTree tree = TreeUtil.createBinaryTree(data);
		int[] arrFromTree = tree.toArray();
		TreeUtil.printTree(arrFromTree);

		List<Integer> postOrder = tree.traverseTree(TraversalType.POSTORDER);

		System.out.println(postOrder);

	}

}
