package aula20170620.custoMedio.produto;

import java.util.List;

public interface ProdutoRepository {

	void save(Produto produto);

	List<Produto> findAll();

	Produto	findById(String id);

}
