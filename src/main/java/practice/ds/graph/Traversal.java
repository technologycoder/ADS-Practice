package practice.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.ds.graph.Graph.Node;
import practice.ds.graph.Graph.State;

public class Traversal {

	public static void dequeTest() {

		Deque<String> stack = new ArrayDeque<String>();

		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");

		System.out.println("");

		Deque<String> queue = new ArrayDeque<String>();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");
		while (!queue.isEmpty())
			System.out.print(queue.remove() + " ");
	}

	public static <E> List<Node<E>> bfs(Graph<E> graph, Node<E> start) {

		List<Node<E>> traversal = new ArrayList<>();
		Queue<Node<E>> queue = new LinkedList<>();

		start.state = State.Visiting;
		queue.add(start);

		while (!queue.isEmpty()) {

			Node<E> node = queue.remove();
			for (Node<E> n : node.neighbors) {

				if (n.state == State.Unvisited) {
					n.state = State.Visiting;
					queue.add(n);
				}
			}
			node.state = State.Visited;
			traversal.add(node);

		}

		return traversal;

	}

	public static <E> List<Node<E>> dfs(Graph<E> graph, Node<E> start) {

		List<Node<E>> traversal = new ArrayList<>();

		Deque<Node<E>> stack = new ArrayDeque<>();

		start.state = State.Visiting;
		stack.push(start);

		while (!stack.isEmpty()) {

			Node<E> node = stack.remove();

			for (Node<E> n : node.neighbors) {

				if (n.state == State.Unvisited) {
					n.state = State.Visiting;
					stack.add(n);
				}

			}

			node.state = State.Visited;
			traversal.add(node);

		}

		return traversal;

	}

}
