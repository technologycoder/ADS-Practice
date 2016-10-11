package practice.ctci.graph;

import java.util.Stack;

public class ConnectedCellDFS {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 } };

		// System.out.println(Arrays.deepToString(matrix));

		// System.out.println(Arrays.deepToString(matrix).replace("], ",
		// "]\n"));

		System.out.println(getBiggestRegion(matrix));
	}

	public static int getBiggestRegion(int[][] matrix) {

		int[][] visited = new int[matrix.length][matrix[0].length];

		int maxRegionSize = 0;

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {

				if (visited[i][j] == 1) {
					continue;
				} else if (matrix[i][j] == 0) {
					visited[i][j] = 1;
					continue;
				}

				int regionSize = getRegionSize(i, j, visited, matrix);

				if (regionSize > maxRegionSize)
					maxRegionSize = regionSize;

			}
		}

		return maxRegionSize;
	}

	public static int getRegionSize(int i, int j, int[][] visited, int[][] matrix) {

		int regionSize = 0;

		Stack<Cell> stack = new Stack<>();

		Cell startCell = new Cell(i, j);
		visited[i][j] = 1;

		stack.push(startCell);

		int rowLength = matrix.length;
		int columnLength = matrix[0].length;

		while (!stack.isEmpty()) {

			// System.out.println(stack);

			Cell cell = stack.pop();
			regionSize++;

			// System.out.println(cell);

			int rowMin = cell.i - 1;
			int rowMax = cell.i + 1;

			int colMin = cell.j - 1;
			int colMax = cell.j + 1;

			for (int m = rowMin; m <= rowMax; m++) {

				if (m < 0 || m > rowLength - 1)
					continue;

				for (int n = colMin; n <= colMax; n++) {

					if (n < 0 || n > columnLength - 1)
						continue;

					if (visited[m][n] == 1)
						continue;

					if (matrix[m][n] == 0) {
						visited[m][n] = 1;
						continue;
					}

					Cell tempCell = new Cell(m, n);
					visited[m][n] = 1;
					stack.push(tempCell);

				}
			}

		}

		return regionSize;

	}

	static class Cell {
		int i;
		int j;

		public Cell(int m, int n) {
			i = m;
			j = n;
		}

		@Override
		public String toString() {
			return "Cell [i=" + i + ", j=" + j + "]";
		}

	}

}
