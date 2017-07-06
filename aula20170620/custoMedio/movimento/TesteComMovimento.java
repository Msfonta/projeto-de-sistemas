package aula20170620.custoMedio.movimento;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.naming.OperationNotSupportedException;

import org.junit.Test;

import aula20170620.custoMedio.NotFoundException;
import aula20170620.custoMedio.produto.Produto;

public class TesteComMovimento {

	@Test
	public void testarCriarMovimentoDeVenda() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataVenda = sdf.parse("16/03/2017");
		
		Produto omo = new Produto("Omo Progress");
		Movimento venda100omo = new Venda(100.00, 11.75, omo, dataVenda);
		Movimento venda15omo = new Venda(15.00, 11.75, omo, dataVenda);
		
		try {
			UUID.fromString(venda100omo.getId());
			UUID.fromString(venda15omo.getId());
		} catch (IllegalArgumentException e) {
			fail("O id da compra deveria ser um UUID válido!");
		}
		
		assertEquals("A quantidade deveria ser igual!", 100.00, venda100omo.getQuantidade(), 0.00);
		assertEquals("O preço deveria ser igual!", 11.75, venda100omo.getValor(), 0.00);
		assertEquals("O produto deveria ser igual!", omo, venda100omo.getProduto());
		assertEquals("A data deveria ser igual!", dataVenda, venda100omo.getData());
		
		assertEquals("A quantidade deveria ser igual!", 15.00, venda15omo.getQuantidade(), 0.00);
		assertEquals("O preço deveria ser igual!", 11.75, venda15omo.getValor(), 0.00);
		assertEquals("O produto deveria ser igual!", omo, venda15omo.getProduto());
		assertEquals("A data deveria ser igual!", dataVenda, venda15omo.getData());
		
	}

	@Test
	public void testarCriarMovimentoDeCompra() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataCompra = sdf.parse("15/02/2017");
		
		Produto omo = new Produto("Omo Progress");
		Movimento compra100omo = new Compra(100.00, 12.00, omo, dataCompra);
		Movimento compra200omo = new Compra(200.00, 11.50, omo, dataCompra);
		
		try {
			UUID.fromString(compra100omo.getId());
			UUID.fromString(compra200omo.getId());
		} catch (IllegalArgumentException e) {
			fail("O id da compra deveria ser um UUID válido!");
		}
		
		assertEquals("A quantidade deveria ser igual!", 100.00, compra100omo.getQuantidade(), 0.00);
		assertEquals("O preço deveria ser igual!", 12.00, compra100omo.getValor(), 0.00);
		assertEquals("O produto deveria ser igual!", omo, compra100omo.getProduto());
		assertEquals("A data deveria ser igual!", dataCompra, compra100omo.getData());
		
		assertEquals("A quantidade deveria ser igual!", 200.00, compra200omo.getQuantidade(), 0.00);
		assertEquals("O preço deveria ser igual!", 11.50, compra200omo.getValor(), 0.00);
		assertEquals("O produto deveria ser igual!", omo, compra200omo.getProduto());
		assertEquals("A data deveria ser igual!", dataCompra, compra200omo.getData());
		
	}
	@Test
	public void testarNovosMovimentosNoRepositório() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse("15/02/2017");
		
		Produto omo = new Produto("Omo Progress");
		Movimento compra100omo = new Compra(100.00, 12.00, omo, data);
		Movimento venda100omo = new Venda(100.00, 11.75, omo, data);
		Movimento compra200omo = new Compra(200.00, 11.50, omo, data);
		Movimento venda15omo = new Venda(15.00, 11.75, omo, data);
		
		MovimentoRepository repo = new MovimentoRepositoryTransient();
		repo.save(venda100omo);
		repo.save(venda15omo);		
		
		
		assertTrue("Deveria conter venda 100 omo!", repo.findAll().contains(venda100omo));
		assertTrue("Deveria conter venda 15 omo!", repo.findAll().contains(venda15omo));
		
		repo.save(compra100omo);
		repo.save(compra200omo);
		assertTrue("Deveria conter compra 100 omo!", repo.findAll().contains(compra100omo));
		assertTrue("Deveria conter compra 200 omo!", repo.findAll().contains(compra200omo));

		try {
			repo.findAll().remove(venda100omo);
			fail("Deveria ter gerado uma exception de modificação não permitida!");
		} catch (Exception e) {
			assertNotNull(e);
		}
		
		assertEquals("Ao procurar pelo id, deveria retornar o objeto correto!", venda15omo, repo.findById(venda15omo.getId()));
		assertEquals("Ao procurar pelo id, deveria retornar o objeto correto!", compra200omo, repo.findById(compra200omo.getId()));
		try {
			repo.findById("ed336e0e-bfd5-4434-8e6c-c3453aab8dbe");
			fail("Ao procurar por id inexistente, deveria gerar uma exceção!"); 			
		} catch (NotFoundException e) {
		}
	}

}
