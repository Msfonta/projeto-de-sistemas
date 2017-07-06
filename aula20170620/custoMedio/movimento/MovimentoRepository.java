package aula20170620.custoMedio.movimento;

import java.util.List;

import aula20170620.custoMedio.produto.Produto;

public interface MovimentoRepository {

	void save(Movimento movimento);

	List<Movimento> findAll();
	
	List<Movimento> findByProduto(Produto produto);

	Movimento findById(String id);
	
}
