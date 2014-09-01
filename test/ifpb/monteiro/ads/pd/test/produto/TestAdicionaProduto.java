/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.test.produto;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Deivid Azevedo
 */
public class TestAdicionaProduto {

    Fachada fachada;

    public TestAdicionaProduto() {
    }

    @Before
    public void setUp() {
        fachada = new Fachada();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddProduto() {
        try {
            fachada.adicionaProduto("Produto", "001", "fabricante");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Coxinha", "002", "Maria da Coxinha");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Hamburguer", "003", "Neguinha");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Roscovo", "004", "Sizenando");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
    }

    @Test
    public void testAddProdutoInvalido() {
        try {
            fachada.adicionaProduto("", "000", "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto(null, "000", "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto("Produto", "", "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto("Produto", null, "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto("Produto", "codigoProduto", "");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto("Produto", "codigoProduto", null);
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
    }
}