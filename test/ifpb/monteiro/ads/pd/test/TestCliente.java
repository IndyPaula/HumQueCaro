package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

import org.junit.Test;

/*
 * Classe para testes de Clientes, cadastrados no sistema HumQueCaro.
 */
public class TestCliente {

	public Fachada fachada = new Fachada();

	@Test
	public void testAddCliente() {
		try {
			fachada.adicionaCliente("Mirna", "11111111111");
		} catch (HumQueCaroException e) {
			fail("Cliente j� cadastrado");
		}

		try {
			fachada.adicionaCliente("Z� da Ro�a", "12345678901");
		} catch (HumQueCaroException e) {
			fail("Cliente j� cadastrado");
		}

		// TESTE PARA CLIENTES J� CADASTRADOS ATRAV�S DO TELEFONE
		try {
			fachada.adicionaCliente("Mariquinha", "12345678901");
			fail("Cliente j� cadastrado");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("Mariquinha", "11111111111");
			fail("Cliente j� cadastrado");
		} catch (HumQueCaroException e) {
		}
	}

	@Test
	public void testClienteInvalido() {
		try {
			fachada.adicionaCliente("", "1111111111");
			fail("Campo nome do cliente inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente(null, "1111111111");
			fail("Campo nome do cliente inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("NomeDoCliente", "");
			fail("Campo telefone inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("NomeDoCliente", null);
			fail("Campo telefone inv�lido");
		} catch (HumQueCaroException e) {
		}

		// NUMERO DE TELEFONE DO CLIENTE DEVE, OBRIGATORIAMENTE
		// CONTER 11 N�MEROS, AO CONTR�RIO DEVE LAN�AR EXCE��O
		try {
			fachada.adicionaCliente("NomeDoCliente", "1231231231");
			fail("Campo telefone inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("NomeDoCliente", "123123123123");
			fail("Campo telefone inv�lido");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testRemoveCliente() {
		// Removendo clientes cadastrados
		try {
			fachada.removeCliente("11111111111");
		} catch (HumQueCaroException e) {
			fail("Cliente n�o cadastrado");
		}

		try {
			fachada.removeCliente("12345678901");
		} catch (HumQueCaroException e) {
			fail("Cliente n�o cadastrado");
		}

		// REMOVENDO CLIENTES J� REMOVIDOS E VALORES INV�LIDOS
		try {
			fachada.removeCliente("11111111111");
			fail("Cliente n�o cadastrado");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("12345678901");
			fail("Cliente n�o cadastrado");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("");
			fail("Campo inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente(null);
			fail("Campo inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("123456789012");
			fail("Campo inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("1234567890");
			fail("Campo inv�lido");
		} catch (HumQueCaroException e) {
		}

	}

}