package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import org.junit.AfterClass;
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
            fachada.fazerLogin("widan@gmail.com", "42152244215224");
        } catch (HumQueCaroException ex) {
            fail("Usuario nao logou");
        }

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

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
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

    @Test
    public void testAlteraCliente() {
        //ALTERANDO CLIENTES CADASTRADOS
        try {
            fachada.alteraCliente("08791001122", "Nome", "Cheirozinho");
        } catch (HumQueCaroException e) {
            fail("Cliente nao alterado");
        }

        try {
            fachada.alteraCliente("08792001122", "Telefone", "08796332211");
        } catch (HumQueCaroException e) {
            fail("Cliente nao alterado");
        }

        //ALTERANDO CLIENTES QUE NÃO EXISTEM
        try {
            fachada.alteraCliente("11111111111", "Nome", "Juniorzito");
            fail("Cliente nao existe");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.alteraCliente("00011112222", "Telefone", "09735261534");
            fail("Cliente nao existe");
        } catch (HumQueCaroException e) {
        }

        //ALTERANDO CLIENTES COM ENTRADAS INVALIDAS
        try {
            fachada.alteraCliente("", "Nome", "Juniorzito");
            fail("Camo invalido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraCliente(null, "Nome", "Juniorzito");
            fail("Camo invalido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraCliente("08788001122", "", "Juniorzito");
            fail("Camo invalido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraCliente("08788001122", null, "Juniorzito");
            fail("Camo invalido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraCliente("08788001122", "Nome", "");
            fail("Camo invalido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraCliente("08788001122", "Nome", null);
            fail("Camo invalido");
        } catch (HumQueCaroException e) {
        }
    }
}
