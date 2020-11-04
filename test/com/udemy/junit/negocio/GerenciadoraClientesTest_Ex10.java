package com.udemy.junit.negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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
public class GerenciadoraClientesTest_Ex10 {

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
		
		// a) Abriu conexão com o BD? Então...
		// b) Criou arquivos e pastas aqui? Então...
		// c) Inseriu clientes ficticios na base de dados especificamente para os testes desta classe? Então...
		
//		System.out.println("Before foi executado");
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
		
		// a) Fecha aqui!!!
		// b) Apaga todos eles aqui!!!
		// c) Apaga eles aqui!!!
		
//		System.out.println("After foi executado");
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
	 * Teste básico da pesquisa de um cliente que não existe
	 * 
	 * @author Eduardo Freitas
	 * @date 04/11/2020
	 */
	@Test
	public void testPesquisaClienteInexistente() {
		
		/* =========== Execução =========== */
		Cliente cliente = gerClientes.pesquisaCliente(1001);
		
		/* =========== Verificações =========== */
		assertNull(cliente);
		
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
	
	/**
	 * Teste da tentativa de remoção de um cliente inexistente.
	 * 
	 * @author Eduardo Freitas
	 * @date 04/11/2020
	 */
	@Test
	public void testRemoveClienteInexistente() {
		
		/* =========== Execução =========== */
		boolean clienteRemovido = gerClientes.removeCliente(1001);
		
		/* =========== Verificações =========== */
		assertThat(clienteRemovido, is(false));
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
		
	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está no intervalo permitido.
	 * 
	 * @author Eduardo Freitas
	 * @throws IdadeNaoPermitidaException
	 * @date 04/11/2020
	 */
	@Test
	public void testClienteIdadeAceitavel() throws IdadeNaoPermitidaException {
		
		/* =========== Montagem do cenário =========== */
		Cliente cliente = new Cliente(1, "Eduardo", 24, "eduardo@gmail.com", 1, true);

		/* =========== Execução =========== */
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

		/* =========== Verificações =========== */
		assertTrue(idadeValida);

	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está no intervalo permitido.
	 * 
	 * @author Eduardo Freitas
	 * @throws IdadeNaoPermitidaException
	 * @date 04/11/2020
	 */
	@Test
	public void testClienteIdadeAceitavel_02() throws IdadeNaoPermitidaException {
		
		/* =========== Montagem do cenário =========== */
		Cliente cliente = new Cliente(1, "Eduardo", 18, "eduardo@gmail.com", 1, true);

		/* =========== Execução =========== */
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

		/* =========== Verificações =========== */
		assertTrue(idadeValida);

	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está no intervalo permitido.
	 * 
	 * @author Eduardo Freitas
	 * @throws IdadeNaoPermitidaException
	 * @date 04/11/2020
	 */
	@Test
	public void testClienteIdadeAceitavel_03() throws IdadeNaoPermitidaException {
		
		/* =========== Montagem do cenário =========== */
		Cliente cliente = new Cliente(1, "Eduardo", 65, "eduardo@gmail.com", 1, true);

		/* =========== Execução =========== */
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

		/* =========== Verificações =========== */
		assertTrue(idadeValida);

	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está abaixo do intervalo permitido.
	 * 
	 * @author Eduardo Freitas
	 * @throws IdadeNaoPermitidaException
	 * @date 04/11/2020
	 */
	@Test
	public void testClienteIdadeInaceitavel() throws IdadeNaoPermitidaException {
		
		/* =========== Montagem do cenário =========== */
		Cliente cliente = new Cliente(1, "Eduardo", 17, "eduardo@gmail.com", 1, true);

		/* =========== Execução =========== */
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			/* =========== Verificações =========== */
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}

	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está acima do intervalo permitido.
	 * 
	 * @author Eduardo Freitas
	 * @throws IdadeNaoPermitidaException
	 * @date 04/11/2020
	 */
	@Test
	public void testClienteIdadeInaceitavel_02() throws IdadeNaoPermitidaException {
		
		/* =========== Montagem do cenário =========== */
		Cliente cliente = new Cliente(1, "Eduardo", 66, "eduardo@gmail.com", 1, true);

		/* =========== Execução =========== */
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			/* =========== Verificações =========== */
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}

	}
	
}
