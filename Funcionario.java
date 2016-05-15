package Projeto8;

public class Funcionario {
	private static  String nome;
	private int escalao;
	
	public Funcionario(String nome, int escalao){
		this.nome = nome;
		this.escalao = escalao;
	}
	
	public static String obterNome() {
		return nome;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + escalao;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Funcionario other = (Funcionario) obj;
		if (escalao != other.escalao) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

}
