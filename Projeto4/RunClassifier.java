package Projeto4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RunClassifier {
	private static double[][] dimensions;
	private static double[][] dimensionsError;
	private static int[] fishTypes;
	private static int[] fishTypesError;
	private static BufferedReader buffR;
	private static Scanner scan;
	private static double[][] toBeTested;


	public static void main(String[] args) throws IOException {
		//Reference
		buffR = new BufferedReader(new FileReader(args[0]));
		String aux = buffR.readLine();
		scan = new Scanner(aux);
		int lines = scan.nextInt();
		int column = scan.nextInt();
		dimensions = new double[lines][column-1];
		fishTypes = new int[lines];
		int linhas = 0;
		while((aux = buffR.readLine()) != null){
			String[] auxiliar = aux.split(" +");
			for(int i = 1; i<auxiliar.length-1; i++){//comecar em 1 por causa do espaço
				dimensions[linhas][i-1] = Double.parseDouble(auxiliar[i]);
			}
			fishTypes[linhas] = Integer.parseInt(auxiliar[auxiliar.length-1]);
			linhas++;
		}
		scan.close();
		buffR.close();
		Classifier classifier = new Classifier(dimensions, fishTypes);
		//Test
		buffR = new BufferedReader(new FileReader(args[2]));
		String aux2 = buffR.readLine();
		scan = new Scanner(aux2);
		int linesTest = scan.nextInt();
		int columnTest = scan.nextInt();
		toBeTested = new double[linesTest][columnTest];
		int linhasTeste = 0;
		while((aux2 = buffR.readLine()) != null){
			String[] auxiliar = aux2.split(" +");
			for(int i = 1; i<auxiliar.length; i++){//comecar em 1 por causa do espaço
				toBeTested[linhasTeste][i-1] = Double.parseDouble(auxiliar[i]);
			}
			linhasTeste++;
		}
		scan.close();
		buffR.close();
		int[] fishTypesTest = classifier.classifyDataset(toBeTested);
		//errorPercentage
		buffR = new BufferedReader(new FileReader(args[1]));
		String aux3 = buffR.readLine();
		scan = new Scanner(aux3);
		int linesError = scan.nextInt();
		int columnError = scan.nextInt();
		dimensionsError = new double[linesError][columnError-1];
		fishTypesError = new int[linesError];
		int linhasError = 0;
		while((aux3 = buffR.readLine()) != null){
			String[] auxiliar = aux3.split(" +");
			for(int i = 1; i<auxiliar.length-1; i++){//comecar em 1 por causa do espaço
				dimensionsError[linhasError][i-1] = Double.parseDouble(auxiliar[i]);
			}
			fishTypesError[linhasError] = Integer.parseInt(auxiliar[auxiliar.length-1]);
			linhasError++;
		}
		scan.close();
		buffR.close();
		double errorPercentage = classifier.errorPercentage(dimensionsError, fishTypesError);
		//PrintFinal
		System.out.println(errorPercentage);
		for(int i = 0; i<10; i++){
			for(int j = 0; j<2; j++){
				System.out.print(toBeTested[i][j] + " ");
			} 
			System.out.println(fishTypesTest[i]);
		}
	}
}
