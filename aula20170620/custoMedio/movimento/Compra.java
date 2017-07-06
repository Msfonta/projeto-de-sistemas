package aula20170620.custoMedio.movimento;

import java.util.Date;

import aula20170620.custoMedio.produto.Produto;

public class Compra extends Movimento {

	public Compra(double quantidade, double valor, Produto produto, Date data) {
		super(quantidade, valor, produto, data);
	}

}
