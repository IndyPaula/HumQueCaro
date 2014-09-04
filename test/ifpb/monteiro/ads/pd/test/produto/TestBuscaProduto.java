/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.test.produto;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Deivid Azevedo
 */
public class TestBuscaProduto {

    FachadaIF fachada;
    Produto produto;

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
                    fachada.buscaProduto("01").getNome());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
        try {
            assertEquals("Maria Zefinha",
                    fachada.buscaProduto("02").getFabricante());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
        try {
            assertEquals("Pippos",
                    fachada.buscaProduto("03").getNome());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
        try {
            assertEquals("Fabricante4",
                    fachada.buscaProduto("04").getFabricante());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
        try {
            assertEquals("2.00",
                    fachada.buscaProduto("01").getValor());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }
        try {
            assertEquals(4, fachada.getProdutos().size());
        } catch (HumQueCaroException ex) {
            fail("Erro em buscar Produto: " + ex.getMessage());
        }

    }

    @Test
    public void testBuscaProdutoInvalido() {
        try {
            produto = fachada.buscaProduto("111");
            fail("Erro em buscar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.buscaProduto("");
            fail("Erro em buscar Produto: ");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.buscaProduto(null);
            fail("Erro em buscar Produto: ");
        } catch (HumQueCaroException ex) {
        }
    }
}