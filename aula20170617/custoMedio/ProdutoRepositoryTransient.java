package aula20170617.custoMedio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ProdutoRepositoryTransient implements ProdutoRepository {

	private List<Produto> produtos = new ArrayList<>();

	@Override
	public void save(Produto produto) {
		this.produtos.add(produto);
	}

	@Override
	public List<Produto> findAll() {
//		return Arrays.asList(
//				new Produto("Omo Progress Multi Ação Master Plus"), 
//				new Produto("Soja"),
//				new Produto("Trigo"));
		//return produtos;
		
//		ArrayList<Produto> aux = new ArrayList<Produto>();
//		aux.addAll(this.produtos);
//		return aux;
		return Collections.unmodifiableList(this.produtos);
		//return this.produtos;
	}

	@Override
	public Produto findById(String id) {
		//return produtos.stream().filter(produto -> produto.getId().equals(id)).findFirst().get();
		for (Produto produto : produtos) {
			if (produto.getId().equals(id)) {
				return produto;
			}
		}
		return null;
	}

}
