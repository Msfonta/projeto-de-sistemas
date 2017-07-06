package aula20170617.custoMedio;

import java.util.List;

public interface ProdutoRepository {

	void save(Produto produto);

	List<Produto> findAll();

	Produto	findById(String id);

}
