package aula20170620.custoMedio.produto;

import java.util.UUID;

public class Produto {

	private String nome;
	private String id;

	public Produto(String nome) {
		this.nome = nome;
		this.id = UUID.randomUUID().toString(); 
	}

	public String getId() {		
		//return "9154066a-c4ef-43da-851d-797be6a4c642";
		//return UUID.randomUUID().toString();
		return this.id;
	}

	public String getNome() {
		//return "Omo Progress Multi Ação Master Plus";
		return this.nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
