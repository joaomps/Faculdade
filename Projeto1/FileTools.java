package Projeto1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileTools {
	private static String currentLine;

	public static void removeLetters(BufferedReader orders, BufferedReader in,
			BufferedWriter out) throws IOException {
		String ordens = orders.readLine();
		char[] vecOrder = ordens.toCharArray();
		while((currentLine = in.readLine()) != null){
			out.write(removeChr(currentLine, vecOrder));
			out.newLine();
		}
	}

	public static void capitalize(BufferedReader orders, BufferedReader in,
			BufferedWriter out) throws IOException {
		String orderNmb = orders.readLine();
		int orderNo = Integer.parseInt(orderNmb);
		while((currentLine = in.readLine()) != null){
			out.write(capitalizeString(currentLine, orderNo));
			out.newLine();
		}
	}

	public static void occurrences(BufferedReader in, BufferedWriter out) throws IOException {
		while((currentLine = in.readLine()) != null){
			StringTokenizer strToken = new StringTokenizer(currentLine, " .,");
			String[] strArray = new String[strToken.countTokens()];
			String element = "";
			int count = 0;
			for(int i = 0; i<strArray.length; i++){
				while(strToken.hasMoreElements()){
					element = (String) strToken.nextElement();
					strArray[i] = element;
				}
			}
			for(int i = 0; i<strArray.length; i++){
				System.out.println(strArray[i]);
			}
			for(int i = 0; i<strArray.length; i++){
				while(strToken.hasMoreElements()){
					element = (String) strToken.nextElement();
					if(strArray[i] == element){
						count++;
					}
				}
				out.write(strArray[i]+ ":" + count);
			}
		}
	}
	private static String removeChr(String str, char[] vecOrder){
		StringBuilder strBuilder = new StringBuilder();
		for(int j = 0; j<str.length(); j++){
			boolean isEqual2Char = false;
			for(int i = 0; i<vecOrder.length; i++){
				if((str.charAt(j)) == vecOrder[i]){
					isEqual2Char = true;
				}
			}
			if(!isEqual2Char){
				strBuilder.append(str.charAt(j));
			}
		}
		return strBuilder.toString();
	}

	private static String capitalizeString(String str, int orderNo){
		String stringFinal = "";
		switch (orderNo) {
		case 0:
			stringFinal = str.toUpperCase();
			break;
		case 1:
			stringFinal = str.toLowerCase();
			break;
		case 2:
			if (str != null && str.length() > 0){
				stringFinal = str.toLowerCase();
				StringBuilder strB = new StringBuilder();
				StringTokenizer strToken = new StringTokenizer(stringFinal, "%");
				String element = "";
				boolean nextWord2Upper = true;
				while(strToken.hasMoreElements()){
					element = (String) strToken.nextElement();
					if(nextWord2Upper){
						for(int i =0; i < element.length(); i++)
						{
							if(i == 0)
							{
								strB.append((element.charAt(i) + "").toUpperCase());
							}
							else
							{
								strB.append((element.charAt(i)));
							}
						}
						nextWord2Upper=false;
					}
					else
					{
						strB.append(element);
					}
					if(element.charAt(element.length()-1) == '.'){
						nextWord2Upper = true;
					}
					strB.append(" ");
				}

				stringFinal = strB.toString();
				break;
			}
			return stringFinal;
		}
		return stringFinal;
	}
}