/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.test.produto;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Deivid Azevedo
 */
public class TestBuscaProduto {

    Fachada fachada;

    public TestBuscaProduto() {
    }

    @Before
    public void setUp() {
        fachada = new Fachada();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBuscaProduto() {
        try {
            assertEquals("X-Milho",
                    fachada.buscaProduto("001").getNome());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
        try {
            assertEquals("Pippos",
                    fachada.buscaProduto("123123").getNome());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
        try {
            assertEquals("Teste",
                    fachada.buscaProduto("000").getNome());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
        try {
            assertEquals("Coxinha",
                    fachada.buscaProduto("002").getNome());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
        try {
            assertEquals("123123",
                    fachada.buscaProduto("Nome").getNome());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
    }

    @Test
    public void testBuscaProdutoInvalido() {
        try {
            assertEquals("123123",
                    fachada.buscaProduto("111").getNome());
            fail("Erro em buscar Produto");
        } catch (HumQueCaroException ex) {
        }
//        try {
//            fachada.buscaProduto("");
//            fail("Erro em buscar Produto: ");
//        } catch (HumQueCaroException ex) {
//        }
//        try {
//            fachada.buscaProduto(null);
//            fail("Erro em buscar Produto: ");
//        } catch (HumQueCaroException ex) {
//        }
    }
}