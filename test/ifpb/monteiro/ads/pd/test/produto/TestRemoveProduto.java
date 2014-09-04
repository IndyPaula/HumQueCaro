/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.test.produto;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Deivid Azevedo
 */
public class TestRemoveProduto {

    FachadaIF fachada;

    public TestRemoveProduto() {
    }

    @Before
    public void setUp() {
        fachada = new Fachada();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRemoveProduto() {
        try {
            fachada.removeProduto("01");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.removeProduto("02");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.removeProduto("03");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.removeProduto("04");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
    }

    @Test
    public void testRemoveProdutoInvalido() {
        try {
            fachada.removeProduto("");
            fail("Erro");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.removeProduto(null);
            fail("Erro");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.removeProduto("01");
            fail("Erro");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.removeProduto("04");
            fail("Erro");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.removeProduto("00000");
            fail("Erro");
        } catch (HumQueCaroException ex) {
        }
    }
}