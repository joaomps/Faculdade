import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) throws IOException {

		// Abrir Ficheiro de Entrada
		Scanner sc = new Scanner(new FileReader(args[0]));
		int numJogadas = sc.nextInt();

		// Criar um tabuleiro
		TicTacToe_Board initialBoard = new TicTacToe_Board();

		// Ler e adicionar jogadas ao tabuleiro
		int linha, coluna;
		char player = 'X';
		for (int i = 0; i < numJogadas; i++) {
			linha = sc.nextInt();
			coluna = sc.nextInt();
			player = sc.next().charAt(0);
			initialBoard.addMove(linha, coluna, player);
		}

		sc.close();

		// Criar MinMaxTree (gera automaticamente os filhos)
		MinMaxTree mmt = new MinMaxTree(initialBoard, player);

		// Avaliar arvore em relacao ao jogador seguinte
		mmt.evaluateTree(true, player == 'X' ? 'O' : 'X');

		// Gerar jogadas (recursivamente) e escrever no ficheiro
		BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));

		boolean findMax = false;
		MinMaxTree newPlay = mmt;
		TicTacToe_Board board = newPlay.getNode();

		// enquanto jogo nao termina
		while (board.getPlayState() == 'N') {
			out.write("Jogada " + numJogadas++ + "\n");
			board.writeBoard(out);
			// alterna entre max e min
			findMax = !findMax;
			newPlay = newPlay.getMinMaxChild(findMax);
			board = newPlay.getNode();
		}

		// jogo terminou - tabuleiro final
		out.write("Jogada " + numJogadas++ + "\n");
		board.writeBoard(out);
		char estado = board.getPlayState();
		if (estado == 'E')
			out.write("Empate!\n");
		else
			out.write("Ganhou o " + estado + "\n");

		out.close();
	}

}
