package Projeto4;

public class Classifier {
	
	private double[][] classifier;
	private int[] fishTypes;
	
	public Classifier(double [][] classifierAr, int[] fishTypes){
		this.classifier = classifierAr;
		this.fishTypes = fishTypes;
	}
	
	public int getClass(double[] pattern){
		double min = pattern[0];
		double max = pattern[1];
		double x;
		double y;
		double resultado = Double.MAX_VALUE;
		int vizinhoProximo = -1;
		double calculo;
		for(int i = 0; i<classifier.length; i++){
			x = classifier[i][0];
			y = classifier[i][1];
			calculo = Math.sqrt(((x-min)*(x-min))+((y-max)*(y-max)));
			if(calculo<resultado){
				resultado = calculo;
				vizinhoProximo = i;
			}
		}
		return fishTypes[vizinhoProximo];
	}
	public int[] classifyDataset(double[][] array){
		int[] returned = new int[array.length];
		double[] pattern = new double[2];
		for(int i = 0; i<array.length; i++){
			pattern[0] = array[i][0];
			pattern[1] = array[i][1];
			returned[i] = getClass(pattern);
		}
			return returned;
	}
	
	public double errorPercentage(double[][] dimensionsError, int[] fishTypesError){
		int numbOfErrors = 0;
		int[] classification = classifyDataset(dimensionsError);
		for(int i = 0; i<classification.length; i++){
			if(classification[i] != fishTypesError[i]){
				numbOfErrors++;
			}
		}
		if(numbOfErrors == 0){
			return 0;
		}
		return  numbOfErrors * 100 / dimensionsError.length;
	}
}
