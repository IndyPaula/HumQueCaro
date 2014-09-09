package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLogin {

    private static Fachada fachada = new Fachada();
    

    public TestLogin() {
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        fachada.adicionaUsuario("giogio@gmail.com", "dinheiro", "Gio");
        fachada.fazerLogin("giogio@gmail.com", "dinheiro");
        fachada.adicionaCliente("Lek Piranha", "08199998888");
        fachada.adicionaProduto("Chocolate", "121312", "Nestle", "1.20");
        fachada.disconnect();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * Testa adicionar alguma coisa sem o camarada tah logado
     */
    @Test
    public void testAddDeslogado() {
        try {
            fachada.adicionaCliente("Lek Piranha 2", "08199998888 2");
            fail("Usuario nao ta logado");
        } catch (HumQueCaroException e) {
        }
        try {
            fachada.adicionaProduto("Chocolate 2", "121312 2", "Nestle 2",
                    "1.20");
            fail("Usuario nao ta logado");
        } catch (HumQueCaroException e) {
        }
    }

    /**
     * Testa alterar alguma coisa sem o camarada tah logado
     */
    @Test
    public void testAlteraDeslogado() {
        try {
            fachada.alteraUsuario("giogio@gmail.com", "nome", "Gio Gio");
            fail("Usuario nao ta logado");
        } catch (HumQueCaroException e) {
        }
        try {
            fachada.alteraProduto("121312", "fabricante", "Bauducco");
            fail("Usuario nao ta logado");
        } catch (HumQueCaroException e) {
        }
        try {
            fachada.alteraCliente("08199998888", "nome", "Lelek");
            fail("Usuario nao ta logado");
        } catch (HumQueCaroException e) {
        }
    }

    /**
     * Testa Remove alguma coisa sem o camarada tah logado
     */
    @Test
    public void testRemoveDeslogado() {
        try {
            fachada.removeUsuario("giogio@gmail.com", "dinheiro");
            fail("Usuario nao ta logado");
        } catch (HumQueCaroException e) {
        }
        try {
            fachada.removeProduto("121312");
            fail("Usuario nao ta logado");
        } catch (HumQueCaroException e) {
        }
        try {
            fachada.removeCliente("08199998888");
            fail("Usuario nao ta logado");
        } catch (HumQueCaroException e) {
        }
    }

    /**
     * Testa adicionar alguma coisa com o camarada logado
     */
    @Test
    public void testAddLogado() {
        try {
            fachada.fazerLogin("giogio@gmail.com", "dinheiro");
        } catch (HumQueCaroException e1) {
            fail("Deve fazer o login normalmente");
        }
        try {
            fachada.adicionaCliente("Lek Piranha 2", "08199998887");
        } catch (HumQueCaroException e) {
            fail("Usuario ta logado");
        }
        try {
            fachada.adicionaProduto("Chocolate 2", "121312 2", "Nestle 2",
                    "1.20");
        } catch (HumQueCaroException e) {
            fail("Usuario ta logado");
        }
        try {
            fachada.disconnect();
        } catch (HumQueCaroException e) {
            fail("Deve deslogar");
        }

    }

    /**
     * Testa alterar alguma coisa com o camarada logado
     */
    @Test
    public void testAlteraLogado() {
        try {
            fachada.fazerLogin("giogio@gmail.com", "dinheiro");
        } catch (HumQueCaroException e1) {
            fail("Deve fazer o login normalmente");
        }
        try {
            fachada.alteraUsuario("giogio@gmail.com", "nome", "Gio Gio");
        } catch (HumQueCaroException e) {
            fail("Usuario ta logado");
        }
        try {
            fachada.alteraProduto("121312", "fabricante", "Bauducco");
        } catch (HumQueCaroException e) {
            fail("Usuario ta logado");
        }
        try {
            fachada.alteraCliente("08199998888", "Nome", "Lelek");
        } catch (HumQueCaroException e) {
            fail("Usuario ta logado");
        }
        try {
            fachada.disconnect();
        } catch (HumQueCaroException e) {
            fail("Deve deslogar");
        }
    }

    /**
     * Testa Remove alguma coisa com o camarada logado
     */
    @Test
    public void testRemoveLogado() {
        try {
            fachada.fazerLogin("giogio@gmail.com", "dinheiro");
        } catch (HumQueCaroException e1) {
            fail("Deve fazer o login normalmente");
        }
        try {
            fachada.removeUsuario("giogio@gmail.com", "dinheiro");
        } catch (HumQueCaroException e) {
            fail("Usuario ta logado");
        }
        try {
            fachada.removeProduto("121312");
        } catch (HumQueCaroException e) {
            fail("Usuario ta logado");
        }
        try {
            fachada.removeCliente("08199998888");
        } catch (HumQueCaroException e) {
            fail("Usuario ta logado");
        }
        try {
            fachada.disconnect();
        } catch (HumQueCaroException e) {
            fail("Deve deslogar");
        }
    }
}
