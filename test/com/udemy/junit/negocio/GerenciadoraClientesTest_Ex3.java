package com.udemy.junit.negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author Eduardo Freitas
 *
 */
public class GerenciadoraClientesTest_Ex3 {

	private GerenciadoraClientes gerClientes;
	
	@Test
	public void testPesquisaCliente() {
		
		/* =========== Montagem do cenário =========== */
		
		// criando alguns clientes
		Cliente cliente1 = new Cliente(1, "Eduardo Freitas", 24, "eduardo@gmail.com", 1, true);
		Cliente cliente2 = new Cliente(2, "John Doe", 40, "john@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente1);
		clientesDoBanco.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* =========== Execução =========== */
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		/* =========== Verificações =========== */
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("eduardo@gmail.com"));
	}
	
	@Test
	public void testRemoveCliente() {
		/* =========== Montagem do cenário =========== */
		
		// criando alguns clientes
		Cliente cliente1 = new Cliente(1, "Eduardo Freitas", 24, "eduardo@gmail.com", 1, true);
		Cliente cliente2 = new Cliente(2, "John Doe", 40, "john@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente1);
		clientesDoBanco.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* =========== Execução =========== */
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		/* =========== Verificações =========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
	}
	
}
