package com.udemy.junit.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
public class GerenciadoraContasTest_Ex6 {

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
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		/* =========== Execução =========== */
		boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);

		/* =========== Verificações =========== */
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
	}
	
	/**
	 * Teste básico da tentativa de transferência de um valor da conta de um cliente para outro
	 * quando não há saldo suficiente.
	 * 
	 * @author Eduardo Freitas
	 * @date 04/11/2020
	 */
	@Test
	public void testTranfereValor_SaldoInsuficiente() {
		
		/* =========== Montagem do cenário =========== */
		
		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		/* =========== Execução =========== */
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);

		/* =========== Verificações =========== */
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-100.0));
		assertThat(conta02.getSaldo(), is(200.0));
	}
	
}
