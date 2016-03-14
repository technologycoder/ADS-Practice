package practice.ctci;

import org.junit.Assert;
import org.junit.Test;

import practice.ds.list.LinkedList;
import practice.ds.list.LinkedList.Node;

public class LinkedListsTest {

	@Test
	public void removeDups() {

		LinkedList linkedList = new LinkedList(new int[] { 2, 4, 4, 7, 2, 8, 4, 2 });

		Assert.assertEquals("2 -> 4 -> 4 -> 7 -> 2 -> 8 -> 4 -> 2", linkedList.toString());

		LinkedLists.removeDups(linkedList);

		Assert.assertEquals("2 -> 4 -> 7 -> 8", linkedList.toString());

	}

	@Test
	public void removeDupsWithBuffer() {

		LinkedList linkedList = new LinkedList(new int[] { 2, 4, 4, 7, 2, 8, 4, 2 });

		Assert.assertEquals("2 -> 4 -> 4 -> 7 -> 2 -> 8 -> 4 -> 2", linkedList.toString());

		LinkedLists.removeDupsWithBuffer(linkedList);

		Assert.assertEquals("2 -> 4 -> 7 -> 8", linkedList.toString());

	}

	@Test
	public void kthToLast_4() {

		LinkedList linkedList = new LinkedList(new int[] { 2, 5, 4, 7, 9, 8, 10, 34 });

		Assert.assertEquals("2 -> 5 -> 4 -> 7 -> 9 -> 8 -> 10 -> 34", linkedList.toString());

		Node node = LinkedLists.kthToLast(linkedList, 4);

		Assert.assertEquals(9, node.data);

	}

	@Test
	public void kthToLast_1() {

		LinkedList linkedList = new LinkedList(new int[] { 2, 5, 4, 7, 9, 8, 10, 34 });

		Assert.assertEquals("2 -> 5 -> 4 -> 7 -> 9 -> 8 -> 10 -> 34", linkedList.toString());

		Node node = LinkedLists.kthToLast(linkedList, 1);

		Assert.assertEquals(34, node.data);

	}

	@Test
	public void kthToLast_20() {

		LinkedList linkedList = new LinkedList(new int[] { 2, 5, 4, 7, 9, 8, 10, 34 });

		Assert.assertEquals("2 -> 5 -> 4 -> 7 -> 9 -> 8 -> 10 -> 34", linkedList.toString());

		Node node = LinkedLists.kthToLast(linkedList, 20);

		Assert.assertNull(node);

	}

	@Test
	public void kthToLast_ctci_4() {

		LinkedList linkedList = new LinkedList(new int[] { 2, 5, 4, 7, 9, 8, 10, 34 });

		Assert.assertEquals("2 -> 5 -> 4 -> 7 -> 9 -> 8 -> 10 -> 34", linkedList.toString());

		Node node = LinkedLists.kthToLast_ctci(linkedList, 4);

		Assert.assertEquals(9, node.data);

	}

	@Test
	public void kthToLast_ctci_1() {

		LinkedList linkedList = new LinkedList(new int[] { 2, 5, 4, 7, 9, 8, 10, 34 });

		Assert.assertEquals("2 -> 5 -> 4 -> 7 -> 9 -> 8 -> 10 -> 34", linkedList.toString());

		Node node = LinkedLists.kthToLast_ctci(linkedList, 1);

		Assert.assertEquals(34, node.data);

	}

	@Test
	public void kthToLast_ctci_20() {

		LinkedList linkedList = new LinkedList(new int[] { 2, 5, 4, 7, 9, 8, 10, 34 });

		Assert.assertEquals("2 -> 5 -> 4 -> 7 -> 9 -> 8 -> 10 -> 34", linkedList.toString());

		Node node = LinkedLists.kthToLast_ctci(linkedList, 20);

		Assert.assertNull(node);

	}

	@Test
	public void kthToLast_ctci_0() {

		LinkedList linkedList = new LinkedList(new int[] { 2, 5, 4, 7, 9, 8, 10, 34 });

		Assert.assertEquals("2 -> 5 -> 4 -> 7 -> 9 -> 8 -> 10 -> 34", linkedList.toString());

		Node node = LinkedLists.kthToLast_ctci(linkedList, 0);

		Assert.assertNull(node);

	}

}
