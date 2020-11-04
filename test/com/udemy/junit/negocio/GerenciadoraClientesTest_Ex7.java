package com.udemy.junit.negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realidades pela classe {@link GerenciadoraClientes}.
 * 
 * @author Eduardo Freitas
 * @date 04/11/2020
 */
public class GerenciadoraClientesTest_Ex7 {

	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	/**
	 * Método que monta o cenário de teste antes que qualquer método seja executado
	 * 
	 * @author Eduardo Freitas
	 * @date 04/11/2020
	 */
	@Before
	public void setUp() {
		
		/* =========== Montagem do cenário =========== */
		
		// criando alguns clientes
		
		Cliente cliente1 = new Cliente(idCliente01, "Eduardo Freitas", 24, "eduardo@gmail.com", 1, true);
		Cliente cliente2 = new Cliente(idCliente02, "John Doe", 40, "john@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente1);
		clientesDoBanco.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		System.out.println("Before foi executado");
	}
	
	/**
	 * Método que será executado após a execução de um teste
	 * 
	 * @author Eduardo Freitas
	 * @date 04/11/2020
	 */
	@After
	public void tearDown() {
		gerClientes.limpa();
		
		System.out.println("After foi executado");
	}
	
	/**
	 * Teste básico da pesquisa de um cliente a partir do seu ID
	 * 
	 * @author Eduardo Freitas
	 * @date 04/11/2020
	 */
	@Test
	public void testPesquisaCliente() {
		
		/* =========== Execução =========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		/* =========== Verificações =========== */
		assertThat(cliente.getId(), is(idCliente01));
		
	}
	
	/**
	 * Teste básico da remoção de um cliente a partir do seu ID.
	 * 
	 * @author Eduardo Freitas
	 * @date 04/11/2020
	 */
	@Test
	public void testRemoveCliente() {
		
		/* =========== Execução =========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		/* =========== Verificações =========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
		
	}
	
}
