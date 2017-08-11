package Projeto3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RunPerm {

	private static char[][] finalPath;
	private static boolean res;

	public static void main(String[] args) throws IOException {
		BufferedReader in;
		in = new BufferedReader(new FileReader(args[0]));
		int arrayDimension = Integer.parseInt(in.readLine());
		in.close();
		in = new BufferedReader(new FileReader(args[0]));
		String aux;
		in.readLine();
		int auxArray = 0;
		char[][] arArray = new char[arrayDimension][arrayDimension];
		while ((aux = in.readLine()) != null) {
			String[] columns = aux.split(" ");
			for (int i = 0; i < columns.length; i++) {
				if (columns[i].equals("true")) {
					arArray[auxArray][i] = '*';
				} else {
					arArray[auxArray][i] = '-';
				}
			}
			auxArray++;
		}
		in.close();
		finalPath = new char[arrayDimension][arrayDimension];
		for (int i = 0; i < finalPath.length; i++) {
			for (int j = 0; j < finalPath.length; j++) {
				finalPath[i][j] = '-';
			}
		}
		
		int _m = 0;
		for (int _n = 0; _n < arArray[_m].length; _n++) {
			int _value = arArray[_m][_n];
			if (_value == '*') {
				finalPath[_m][_n] = '*';
				res = Perm.neighbour(arArray, finalPath, _m, _n, -1, -1);
				if (res == false) {
					finalPath = new char[arrayDimension][arrayDimension];
					for (int i = 0; i < finalPath.length; i++) {
						for (int j = 0; j < finalPath.length; j++) {
							finalPath[i][j] = '-';
						}
					}
				} else {
					System.out.println("eh permeavel");
					for (int i = 0; i < finalPath.length; i++) {
						for (int j = 0; j < finalPath.length; j++) {
							System.out.print(finalPath[i][j]);
						}
						System.out.println();
					}
				}
			}
		}
		if (res == false) {
			System.out.println("nao eh permeavel");
		}
	}
}