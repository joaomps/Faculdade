package Projeto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Hondt {
	private static String currentLine;
	private static int maxPartidos;
	private int noMandatos;
	private Partido[] arrayP;

	public Hondt(){
		maxPartidos = 20;
	}

	public void leVotacao(BufferedReader in) throws IOException {
		noMandatos = Integer.parseInt(in.readLine());
		int j = 0;
		Partido[] arrayAux = new Partido[maxPartidos];
		while((currentLine = in.readLine()) != null){
			String[] newString = currentLine.split("-");
			arrayAux[j] = new Partido(newString[0], Integer.parseInt(newString[1]));
			j++;
		}	
		arrayP = new Partido[j];
		for(int i=0; i<j; i++){
			arrayP[i] = arrayAux[i];
		}
	}

	public void calculaMandatos() {
		do{
			int maxVote = 0;
			int partidoComMaxVotos = 0; //o index do array dos partidos ( ou seja os partidos em si (o A, B, C, D))
			int partidoComMinVotos = 0;
			maxVote = calcularMaxVoteComStepNo(partidoComMaxVotos);
			if(noMandatos == 1){
				for(int i = 0; i<arrayP.length;i++){
					if(arrayP[i].votesNo == maxVote){
						partidoComMinVotos = i;
					}
				}
				arrayP[partidoComMinVotos].stepNo++;
				arrayP[partidoComMinVotos].deputadosNo++;
			}
			else
			{
				for(int i = 0; i<arrayP.length;i++){
					if(calcularMaxVoteComStepNo(i) > maxVote){
						maxVote = calcularMaxVoteComStepNo(i);
						partidoComMaxVotos = i;
					}
				}
				arrayP[partidoComMaxVotos].stepNo++;
				arrayP[partidoComMaxVotos].deputadosNo++;
			}
			noMandatos--;
		}while(noMandatos>0);
	}

	public void escreveResultado(BufferedWriter out) throws IOException {
		for(int i = 0; i<arrayP.length;i++){
			out.write(arrayP[i].name +"-" +arrayP[i].deputadosNo);
			out.newLine();
		}
	}

	private int calcularMaxVoteComStepNo(int currentMax) {
		return arrayP[currentMax].votesNo / arrayP[currentMax].stepNo;
	}
}