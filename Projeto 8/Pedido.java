/**
 * 
 * @author João Silva, no.48782
 *
 */

public class Pedido {
	private String pedido;
	private int tempo;
	private int orderNo;
	
	/**
	 * construtor de um pedido
	 * @param prato - prato a ser confeccionado
	 * @param tempo - tempo que o prato demora a ser confeccionado
	 * @param ordem - ordem do prato
	 */
	public Pedido(String prato, int tempo, int ordem){
		this.pedido = prato;
		this.tempo = tempo;
		this.orderNo = ordem;
	}
	
	/**
	 * 
	 * @return tempo do pedido
	 */
	public int currentTimer(){
		return tempo;
	}
	
	/**
	 * 
	 * @return nome do prato
	 */
	public String prato(){
		return pedido;
	}
	
	/**
	 * 
	 * @return tempo que o prato demora a ser confeccionado
	 */
	public int tempo(){
		return tempo;
	}
	
	/**
	 * 
	 * @return ordem a que o prato estah
	 */
	public int ordem(){
		return orderNo;
	}
	
	/**
	 * Representacao textual do prato e a respectiva ordem
	 */
	public String toString(){
		StringBuilder strB = new StringBuilder();
		strB.append(orderNo + "-" + pedido);
		strB.append("\n");
		return strB.toString();
	}
}
