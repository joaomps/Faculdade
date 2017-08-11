/**
 * 
 * @author João Silva, no.48782
 *
 */

import java.io.BufferedReader;
import java.io.IOException;

public class DistServico {

    //Tempo minimo de confecao de qualquer prato
    private static final int DEFAULT_TIME = 10;
    private int nCozServico;
    private Cozinheiro[] listaCozinheiro;
    private int ordem;
    private Pedido pedidos;
    
    /**
     * Distribuicao de servico vazia
     *
     *@param nCozServico numero de cozinheiros na distribuicao de servico
     *@requires nCozServico > 0
     */
    public DistServico(int nCozServico) {
        this.nCozServico = nCozServico;
        listaCozinheiro = new Cozinheiro[nCozServico];
        ordem = 0;
        for(int i = 0; i<nCozServico; i++){
            listaCozinheiro[i] = new Cozinheiro();
        }
    }


    /**
     * Le o ficheiro enviado pelo BufferedReader in e distribui os pedidos pelos varios cozinheiros
     * @param in - buffer de leitura
     * @throws IOException - no caso de nao haver um ficheiro
     */
    public void leDistribui(BufferedReader in) throws IOException{
    	String aux;
    	String pedido;
    	int tempo;
    	while((aux = in.readLine())!=null){
    		ordem++;
    		String[] auxiliar = aux.split(" ");
    		pedido = auxiliar[0];
    		tempo = Integer.parseInt(auxiliar[1]);
    		pedidos = new Pedido(pedido, tempo, ordem);
    		listaCozinheiro[cozinheiroMenosTempo()].addToLista(pedidos);
    	}
    }


    /**
     * Devolve o numero de pedidos ativos
     * @return numero de pedidos ativos
     */
    public int total(){
    	int nmbrRequests = 0;
    	for(int i = 0; i<listaCozinheiro.length; i++){
    		nmbrRequests += listaCozinheiro[i].nmrRequests();
    	}
    	return nmbrRequests;
    }
    
    /**
     * Cria uma nova lista e coloca lah o numero dos cozinheiros cujo o tempo para atender o proximo pedido eh superior a i
     * @param i - tempo a ser comparado
     * @return Nova lista com o numero dos cozinheiros
     */
    public Queue<String> tempoSuperior(int i){
    	Queue<String> p = new Queue<String>();
    	for(int j = 0; j < listaCozinheiro.length; j++){
    		if(listaCozinheiro[j].currentTimer()>i){
    			p.enqueue("" + (j+1));
    		}
    	}
    	return p;
    }

    /**
     * Tempo minimo de espera que um novo pedido levarah a ser atendido
     * @return o tempo minimo de espera
     */
    public int tempoMinimoEspera(){
    	return listaCozinheiro[cozinheiroMenosTempo()].currentTimer() + DEFAULT_TIME;
    }
    
    /**
     * Acrescenta um pedido ah nossa lista de pedidos para que este seja confeccionado
     * @param descricao - nome do prato
     * @param tempo - tempo que o prato demora a confeccionar
     */
    public void request(String descricao, int tempo){
    	ordem++;
    	pedidos = new Pedido(descricao, tempo, ordem);
    	listaCozinheiro[cozinheiroMenosTempo()].addToLista(pedidos);
    }
    
    /**
     * Remove o primeiro pedido de um dos cozinheiros
     * @param nCozinheiro Numero do cozinheiro em que o pedido vai ser removido
     */
    public void served(int nCozinheiro){
    	listaCozinheiro[nCozinheiro-1].removeFromList();
    }

    /**
     * Coleciona todos os pedidos e cria uma nova distribuicao com nCozinheiros em que os pedidos irao ser redestribuidos
     * @param nCozinheiros - Numero de cozinheiros a que vao ser redistribuidos os pedidos
     */
    public void reDistServico(int nCozinheiros){
    	Queue<Pedido> listaPedido = new Queue<Pedido>();
    	Queue<Pedido> listaAuxiliar = new Queue<Pedido>();
    	for(int i = 0; i<listaCozinheiro.length; i++){
    		listaAuxiliar = listaCozinheiro[i].list();
    		int sizeAux = listaAuxiliar.size();
    		for(int j = 0; j<sizeAux; j++){
    			listaPedido.enqueue(listaAuxiliar.front());
    			listaAuxiliar.dequeue();
    		}
    	}
    	listaCozinheiro = new Cozinheiro[nCozinheiros];
        for(int i = 0; i<nCozinheiros; i++){
            listaCozinheiro[i] = new Cozinheiro();
        }
        int listaAux = listaPedido.size();
        ordem = 0;
        Queue<Pedido> listaPedidosAuxiliar = orderQueue(listaPedido);
        for(int i = 0; i<listaAux; i++){
        	Pedido aux = listaPedidosAuxiliar.front();
        	ordem++;
        	Pedido p = new Pedido(aux.prato(), aux.tempo(), ordem);
        	listaCozinheiro[cozinheiroMenosTempo()].addToLista(p);
        	listaPedidosAuxiliar.dequeue();
        	
        }
    }

    /**
     * Representacao textual dos pedidos ativos
     */
    public String toString(){
		StringBuilder strB = new StringBuilder();
		for(int i = 0; i<listaCozinheiro.length; i++){
			strB.append("Cozinheiro " + (i+1));
			strB.append("\n");
			strB.append(listaCozinheiro[i].toString());
			strB.append("\n");
		}
    	return strB.toString();
    }
    
    /**
     * Calculo para saber qual o cozinheiro que tem menos tempo total de pedidos
     * @return o numero do cozinheiro com menos tempo ocupado
     */
    private int cozinheiroMenosTempo(){
    	int tempoDeCozinheiro = listaCozinheiro[0].currentTimer();
    	int indexCooker = 0;
    	for(int i = 1; i<listaCozinheiro.length; i++){
    		if(tempoDeCozinheiro>listaCozinheiro[i].currentTimer()){
    			indexCooker = i;
    			tempoDeCozinheiro = listaCozinheiro[i].currentTimer();
    		}
    	}
    	return indexCooker;
    }
    
    /**
     * Recebe uma lista e ordena-a
     * @param p - lista a ser ordenada
     * @return lista ordenada
     */
    private Queue<Pedido> orderQueue(Queue<Pedido> p){
    	Queue<Pedido> lista = new Queue<Pedido>();
    	int orderMax = Integer.MAX_VALUE;
    	int pInserted = -1;
    	int pSize = 0;
    	Pedido pAdd = null;
    	while(pSize< p.size()){
    		orderMax = Integer.MAX_VALUE;
    		for(Pedido pedido : p){
    			if(pedido.ordem()<orderMax && pedido.ordem()>pInserted){
    				orderMax = pedido.ordem();
    				pAdd = pedido;
    			}
    		}
    		pSize++;
    		pInserted = pAdd.ordem();
    		lista.enqueue(new Pedido(pAdd.prato(), pAdd.tempo(), pAdd.ordem()));
    	}
    	return lista;
    }
}
