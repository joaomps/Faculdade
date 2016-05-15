package Projeto8;

import java.util.HashMap;
import java.util.Map;

/**
 * Tabela bidireccional.
 */

public class BidirectionalHashMap<K, V> {
	
	private Map<K, V> map;
	private Map<V, K> reverse;
	
	/**
	 * construtor
	 */
	public BidirectionalHashMap() {
		map = new HashMap<K, V>();
		reverse = new HashMap<V, K>();
	}

	// Delegacao.
	// -----------------------------------------------------------------------

	/**
	 * Dado um valor, obter a chave correspondente
	 * @param value - o valor
	 * @return K - a chave
	 */
	public K getKey(V value) {
		return reverse.get(value);
	}

	/**
	 * Dada uma chave, obter o valor correspondente
	 * @param key - a chave
	 * @return V - o valor
	 */
	public V getValue(K key) {
		return map.get(key);
	}

	/**
	 * Adicionar um par chave-valor
	 * @param key - a chave
	 * @param value - o valor
	 */
	public void put(K key, V value) {
		map.put(key, value);
		reverse.put(value, key);
	}

	/**
	 * Verificar se a tabela contem uma chave
	 * @param key -a chave
	 * @return true se contem a chave, false se nao contem.
	 */
	public boolean containsKey(K key) {
		return map.containsKey(key);
	}

	/**
	 * verificar se a tabela contem um certo valor
	 * @param value - o valor
	 * @return true se contem o valor, false caso contrario.
	 */
	public boolean containsValue(V value) {
		return reverse.containsValue(value);
	}

	/**
	 * Remover um par chave-valor, dada a chave.
	 * @param key - a chave.
	 * @return V - o valor previamente associado a chave.
	 */
	public V removeByKey(K key) {
		V removedValue = map.remove(key);
		map.remove(removedValue);
		return removedValue;
	}

	/**
	 * Remover um par chave-valor, dado o valor.
	 * @param value - o valor
	 * @return K - a chave associada ao valor antes da remocao do par.
	 */
	public K removeByValue(V value) {
		K removedKey = reverse.remove(value);
		map.remove(removedKey);
		return removedKey;
	}

	/**
	 * Retornar o tamanho da tabela (numero de pares chave-valor contidos).
	 * @return o tamanho da tabela.
	 */
	public int size() {
		return map.size();
	}

}
