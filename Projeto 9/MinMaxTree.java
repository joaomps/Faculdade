/**
 * @author João Silva, nº 48782
 */

import java.util.ArrayList;

public class MinMaxTree {
	/**
	 * Criacao da arvore a ser utilizado
	 * 
	 * @param <T>
	 *            tipo de dados a ser utilizado
	 */
	public class Tree<T> {
		private Node<T> root;

		/**
		 * construtor de uma arvore
		 * 
		 * @param rootData
		 *            - dados dessa arvore
		 * @param player
		 *            - character do player
		 * @param value
		 *            - value do algoritmo MinMax
		 */
		public Tree(T rootData, char player, int value) {
			root = new Node<T>();
			root.data = rootData;
			root.player = player;
			root.value = value;
			root.children = new ArrayList<Node<T>>();
		}

		public class Node<T> {
			private T data;
			private char player;
			private int value;
			private ArrayList<Node<T>> children;
		}
	}

	private Tree<TicTacToe_Board> tree;

	/**
	 * Construtor MinMaxTree
	 * 
	 * @param initialBoard
	 *            - tabuleiro inicial
	 * @param player
	 *            - character do jogador
	 */
	public MinMaxTree(TicTacToe_Board initialBoard, char player) {
		tree = new Tree<TicTacToe_Board>(initialBoard, player, -1);
		MinMaxTreeChild(null, initialBoard, player == 'X' ? 'O' : 'X');
	}

	private void MinMaxTreeChild(Tree<TicTacToe_Board> newTree,
			TicTacToe_Board initialBoard, char player) {
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				if (initialBoard.isFree(j, k)
						&& initialBoard.getPlayState() != 'X'
						&& initialBoard.getPlayState() != 'O') {
					TicTacToe_Board parent = new TicTacToe_Board(initialBoard);
					parent.addMove(j, k, player);
					Tree<TicTacToe_Board> treeAux = new Tree<TicTacToe_Board>(
							parent, player, -1);
					if (newTree == null) {
						tree.root.children.add(treeAux.root);
					} else {
						newTree.root.children.add(treeAux.root);
					}
					MinMaxTreeChild(treeAux, treeAux.root.data,
							player == 'X' ? 'O' : 'X');
				}
			}
		}

	}

	/**
	 * Avalia a arvore utilizado o algoritmo MinMax
	 * 
	 * @param max
	 * @param player
	 */
	public void evaluateTree(boolean max, char player) {
		evaluateTreeChild(tree.root, !max, player);
	}

	private int evaluateTreeChild(
			Tree<TicTacToe_Board>.Node<TicTacToe_Board> root, boolean max,
			char player) {
		if (root.data.getPlayState() == player) {
			if (max) {
				root.value = 10;
				return 10;
			} else {
				root.value = -10;
				return -10;
			}
		}
		if (root.data.getPlayState() == 'E') {
			root.value = 0;
			return 0;
		}
		int sizeTreeChild = root.children.size();
		int[] scores = new int[sizeTreeChild];
		for (int i = 0; i < sizeTreeChild; i++) {
			scores[i] = evaluateTreeChild(root.children.get(i), !max, player);
		}
		if (!max) {
			int valueMax = Integer.MIN_VALUE;
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] > valueMax) {
					valueMax = scores[i];
				}
			}
			root.value = valueMax;
			return valueMax;
		} else {
			int valueMin = Integer.MAX_VALUE;
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] < valueMin) {
					valueMin = scores[i];
				}
			}
			root.value = valueMin;
			return valueMin;
		}
	}

	/**
	 * 
	 * @param findMax
	 * @return Um novo construtor com a arvore final baseada no algoritmo MinMax
	 */
	public MinMaxTree getMinMaxChild(boolean findMax) {
		int index = -1;
		int maxValue = Integer.MAX_VALUE;
		int minValue = Integer.MIN_VALUE;
		int treeChildSize = tree.root.children.size();
		for (int i = 0; i < treeChildSize; i++) {
			if (findMax) {
				if (tree.root.children.get(i).value > minValue) {
					minValue = tree.root.children.get(i).value;
					index = i;
				}
			} else {
				if (tree.root.children.get(i).value < maxValue) {
					maxValue = tree.root.children.get(i).value;
					index = i;
				}
			}
		}
		MinMaxTree result = new MinMaxTree(tree.root.children.get(index).data,
				tree.root.children.get(index).player);
		result.evaluateTree(!findMax, tree.root.children.get(index).player);
		return result;
	}

	public TicTacToe_Board getNode() {
		return tree.root.data;
	}
}
