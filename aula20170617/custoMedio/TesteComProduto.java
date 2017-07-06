package aula20170617.custoMedio;

import static org.junit.Assert.*;

import java.util.UUID;

import javax.naming.OperationNotSupportedException;

import org.junit.Test;

public class TesteComProduto {

	@Test
	public void testarCriarProduto() {
		Produto omo = new Produto("Omo Progress Multi Ação Master Plus");
		Produto soja = new Produto("Soja");
		
		try {
			UUID.fromString(omo.getId());
			UUID.fromString(soja.getId());
		} catch (IllegalArgumentException e) {
			fail("O id do produto deveria ser um UUID válido!");
		}
		
		assertEquals("O nome do produto está incorreto!", "Omo Progress Multi Ação Master Plus", omo.getNome());
		assertEquals("O nome do produto está incorreto!", "Soja", soja.getNome());
		assertNotEquals("Os IDs de produtos distintos devem ser distintos!", omo.getId(), soja.getId());
		assertEquals("O ID de uma entidade deve permanecer o mesmo!", omo.getId(), omo.getId());
		assertEquals("O ID de uma entidade deve permanecer o mesmo!", soja.getId(), soja.getId());
	}
	@Test
	public void testarNovoProdutoNoRepositório() {
		Produto omo = new Produto("Omo Progress Multi Ação Master Plus");
		Produto soja = new Produto("Soja");
		Produto trigo = new Produto("Trigo");
		
		ProdutoRepository repo = new ProdutoRepositoryTransient();
		repo.save(omo);
		repo.save(soja);
		
		
		assertTrue("Deveria conter o omo!", repo.findAll().contains(omo));
		assertTrue("Deveria conter a soja!", repo.findAll().contains(soja));

		repo.save(trigo);
		assertTrue("Deveria conter o trigo!", repo.findAll().contains(trigo));
		try {
			repo.findAll().remove(trigo);
			fail("Deveria ter gerado uma exception de modificação não permitida!");
		} catch (Exception e) {
			assertNotNull(e);
		}
		
		assertEquals("Ao procurar pelo id, deveria retornar o objeto correto!", omo, repo.findById(omo.getId()));
		assertNull("Ao procurar por id inexistente, deveria retornar null!", repo.findById("ed336e0e-bfd5-4434-8e6c-c3453aab8dbe"));
	}

}
