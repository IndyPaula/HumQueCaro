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
public class TestGetAllClientes {

    private FachadaIF fachada;

    public TestGetAllClientes() {
    }

    @Before
    public void setUp() {
        fachada = new Fachada();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetClientes() {
        try {
            fachada.adicionaUsuario("adm@adm.com", "00000", "administrador");
            fachada.fazerLogin("adm@adm.com", "00000");
        } catch (HumQueCaroException ex) {
            Logger.getLogger(TestGetAllClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fachada.adicionaCliente("Deivid", "12121212121");
            fachada.adicionaCliente("Luciana", "09876543212");
        } catch (HumQueCaroException ex) {
            fail("Erro em adicionar Cliente: " + ex.getMessage());
        }
        try {
            assertEquals(2, fachada.getClientes().size());
        } catch (HumQueCaroException ex) {
            fail("Erro em Listar Clientes: " + ex.getMessage());
        }
        try {
            fachada.removeCliente("12121212121");
        } catch (HumQueCaroException ex) {
            fail("Erro em remover Cliente: " + ex.getMessage());
        }
        try {
            assertEquals(1, fachada.getClientes().size());
        } catch (HumQueCaroException ex) {
            fail("Erro em Listar Clientes: " + ex.getMessage());
        }
        try {
            fachada.removeCliente("09876543212");
        } catch (HumQueCaroException ex) {
            fail("Erro em remover Cliente: " + ex.getMessage());
        }
        try {
            assertEquals(0, fachada.getClientes().size());
        } catch (HumQueCaroException ex) {
            fail("Erro em Listar Clientes: " + ex.getMessage());
        }

    }

    @Test
    public void testFinal() {
        try {
            fachada.removeUsuario("adm@adm.com", "00000");
        } catch (HumQueCaroException ex) {
            Logger.getLogger(TestGetAllClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fachada.disconnect();
        } catch (HumQueCaroException ex) {
            Logger.getLogger(TestGetAllClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}