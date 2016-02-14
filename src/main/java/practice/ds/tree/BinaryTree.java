package practice.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

	protected Node root;

	protected class Node {

		public Node(int data) {
			this.data = data;
		}

		public int data;
		public Node left;
		public Node right;
	}

	// TODO: recursive level order insert
	public void insert(int data) {

		if (root == null) {
			root = new Node(data);
		} else {

			Queue<Node> queue = new LinkedList<Node>();
			queue.offer(root);

			while (!queue.isEmpty()) {

				Node temp = queue.poll();

				if (temp.left == null) {
					temp.left = new Node(data);
					break;
				} else if (temp.right == null) {
					temp.right = new Node(data);
					break;
				} else {
					queue.offer(temp.left);
					queue.offer(temp.right);
				}
			}
		}

	}

	public enum TraversalType {

		INORDER, PREORDER, POSTORDER, LEVELORDER
	}

	public List<Integer> traverseTree(TraversalType traversalType) {

		List<Integer> list = new ArrayList<>();

		switch (traversalType) {

		case INORDER:
			inOrder(root, list);
			break;

		case PREORDER:
			preOrder(root, list);
			break;

		case POSTORDER:
			postOrder(root, list);
			break;

		default:
			System.out.println("NOT supported");

		}

		return list;

	}

	private void inOrder(Node node, List<Integer> list) {

		if (node != null) {
			inOrder(node.left, list);
			list.add(node.data);
			inOrder(node.right, list);
		}

	}

	private void preOrder(Node node, List<Integer> list) {

		if (node != null) {
			list.add(node.data);
			preOrder(node.left, list);
			preOrder(node.right, list);
		}

	}

	private void postOrder(Node node, List<Integer> list) {

		if (node != null) {
			postOrder(node.left, list);
			postOrder(node.right, list);
			list.add(node.data);
		}

	}

	public int[] toArray() {

		List<Integer> list = new ArrayList<>();

		// stop adding children of empty nodes after we have iterated over all
		// nodes < (height -1)
		// no need to add children empty nodes for empty nodes on last level
		int heightOfTree = this.heightOfTree();
		int totalNumOfNodesInTreeMinusLastLevel = (int) Math.pow(2,
				heightOfTree) - 1;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			Node node = queue.poll();
			list.add(node.data);

			if (node.left != null) {
				queue.add(node.left);
			} else if (list.size() <= totalNumOfNodesInTreeMinusLastLevel) {
				queue.add(new Node(-1));
			}

			if (node.right != null) {
				queue.add(node.right);

			} else if (list.size() <= totalNumOfNodesInTreeMinusLastLevel) {

				queue.add(new Node(-1));
			}
		}

		int[] result = list.stream().mapToInt(i -> i).toArray();
		// System.out.println(Arrays.toString(result));
		return result;

		// list.stream().mapToInt(Integer::intValue).toArray();

	}

	public int heightOfTree() {

		return heightOfTree(root);
	}

	private int heightOfTree(Node node) {

		if (node == null) {
			return -1;
		} else {
			int heightOfLeftTree = 1 + heightOfTree(node.left);
			int heightOfRightTree = 1 + heightOfTree(node.right);

			return (heightOfLeftTree > heightOfRightTree) ? heightOfLeftTree
					: heightOfRightTree;
		}

	}

}
