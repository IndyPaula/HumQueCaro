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
public class TestAlteraProduto {

    FachadaIF fachada;

    public TestAlteraProduto() {
    }

    @Before
    public void setUp() {
        fachada = new Fachada();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAlteraProduto() {
        try {
            fachada.alteraProduto("01", "Nome", "X-Milho");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.alteraProduto("02", "Fabricante", "Maria Zefinha");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.alteraProduto("03", "Nome", "Pippos");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
    }

    @Test
    public void testAlteraProdutoInvalido() {
        try {
            fachada.alteraProduto("04", "nooome", "Pippos");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("04", "Fabriicantee", "Fab2");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("", "Nome", "Pippos");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto(null, "Nome", "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("03", "", "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("02", null, "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("04", "Fabricante", "");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("01", "Nome", null);
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("codigoinvalido", "Nome", "nome novo");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
    }
}