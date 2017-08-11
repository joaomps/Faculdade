import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue representa uma fila, i.e., uma colecao linear de elementos que suporta 
 * a remocao de elementos na frente da fila e a insercao de elementos no fim da 
 * fila, usando uma lista simplesmente ligada.
 * 
 * @author Profs. LabP. , João Silva, no.48782
 *
 * @param <E> Tipo de elementos.
 */
public class Queue<E> implements Iterable<E> {



	//Nested class para os nos das filas

	private static class Node<E>{

		//Atributos

		private E element; //o elemento
		private Node<E> next; //o proximo noh

		/**
		 * um noh com um dado elemento e a indicacao do proximo noh.
		 * 
		 * @param element o elemento
		 * @param node o proximo noh
		 */
		public Node(E element, Node<E> node){
			this.element = element; 
			this.next= node;
		}

		public String toString(){
			return element.toString();
		}

	}
	//End of nested class

	//Atributos

	private Node<E> head; //Elemento na frente da fila
	private Node<E> rear; //Elemento no fim da fila
	private int size; //Numero de elementos na fila

	//construtores

	/**
	 * fila vazia;
	 */
	public Queue() {
		size = 0;
	}

	/**
	 * fila com um elemento
	 * @param element - elemento a adicionar
	 */
	public Queue(E element){
		head = new Node<E>(element,null);
		rear = head;
		size++;
	}

	/**
	 * @return comprimento da fila
	 */
	public int size(){
		return size;
	}

	/**
	 * @return true sse a fila esta vazia;  
	 */
	public boolean isEmpty(){
		return head == null;
	}

	/**
	 * frente da fila
	 * 
	 * @return o primeiro elemento da fila
	 * @requires !isEmpty();  
	 */
	public E front(){
		return head.element;
	}

	/**
	 * adicionar um elemento ah nossa lista
	 * @param element - elemento a adicionar
	 */
	public void enqueue(E element) {
		Node<E> n = new Node<E>(element, null);
		if(isEmpty()){
			n.next = rear;
			head = n;
			rear = n;
		}
		else
		{
			rear.next = n;
			rear = n;
			rear.next = null;
		}
		size++;
	}

	/**
	 * Remover um elemento da Lista usando o termo FIFO (First In First OUT)
	 */
	public void dequeue() {
		head = head.next;
		size--;
	}

	/**
	 * Representacao da lista
	 */
	public String toString(){
		StringBuilder strB = new StringBuilder();
		Node<E> current = head;
		while(current != null) {
			strB.append(current.element + " ");
			current = current.next;
		}
		return strB.toString();
	}   
	
	/** 
	 * construtor
	 */
	public Iterator<E> iterator(){
		return new ListIterator<E>(head);
	}
	
	private class ListIterator<E> implements Iterator<E> {
		private Node<E> current;
		/**
		 * construtor do iterador
		 * @param head
		 */
		public ListIterator(Node<E> head) {
			current = head;
		}
		
		/**
		 * verifica se a nossa lista tem mais elementos
		 */
		public boolean hasNext() {
			return current != null;
		}
		
		/**
		 *  @return o elemento a seguir
		 */
		public E next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			E element = current.element;
			current = current.next;
			return element;
		}

		/**
		 * Nao suportado
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}