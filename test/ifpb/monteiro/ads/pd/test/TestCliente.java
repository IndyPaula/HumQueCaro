package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import org.junit.BeforeClass;

import org.junit.Test;

/*
 * Classe para testes de Clientes, cadastrados no sistema HumQueCaro.
 */
public class TestCliente {

    public static Fachada fachada = new Fachada();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        try {
            fachada.adicionaCliente("Alvaro", "08799001122");
        } catch (HumQueCaroException e) {
            fail("Cliente nao adicionado");
        }

        try {
            fachada.adicionaCliente("Tiririca", "08791001122");
        } catch (HumQueCaroException e) {
            fail("Cliente nao adicionado");
        }
    }
    // TESTE PARA ADICIONAR CLIENTE

    @Test
    public void testAddCliente() {
        try {
            fachada.adicionaCliente("Mirna", "08792001122");
        } catch (HumQueCaroException e) {
            fail("Cliente ja cadastrado");
        }

        try {
            fachada.adicionaCliente("Ze do pao", "08788001122");
        } catch (HumQueCaroException e) {
            fail("Cliente ja cadastrado");
        }
    }

    // TESTE PARA ADICIONAR CLIENTES JA CADASTRADOS ATRAVES DO TELEFONE
    @Test
    public void addClienteInvalido() {
        try {
            fachada.adicionaCliente("Mariquinha", "08799001122");
            fail("Cliente ja cadastrado");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaCliente("Mariquinha", "08791001122");
            fail("Cliente ja cadastrado");
        } catch (HumQueCaroException e) {
        }
    }

    // TESTANDO COM ENTRADAS INVALIDAS
    @Test
    public void testClienteInvalido() {
        // NOME NULO OU VAZIO
        try {
            fachada.adicionaCliente("", "1111111111");
            fail("Campo nome do cliente invalido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaCliente(null, "22222222222");
            fail("Campo nome do cliente invalido");
        } catch (HumQueCaroException e) {
        }
        // TELEFONE NULO OU VAZIO
        try {
            fachada.adicionaCliente("Nome", "");
            fail("Campo telefone invalido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaCliente("Nome", null);
            fail("Campo telefone invalido");
        } catch (HumQueCaroException e) {
        }
        // NUMERO DE TELEFONE COM MENOS OU MAIS DE 11 DIGITOS
        try {
            fachada.adicionaCliente("Nome", "1231231231");
            fail("Campo telefone invalido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaCliente("Nome", "123123123123");
            fail("Campo telefone invalido");
        } catch (HumQueCaroException e) {
        }
    }
    
    // TESTE PARA REMOVER CLIENTE
    @Test
    public void testRemoveCliente() {
        // REMOVENDO CLIENTES CADASTRADOS
        try {
            fachada.removeCliente("08799001122");
        } catch (HumQueCaroException e) {
            fail("Cliente nao cadastrado");
        }

        // REMOVENDO CLIENTES QUE NAO EXISTEM
        try {
            fachada.removeCliente("00000000000");
            fail("Cliente nao cadastrado");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.removeCliente("99999999999");
            fail("Cliente nao cadastrado");
        } catch (HumQueCaroException e) {
        }
        // REMOVENDO CLIENTES COM ENTRADAS INVALIDAS
        try {
            fachada.removeCliente("");
            fail("Campo invalido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.removeCliente(null);
            fail("Campo invalido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.removeCliente("123456789012");
            fail("Campo invalido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.removeCliente("1234567890");
            fail("Campo invalido");
        } catch (HumQueCaroException e) {
        }

    }
}
