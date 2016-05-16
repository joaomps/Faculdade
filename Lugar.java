package Projeto8;

public class Lugar {
	
	private int numeroLugar;
	private int escalao;
	
	public Lugar(int numero, int escalao){
		this.numeroLugar = numero;
		this.escalao = escalao;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + escalao;
		result = prime * result + numeroLugar;
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
		Lugar other = (Lugar) obj;
		if (escalao != other.escalao) {
			return false;
		}
		if (numeroLugar != other.numeroLugar) {
			return false;
		}
		return true;
	}

	public int obterNumero() {
		return numeroLugar;
	}

	public int obterEscalao() {
		return escalao;
	}
	
}
