package aula20170620.custoMedio.movimento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import aula20170620.custoMedio.NotFoundException;
import aula20170620.custoMedio.produto.Produto;

public class MovimentoRepositoryTransient implements MovimentoRepository {
	private List<Movimento> movimentos = new ArrayList<Movimento>();

	@Override
	public void save(Movimento movimento) {
		this.movimentos.add(movimento);
	}

	@Override
	public List<Movimento> findAll() {
		return Collections.unmodifiableList(this.movimentos);
	}

	@Override
	public Movimento findById(String id) {
		for (Movimento movimento : movimentos) {
			if (movimento.getId().equals(id)) {
				return movimento;
			}
		}
		throw new NotFoundException(Movimento.class, id);
	}

	@Override
	public List<Movimento> findByProduto(Produto produto) {
//		List<Movimento> movimentosDoProduto = new ArrayList<Movimento>();
//		for (Movimento aux : movimentos) {
//			if (aux.getProduto().equals(produto)) {
//				movimentosDoProduto.add(aux);
//			}
//		}
//		return movimentosDoProduto;
		return this.movimentos.stream().filter(aux -> aux.getProduto().equals(produto)).collect(Collectors.toList());
	}

}
