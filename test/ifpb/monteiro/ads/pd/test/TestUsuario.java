package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

import org.junit.Test;

/*
 * Classe para testes do UsuÃ¡rio:
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
			fachada.adicionaUsuario("email@email.com", "1234", "Jose");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}
		
		try {
			fachada.adicionaUsuario("email2@email.com", "111", "Carlos");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

		// USUÃ�RIO JÃ� CADASTRADO
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
			fachada.adicionaUsuario("", "111", "Jose");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario(null, "111", "Jose");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("12312@Ã§%4.12", "111", "Jose");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("Ã¢000@email.q", "111", "Jose");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", "", "Jose");
			fail("Campo senha inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", null, "Jose");
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
			fachada.adicionaUsuario("email@email.com", "123", "$*#Ã©_@");
			fail("Campo nome inválido");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testGetUsuario() {

		// TESTES PARA USUÃ�RIOS NÃƒO ENCONTRADOS
		try {
			fachada.buscaUsuario("emai2l@email.com");
			fail("Usuario nao encontrado");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

		try {
			fachada.buscaUsuario("#$&Ã§Ã©pontocom");
			fail("Usuario nao encontrado");
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

		// REMOVER USUÃ�RIO JÃ� REMOVIDO, NÃƒO CADASTRADO E/OU SENHA INCORRETA
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
	
	@Test
	public void testAlteraUsuario() {
		
		try {
			fachada.alteraProduto(" ", "jose", "1234");
			fail("Campo Codigo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto(null, "jose", "1234");
			fail("Campo Codigo invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("132456hfgh", "jose", "1234");
			fail("Campo Codigo invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("214i#$%", "jose", "1234");
			fail("Campo Codigo invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("1", "nome", " ");
			fail("Campo Atributo invalido");
		} catch (HumQueCaroException e) {
		}
		
		try {
			fachada.alteraProduto("1", "nome", null);
			fail("Campo Atributo invalido");
		} catch (HumQueCaroException e) {
		}
		
		try {
			fachada.alteraProduto("1", "nome", "maria42");
			fail("Campo Atributo invalido");
		} catch (HumQueCaroException e) {
		}
		try {
			fachada.alteraProduto("1", "nome", "mari$%");
			fail("Campo Atributo invalido");
		} catch (HumQueCaroException e) {
		}
		try {
			fachada.alteraProduto("1", "nome", "435$%¨$");
			fail("Campo Atributo invalido");
		} catch (HumQueCaroException e) {
		}
		try {
			fachada.alteraProduto("1", "nome", "m09))(){}");
			fail("Campo Atributo invalido");
		} catch (HumQueCaroException e) {
		}
		try {
			fachada.alteraProduto("1", "nome", "SADFdf");
			fail("Campo Atributo invalido");
		} catch (HumQueCaroException e) {
		}
		try {
			fachada.alteraProduto("1", "nome", "111");
			fail("Campo Atributo invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("1", "senha", " ");
			fail("Campo NovoValor invalido");
		} catch (HumQueCaroException e) {
		}
		try {
			fachada.alteraProduto("1", "senha", null);
			fail("Campo NovoValor invalido");
		} catch (HumQueCaroException e) {
		}

	}
}