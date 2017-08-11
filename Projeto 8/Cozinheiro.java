/**
 * 
 * @author João Silva, no.48782
 *
 */

public class Cozinheiro {
	private Queue<Pedido> lista;
	private int timer;

	/**
	 * construtor do cozinheiro
	 */
	public Cozinheiro(){
		lista = new Queue<Pedido>();
	}
	
	/**
	 * adicionar um pedido a nossa lista
	 * @param pedido - pedido a adicionar ah lista
	 */
	public void addToLista(Pedido pedido){
		lista.enqueue(pedido);
		timer += pedido.currentTimer();
	}
	
	/**
	 * numero total de pedidos
	 * @return numero total de pedidos
	 */
	public int nmrRequests(){
		return lista.size();
	}
	
	/**
	 * total de tempo que um cozinheiro estah ocupado
	 * @return tempo total
	 */
	public int currentTimer() {
		return timer;
	}
	
	/**
	 * Remove um pedido de uma lista e consequentemente libera algum tempo do cozinheiro
	 */
	public void removeFromList(){
		Pedido p = lista.front();
		timer -= p.currentTimer();
		lista.dequeue();
	}
	
	/**
	 * devolve a lista do cozinheiro
	 * @return lista do cozinheiro
	 */
	public Queue<Pedido> list(){
		return lista;
	}
	
	/**
	 * representacao textual
	 */
	public String toString(){
		StringBuilder strB = new StringBuilder();
		int j = nmrRequests();
		for(int i = 0; i<j; i++){
			Pedido p = lista.front();
			strB.append(p.toString());
			lista.dequeue();
			lista.enqueue(p);
		}
		return strB.toString();
	}
}
