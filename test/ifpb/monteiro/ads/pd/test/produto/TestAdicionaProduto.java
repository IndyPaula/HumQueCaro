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
public class TestAdicionaProduto {

    FachadaIF fachada;

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
            fachada.adicionaProduto("Produto1", "01", "Fabricante1", "2.00");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Produto2", "02", "Fabricante2", "2.00");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Produto3", "03", "Fabricante3", "2.00");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Produto4", "04", "Fabricante4", "2.00");
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
        try {
            fachada.adicionaProduto("Produto", "codigoProduto", "fabricante", "");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.adicionaProduto("Produto", "codigoProduto", "fabricante", null);
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
    }
}