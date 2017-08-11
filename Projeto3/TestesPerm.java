package Projeto3;

public class TestesPerm {
	public static void main(String[] args){
		
	}
	
	public boolean ehPermeavel(char[][] matrix, char[][]finalPath, int m, int n, int mm, int nn){
		boolean traz = false; boolean baixo = false; boolean frente = false;
		int _n = n-1;
		if(_n >= 0 && _n != nn){
			if(matrix[_n][m] == '*'){
				finalPath[_n][m] = '*';
				traz = true;
				ehPermeavel(matrix, finalPath, m, _n, -1, n);
			}
		}
		int _m = m+1;
		if(_m<matrix.length && _m != mm){
			if(matrix[_m][n] == '*'){
				baixo = true;
				finalPath[_m][n] = '*';
				baixo = ehPermeavel(matrix, finalPath, _m, n, m, -1);
			}
		}
		_n = n+1;
		if(_n<matrix[m].length && _n != nn){
			if(matrix[m][_n] == '*'){
				frente = true;
				finalPath[_m][n] = '*';
				frente = ehPermeavel(matrix, finalPath, m,_n,-1,n);
			}
		}
		return traz || baixo || frente;
	}
}