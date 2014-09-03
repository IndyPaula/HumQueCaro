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
public class TestAlteraProduto {

    Fachada fachada;

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
            fachada.alteraProduto("001", "Nome", "X-Milho");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.alteraProduto("002", "Fabricante", "Maria Zefinha");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            fachada.alteraProduto("123123", "Nome", "Pippos");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
    }

    @Test
    public void testAlteraProdutoInvalido() {
        try {
            fachada.alteraProduto("123123", "nooome", "Pippos");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("", "nooome", "Pippos");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto(null, "000", "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("003", "", "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("002", null, "fab");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("000", "Fabricante", "");
            fail("Erro ao adicionar Produto");
        } catch (HumQueCaroException ex) {
        }
        try {
            fachada.alteraProduto("001", "Nome", null);
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