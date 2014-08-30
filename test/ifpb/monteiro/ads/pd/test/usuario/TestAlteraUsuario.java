package ifpb.monteiro.ads.pd.test.usuario;

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
 * @author Luiz Antonio
 */
public class TestAlteraUsuario {
    
    public Fachada fachada;
    
    @Before
    public void setUp() {
        fachada = new Fachada();
        try {
            fachada.alteraUsuario("luiz.antonio95@live.com", "nome", "Luiz Antonio");
        } catch (HumQueCaroException e) {
            fail("Acusou erro no alteraUsuário: " + e.getMessage());
        }
        try {
            fachada.alteraUsuario("luiz.antonio95@live.com", "senha", "minhaSenha");
        } catch (HumQueCaroException e) {
            fail("Acusou erro no alteraUsuário: " + e.getMessage());
        }
        //Posso alterar o email?
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testAlteraUsuario() {
        
        //Valores nulos ou vazios
        try {
            fachada.alteraUsuario(null, null, null);
            fail("Não era para alterar Usuário - email nulo");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", null, null);
            fail("Não era para alterar Usuário - atributo a ser modificado nulo");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "nome", null);
            fail("Não era para alterar Usuário - novo valor nulo");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("", "nome", "Jabuticaba");
            fail("Não era para alterar Usuário - email vazio");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "", "Jabuticaba");
            fail("Não era para alterar Usuário - atributo a ser modificado vazio");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "nome", "");
            fail("Não era para alterar Usuário - novo valor vazio");
        } catch (HumQueCaroException e) {
        }
        
        //Tentando modificar atributo inválido
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "Nome", "Jabuticaba");
            fail("Não era para alterar Usuário - Atributo inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "nomi", "Jabuticaba");
            fail("Não era para alterar Usuário - Atributo inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "sexo", "Jabuticaba");
            fail("Não era para alterar Usuário - Atributo inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "Senha", "Jabuticaba");
            fail("Não era para alterar Usuário - Atributo inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", " ", "Jabuticaba");
            fail("Não era para alterar Usuário - Atributo inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        //Alterando com nome inválido
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "nome", "Luiz1");
            fail("Não era para alterar Usuário - nome inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "nome", "LuizPS95");
            fail("Não era para alterar Usuário - nome inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "nome", "12");
            fail("Não era para alterar Usuário - nome inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "nome", " 01");
            fail("Não era para alterar Usuário - nome inválido");
        } catch (HumQueCaroException e) {
        }
        
        //Alterando com senha inválida
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "senha", "1");
            fail("Não era para alterar Usuário - senha inválida");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "senha", " ");
            fail("Não era para alterar Usuário - senha inválida");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "senha", "123");
            fail("Não era para alterar Usuário - senha inválida");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "senha", "sen");
            fail("Não era para alterar Usuário - senha inválida");
        } catch (HumQueCaroException e) {
        }
        
        //Alterando com email inválido
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "@gmail.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "luiz@.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "@");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", " @ ");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "@_.");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "@_.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "luiz@gmail");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "luiz@gmail.2");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "luiz@@gmail.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "luiz@g@mail.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "luiz@ntonio@gmail.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "luiz antonio@gmail.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "luiz@g mail.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "lui;z@gmail.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "l:uiz@gmail.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.alteraUsuario("luiz.antonioPS95@gmail.com", "email", "luiz(LêFodovisk)@gmail.com");
            fail("Não era para alterar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
    }
}
