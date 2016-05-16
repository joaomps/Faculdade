package Projeto8;

import java.util.ArrayList;

public class GestorLugares {
	private int escaloes;
	private int nLugares;
	private int estrategiaAtribuicao;
	private int total;
	private int[] escalaoN;
	private BidirectionalHashMap<Integer, String> map;
	private Lugar[] lugares;
	private ArrayList<Funcionario> funcionarios;

	public GestorLugares(int escaloes, int nLugares, int estrategiaAtribuicao) {
		this.escaloes = escaloes;
		this.nLugares = nLugares;
		this.estrategiaAtribuicao = estrategiaAtribuicao;
		escalaoN = new int[escaloes];
		map = new BidirectionalHashMap<>();
		lugares = new Lugar[nLugares];
		funcionarios = new ArrayList<Funcionario>();
	}

	public int totalAtribuidos() {
		return total;
	}

	public int atribuidosNoEscalao(int escalao) {
		return escalaoN[escalao];
	}

	public boolean registarFuncionario(String nome, int escalao) {
		for(int i = 0; i<funcionarios.size(); i++){
			if(funcionarios.get(i).obterNome().equals(nome)){
				return false;
			}
		}
		funcionarios.add(new Funcionario(nome, escalao));
		return true;
	}

	public boolean atribuirLugar(String nome) {
		int noSpacesFilas = nLugares/escaloes;
		if(estrategiaAtribuicao == 1){

		}
		else
		{

		}
		return false;
	}

	public Funcionario obterDono(int numeroLugar) {
		return Funcionario.obterNome(map.getValue(numeroLugar));
	}

	public int obterNumeroLugar(String nome) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Lugar removerAtribuicaoPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public Lugar removerAtribuicaoPorNumeroLugar(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
