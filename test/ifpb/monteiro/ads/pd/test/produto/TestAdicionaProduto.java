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
            fachada.adicionaProduto("Produto", "001", "fabricante", "3.00");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Coxinha", "002", "Maria da Coxinha", "3.00");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Hamburguer", "003", "Neguinha", "2.00");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Roscovo", "004", "Sizenando", "2.00");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
    }

    @Test
    public void testAddProdutoInvalido() {
        try {
            fachada.adicionaProduto("", "000", "fab", "valor");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto(null, "000", "fab", "valor");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto("Produto", "", "fab", "valor");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto("Produto", null, "fab", "valor");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto("Produto", "codigoProduto", "", "valor");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto("Produto", "codigoProduto", null, "valor");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
    }
}