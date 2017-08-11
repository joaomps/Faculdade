package Projeto3;

public class Perm {
	public static boolean neighbour(char[][] matrix, char[][]finalPath, int m, int n, int mm, int nn){
		 boolean a = false,b = false,c=false;
		int _n = n - 1;
		if(_n >= 0 && _n != nn){//para não estourar o indice
			if(matrix[m][_n] == '*'){
				//para traz
				finalPath[m][_n] = '*';
				a=true;
				neighbour(matrix, finalPath, m, _n, -1, n);
			}
		}

		int _m = m + 1;
		if(_m < matrix.length && _m != mm){//para não estourar o indice
			if(matrix[_m][n]== '*'){
				//para baixo
				b=true;
				finalPath[_m][n] = '*';
				b=neighbour(matrix, finalPath, _m, n, m, -1);
			}
		}

		_n = n + 1;
		if(_n < matrix[m].length && _n != nn){//para não estourar o indice
			if(matrix[m][_n]== '*'){
				//para frente
				c=true;
				finalPath[m][_n] = '*';
				c=neighbour(matrix, finalPath, m, _n, -1, n);
			}
		}
		return a || b || c;
	}
}
