package Projeto2;

public class Partido {
	String name;
	int votesNo;
	int stepNo;
	int deputadosNo;

	public Partido(String nomePartido, int votos){
		name = nomePartido;
		votesNo = votos;
		deputadosNo = 0;
		stepNo = 1;
	}
}
