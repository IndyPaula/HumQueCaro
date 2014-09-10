/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.test;

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
public class TestGetAllProdutos {

    private FachadaIF fachada;

    public TestGetAllProdutos() {
    }

    @Before
    public void setUp() {
        fachada = new Fachada();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetProdutos() {
        try {
            fachada.adicionaUsuario("adm@adm.com", "00000", "administrador");
            fachada.fazerLogin("adm@adm.com", "00000");
        } catch (HumQueCaroException ex) {
            Logger.getLogger(TestGetAllProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fachada.adicionaProduto("Nome", "Codigo", "Fab", "1.00");
            fachada.adicionaProduto("Nome2", "Codigo2", "Fab2", "1.00");
            fachada.adicionaProduto("Nome3", "Codigo3", "Fab3", "1.00");
            fachada.adicionaProduto("Nome4", "Codigo4", "Fab4", "1.00");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            assertEquals(4, fachada.getProdutos().size());
        } catch (HumQueCaroException ex) {
            fail("Erro em Listar Produtos: " + ex.getMessage());
        }
        try {
            fachada.removeProduto("Codigo4");
        } catch (HumQueCaroException ex) {
            fail("Erro em remover Produto: " + ex.getMessage());
        }
        try {
            assertEquals(3, fachada.getProdutos().size());
        } catch (HumQueCaroException ex) {
            fail("Erro em Listar Produtos: " + ex.getMessage());
        }
        try {
            fachada.removeProduto("Codigo3");
            fachada.removeProduto("Codigo2");
        } catch (HumQueCaroException ex) {
            fail("Erro em remover Produto: " + ex.getMessage());
        }
        try {
            assertEquals(1, fachada.getProdutos().size());
        } catch (HumQueCaroException ex) {
            fail("Erro em Listar Produtos: " + ex.getMessage());
        }
        try {
            fachada.adicionaProduto("Nome2", "Codigo2", "Fab2", "1.00");
            fachada.adicionaProduto("Nome3", "Codigo3", "Fab3", "1.00");
            fachada.adicionaProduto("Nome4", "Codigo4", "Fab4", "1.00");
            fachada.adicionaProduto("Nome5", "Codigo5", "Fab5", "1.00");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Produto: " + ex.getMessage());
        }
        try {
            assertEquals(5, fachada.getProdutos().size());
        } catch (HumQueCaroException ex) {
            fail("Erro em Listar Produtos: " + ex.getMessage());
        }
        try {
            fachada.removeProduto("Codigo5");
            fachada.removeProduto("Codigo4");
            fachada.removeProduto("Codigo3");
            fachada.removeProduto("Codigo2");
            fachada.removeProduto("Codigo");
        } catch (HumQueCaroException ex) {
            fail("Erro em remover Produto: " + ex.getMessage());
        }
        try {
            assertEquals(0, fachada.getProdutos().size());
        } catch (HumQueCaroException ex) {
            fail("Erro em Listar Produtos: " + ex.getMessage());
        }

    }

    @Test
    public void testFinal() {
        try {
            fachada.removeUsuario("adm@adm.com", "00000");
        } catch (HumQueCaroException ex) {
            Logger.getLogger(TestGetAllProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fachada.disconnect();
        } catch (HumQueCaroException ex) {
            Logger.getLogger(TestGetAllProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}