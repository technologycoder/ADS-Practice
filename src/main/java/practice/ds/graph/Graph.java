package practice.ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<E> {

	private Map<E, Node<E>> nodes = new HashMap<>();

	public void addEdge(E value1, E value2) {

		Node node1 = this.getNode(value1);

		Node node2 = this.getNode(value2);

		// directed graph
		node1.neighbors.add(node2);

		// for undirected graph also add the following
		// node2.neighbors.add(node1);
	}

	public Node getNode(E value) {

		if (this.nodes.containsKey(value)) {
			return this.nodes.get(value);
		} else {
			return this.addNode(value);
		}

	}

	public String toString() {

		return nodes.toString();

	}

	public Node addNode(E val) {

		Node node = new Node();
		node.value = val;
		this.nodes.put(val, node);
		return node;

	}

	public static <E> Graph createGraph(E[][] data) {

		Graph<E> graph = new Graph<>();

		for (int i = 0; i < data.length; ++i) {
			graph.addEdge(data[i][0], data[i][1]);

		}

		return graph;

	}

	public static enum State {
		Unvisited, Visiting, Visited;
	}

	public static class Node<E> {

		public E value;
		public Set<Node<E>> neighbors = new HashSet<>();
		public State state = State.Unvisited;

		public String toString() {

			String str = String.format("[%s] - [%s]", value, state);

			return str;
		}
	}

}
