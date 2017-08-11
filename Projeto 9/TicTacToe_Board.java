/**
 * @author João Silva, nº 48782
 */

import java.io.BufferedWriter;
import java.io.IOException;

public class TicTacToe_Board {
	private char[][] board;
	private char EMPTY = ' ';

	/** Tabuleiro vazio */
	public TicTacToe_Board() {
		board = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	/** Tabuleiro, copia de parent */
	public TicTacToe_Board(TicTacToe_Board parent) {
		board = new char[parent.board.length][parent.board.length];
		for (int i = 0; i < parent.board.length; i++) {
			for (int j = 0; j < parent.board[i].length; j++) {
				board[i][j] = parent.board[i][j];
			}
		}
	}

	/**
	 * Numero de posicoes vazias return numero de posicoes vazias
	 * */
	public int numEmpty() {
		int noEmpty = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == EMPTY) {
					noEmpty++;
				}
			}
		}
		return noEmpty;
	}

	/**
	 * Verifica se a célula na linha i e coluna j esta vazia return true se a
	 * célula estiver vazia, false se o contrario acontecer
	 * */
	public boolean isFree(int i, int j) {
		return board[i][j] == EMPTY;
	}

	/** Adiciona uma jogada de player na linha i, coluna j */
	public void addMove(int i, int j, char player) {
		board[i][j] = player;
	}

	/**
	 * Verifica se o jogo terminou return 'O' ou 'X' caso um ou outro ganhe; 'N'
	 * se ainda tiver casas em branco para jogar; 'E' caso ocorra Empate
	 * */
	public char getPlayState() {
		// Linhas
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2]
					&& board[i][0] != EMPTY) {
				return board[i][0];
			}
		}
		// Colunas
		for (int i = 0; i < board.length; i++) {
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i]
					&& board[0][i] != EMPTY) {
				return board[0][i];
			}
		}
		// Diagonais
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
				&& board[0][0] != EMPTY) {
			return board[0][0];
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]
				&& board[0][2] != EMPTY) {
			return board[0][2];
		}
		// Nao acabou
		if (numEmpty() > 0) {
			return 'N';
		}
		// Empate
		return 'E';
	}

	/**
	 * Escreve em out a representação do tabuleiro
	 * 
	 * @throws IOException
	 */
	public void writeBoard(BufferedWriter out) throws IOException {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == EMPTY) {
					if (j == board.length - 1) {
						out.write("  ");
					} else {
						if (j == board.length - 2) {
							out.write("   |");
						} else {
							out.write("  |");
						}
					}
				} else {
					if (j == board.length - 1) {

						out.write(" " + board[i][j] + "");
					} else {
						if (j == board.length - 2) {
							out.write(" " + board[i][j] + " |");
						} else {
							out.write("" + board[i][j] + " |");
						}
					}
				}

			}
			out.newLine();
			if (i != board.length - 1) {
				out.write("---------");
			}
			out.newLine();
		}

	}
}
