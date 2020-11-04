package com.udemy.junit.negocio;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre contas, realidades pela classe {@link GerenciadoraContas}.
 * 
 * @author Eduardo Freitas
 * @date 04/11/2020
 */
public class GerenciadoraContasTest_Ex4 {

	private GerenciadoraContas gerContas;
	
	/**
	 * Teste básico da transferência de um valor da conta de um cliente para outro,
	 * estando ambos os clientes ativos e havendo saldo suficiente para tal transferência
	 * ocorrer com sucesso.
	 * 
	 * @author Eduardo Freitas
	 * @date 04/11/2020
	 */
	@Test
	public void testTransfereValor() {
		
		/* =========== Montagem do cenário =========== */
		
		// criando alguns clientes
		ContaCorrente conta01 = new ContaCorrente(1, 200, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);

		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		/* =========== Execução =========== */
		boolean sucesso = gerContas.transfereValor(1, 100, 2);

		/* =========== Verificações =========== */
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
	}
	
}
