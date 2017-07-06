package aula20170620.custoMedio.movimento;

import java.util.Date;

import aula20170620.custoMedio.produto.Produto;

public class Venda extends Movimento {

	public Venda(double quantidade, double valor, Produto produto, Date data) {
		super(quantidade, valor, produto, data);
	}

}
