package practice.ds.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import practice.ds.tree.BinaryTree.TraversalType;

public class BinarySearchTreeTest {

	@Test
	public void insert_complete_BST() {

		int[] data = new int[] { 5, 3, 21, 2, 4, 19, 25 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		int[] arrFromTree = tree.toArray();

		assertArrayEquals(data, arrFromTree);

		TreeUtil.printTree(arrFromTree);

	}

	@Test
	public void toArray() {

		int[] data = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		int[] arrFromTree = tree.toArray();

		assertArrayEquals(new int[] { 8, 3, 10, 1, 6, -1, 14, -1, -1, 4, 7, -1,
				-1, 13, -1 }, arrFromTree);

		// TreeUtil.printTree(arrFromTree);

	}

	@Test
	public void inOrderTraversal() {

		int[] data = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		List<Integer> inorder = tree.traverseTree(TraversalType.INORDER);

		System.out.println(inorder);

		assertArrayEquals(new int[] { 1, 3, 4, 6, 7, 8, 10, 13, 14 }, inorder
				.stream().mapToInt(Integer::intValue).toArray());

		// TreeUtil.printTree(tree.toArray());

	}

	@Test
	public void preOrderTraversal() {

		int[] data = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		List<Integer> preorder = tree.traverseTree(TraversalType.PREORDER);

		System.out.println(preorder);

		assertArrayEquals(new int[] { 8, 3, 1, 6, 4, 7, 10, 14, 13 }, preorder
				.stream().mapToInt(Integer::intValue).toArray());

		// TreeUtil.printTree(tree.toArray());
	}

	@Test
	public void postOrderTraversal() {

		int[] data = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		List<Integer> postorder = tree.traverseTree(TraversalType.POSTORDER);

		System.out.println(postorder);

		assertArrayEquals(new int[] { 1, 4, 7, 6, 3, 13, 14, 10, 8 }, postorder
				.stream().mapToInt(Integer::intValue).toArray());

		TreeUtil.printTree(tree.toArray());
	}

	@Test
	public void exists() {

		int[] data = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		TreeUtil.printTree(tree.toArray());

		assertTrue(tree.exists(4));
		assertTrue(tree.exists(14));
		assertTrue(tree.exists(8));
		assertTrue(tree.exists(6));

		assertFalse(tree.exists(34));
		assertFalse(tree.exists(0));

	}

	@Test
	public void delete_node_with_no_children() {

		int[] data = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		TreeUtil.printTree(tree.toArray());

		assertTrue(tree.delete(13));

		TreeUtil.printTree(tree.toArray());

	}

	@Test
	public void delete_node_with_one_child() {

		int[] data = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		TreeUtil.printTree(tree.toArray());

		assertTrue(tree.delete(10));

		TreeUtil.printTree(tree.toArray());

	}

	@Test
	public void delete_node_with_two_children() {

		int[] data = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		TreeUtil.printTree(tree.toArray());

		assertTrue(tree.delete(3));

		TreeUtil.printTree(tree.toArray());

	}

	@Test
	public void delete_root_node() {

		int[] data = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		BinarySearchTree tree = TreeUtil.createBinarySearchTree(data);

		TreeUtil.printTree(tree.toArray());

		assertTrue(tree.delete(8));

		TreeUtil.printTree(tree.toArray());

	}
}
