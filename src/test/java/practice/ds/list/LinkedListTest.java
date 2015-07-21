package practice.ds.list;

import java.util.stream.IntStream;

import org.junit.Test;

public class LinkedListTest {
	
	@Test
	public void linkedListAdd() {
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		IntStream.range(0, 10).forEach(i -> linkedList.addNode(i));
		
		linkedList.displayList();
		
	}

}
