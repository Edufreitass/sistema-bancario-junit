package com.udemy.junit.negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realidades pela classe {@link GerenciadoraClientes}.
 * 
 * @author Eduardo Freitas
 * @date 04/11/2020
 */
public class GerenciadoraClientesTest_Ex5 {

	private GerenciadoraClientes gerClientes;
	
	/**
	 * Teste básico da pesquisa de um cliente a partir do seu ID
	 * 
	 * @author Eduardo Freitas
	 * @date 04/11/2020
	 */
	@Test
	public void testPesquisaCliente() {
		
		/* =========== Montagem do cenário =========== */
		
		// criando alguns clientes
		int idCliente01 = 1;
		int idCliente02 = 2;
		Cliente cliente1 = new Cliente(idCliente01, "Eduardo Freitas", 24, "eduardo@gmail.com", 1, true);
		Cliente cliente2 = new Cliente(idCliente02, "John Doe", 40, "john@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente1);
		clientesDoBanco.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
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
		/* =========== Montagem do cenário =========== */
		
		// criando alguns clientes
		int idCliente01 = 1;
		int idCliente02 = 2;
		Cliente cliente1 = new Cliente(idCliente01, "Eduardo Freitas", 24, "eduardo@gmail.com", 1, true);
		Cliente cliente2 = new Cliente(idCliente02, "John Doe", 40, "john@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente1);
		clientesDoBanco.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* =========== Execução =========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		/* =========== Verificações =========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}
	
}
