package aula20170620.custoMedio.movimento;

import java.util.Date;
import java.util.UUID;

import aula20170620.custoMedio.produto.Produto;

public abstract class Movimento {
	private String id;
	private double quantidade;
	private double valor;
	private Produto produto;
	private Date data;
	
	public Movimento(double quantidade, double valor, Produto produto, Date data) {
		this.id = UUID.randomUUID().toString();
		this.quantidade = quantidade;
		this.valor = valor;
		this.produto = produto;
		this.data = data;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public double getValor() {
		return valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public Date getData() {
		return data;
	}
	public String getId() {
		return id;
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
		Movimento other = (Movimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
