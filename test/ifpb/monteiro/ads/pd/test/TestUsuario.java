package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

import org.junit.Test;

/*
 * Classe para testes do Usuário:
 * Adicionar, Alterar, Remover e Buscar. 
 * 
 * >>> EM ANDAMENTO <<<
 * 
 * @author Deivid Azevedo
 */
public class TestUsuario {

	public Fachada fachada = new Fachada();

	@Test
	public void testAdicionaUsuario() {
		try {
			fachada.adicionaUsuario("email@email.com", "123", "Maria");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

		try {
			fachada.adicionaUsuario("email2@email.com", "111", "Carlos");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

		// USUÁRIO JÁ CADASTRADO
		try {
			fachada.adicionaUsuario("email@email.com", "111", "Joana");
			fail("Usuário já cadastrado");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUsuarioInvalido() {
		try {
			fachada.adicionaUsuario("", "111", "José");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario(null, "111", "José");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("12312@ç%4.12", "111", "José");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("â000@email.q", "111", "José");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", "", "José");
			fail("Campo senha inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", null, "José");
			fail("Campo senha inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", "123", "");
			fail("Campo nome inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", "123", null);
			fail("Campo nome inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", "123", "$*#é_@");
			fail("Campo nome inválido");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testGetUsuario() {

		// TESTES PARA USUÁRIOS NÃO ENCONTRADOS
		try {
			fachada.buscaUsuario("emai2l@email.com");
			fail("Usuário não encontrado");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

		try {
			fachada.buscaUsuario("#$&çépontocom");
			fail("Usuário não encontrado");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

		try {
			fachada.buscaUsuario("");
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

		try {
			fachada.buscaUsuario(null);
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testRemoveUsuario() {

		try {
			fachada.removeUsuario("email@email.com", "123");
		} catch (HumQueCaroException e) {
			fail("Campo email inválido");
		}

		try {
			fachada.removeUsuario("email2@email.com", "111");
		} catch (HumQueCaroException e) {
			fail("Campo email inválido");
		}

		// REMOVER USUÁRIO JÁ REMOVIDO, NÃO CADASTRADO E/OU SENHA INCORRETA
		try {
			fachada.removeUsuario("email@email.com", "123");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeUsuario("email2@email.com", "222");
			fail("Campo senha inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeUsuario("emil@email.com", "111");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeUsuario("email2@email.com", "111");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeUsuario("", "111");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeUsuario(null, "111");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeUsuario("email@email.com", "");
			fail("Campo senha inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeUsuario("email@email.com", null);
			fail("Campo senha inválido");
		} catch (HumQueCaroException e) {
		}

	}
}
