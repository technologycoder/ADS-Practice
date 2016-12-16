package practice.ds.graph;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import practice.ds.graph.Graph.Node;

public class TraversalTest {

	@Test
	public void dequeTest() {

		Traversal.dequeTest();

	}

	@Test
	public void bfs() {

		Integer[][] data = new Integer[][] {

				{ 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 }, { 2, 3 }, { 3, 3 },

		};
		Graph<Integer> graph = Graph.createGraph(data);

		assertEquals("{0=[0] - [Unvisited], 1=[1] - [Unvisited], 2=[2] - [Unvisited], 3=[3] - [Unvisited]}",
				graph.toString());

		List<Node<Integer>> traversal = Traversal.<Integer> bfs(graph, graph.getNode(2));

		assertEquals("[[2] - [Visited], [3] - [Visited], [0] - [Visited], [1] - [Visited]]", traversal.toString());

	}

	@Test
	public void dfs() {

		Integer[][] data = new Integer[][] {

				{ 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 }, { 2, 3 }, { 3, 3 },

		};
		Graph<Integer> graph = Graph.createGraph(data);

		assertEquals("{0=[0] - [Unvisited], 1=[1] - [Unvisited], 2=[2] - [Unvisited], 3=[3] - [Unvisited]}",
				graph.toString());

		List<Node<Integer>> traversal = Traversal.<Integer> bfs(graph, graph.getNode(0));

		assertEquals("[[0] - [Visited], [1] - [Visited], [2] - [Visited], [3] - [Visited]]", traversal.toString());

	}

}
