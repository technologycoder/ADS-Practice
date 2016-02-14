package practice.ds.tree;

import java.util.Random;

public class TreeUtil {

	public static void printTree(int[] tree) {

		int height = height(tree.length);

		int nodesOnLevel = nodesOnLevel(height);

		int maxChars = nodesOnLevel * 10;

		int level = -1;

		for (int i = 0; i < tree.length; ++i) {

			int indexLevel = level(i);
			int nodesOnCurrLevel = nodesOnLevel(indexLevel);
			int startCharCount = maxChars / (nodesOnCurrLevel * 2);
			int inBetweenCharCount = startCharCount * 2;

			if (indexLevel > level) {
				// String str = ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
				// .substring(0, (nodesOnCurrLevel / 2) == 0 ? 1
				// : (nodesOnCurrLevel / 2));
				String str = "\n\n\n";
				System.out.print(str);
				level = indexLevel;
				str = String.format("%1$" + startCharCount + "s", "");
				System.out.print(str);

			}
			String data = (tree[i] == -1) ? "*" : String.valueOf(tree[i]);

			String str = String.format("%1$-" + inBetweenCharCount + "s", data);
			System.out.print(str);

		}

		System.out.println("\n\n\n");

	}

	private static void printLevalAndHeight(int[] tree) {

		System.out.println("[index]\t[level]\t[nodes on level]\t[height]");

		for (int i = 0; i < tree.length; ++i) {

			String message = String.format("%s\t%s\t\t%s\t\t\t%s", i, level(i),
					nodesOnLevel(level(i)), height(i));
			System.out.println(message);
		}

	}

	private static int level(int index) {

		return (int) ((Math.log(index + 1) / Math.log(2)));

	}

	private static int nodesOnLevel(int level) {
		return (int) Math.pow(2, level);
	}

	private static int height(int size) {

		return size == 0 ? -1 : level(size - 1);

	}

	public static BinaryTree createBinaryTree(int[] data) {

		BinaryTree tree = new BinaryTree();
		for (int i = 0; i < data.length; ++i) {
			tree.insert(data[i]);

		}

		return tree;

	}

	public static BinarySearchTree createBinarySearchTree(int[] data) {

		BinarySearchTree tree = new BinarySearchTree();
		for (int i = 0; i < data.length; ++i) {
			tree.insert(data[i]);

		}

		return tree;

	}

	public static int[] fillRandomArray(int size) {

		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = Math.abs(random.nextInt() % 100);
		}
		return arr;

	}

}
