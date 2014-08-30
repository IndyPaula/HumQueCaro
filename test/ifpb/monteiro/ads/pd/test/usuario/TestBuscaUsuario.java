package ifpb.monteiro.ads.pd.test.usuario;

import ifpb.monteiro.ads.pd.beans.Usuario;
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

/*
 * Classe para testes do Usuario:
 * Buscar! 
 * 
 * Agora esta classe está sobre meu poder. Um abraço!
 * Att, Luiz Antonio
 *
 * @author Luiz Antonio
 */
public class TestBuscaUsuario {
    
    private Fachada fachada;
    private Usuario user1, user2;
    
    @Before
    public void setUp() {
        fachada = new Fachada();
        try {
            user1 = fachada.buscaUsuario("luizAntonio@hotmail.com");
        } catch (HumQueCaroException e) {
            fail("Acusou erro no buscaUsuário: " + e.getMessage());
        }
        
        try {
            user2 = fachada.buscaUsuario("luiz.antonioPS95@gmail.com");
        } catch (HumQueCaroException e) {
            fail("Acusou erro no buscaUsuário: " + e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testBuscaUsuario(){
        
        assertEquals("Luiz Antonio", user1.getNome());
        assertEquals("luizAntonio@hotmail.com", user1.getEmail());
        assertEquals("minhaSenha", user1.getSenha());
        
        assertEquals("Luiz Antonio P Silva", user2.getNome());
        assertEquals("senha", user2.getSenha());
        assertEquals("luiz.antonioPS95@gmail.com", user2.getEmail());
        
        //Valores nulos ou vazios
        try {
            fachada.buscaUsuario(null);
            fail("Não era para buscar Usuário - email nulo");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.buscaUsuario("");
            fail("Não era para buscar Usuário - email vazio");
        } catch (HumQueCaroException e) {
        }
        
        //Busca com emails inválidos ou inexistes
        try {
            fachada.buscaUsuario("1");
            fail("Não era para buscar Usuário - email inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.buscaUsuario(" ");
            fail("Não era para buscar Usuário - email inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.buscaUsuario("luiz-antonio95@live.com");
            fail("Não era para buscar Usuário - email inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.buscaUsuario(" @ ");
            fail("Não era para buscar Usuário - email inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.buscaUsuario("luiz@ntonio@gmail.com");
            fail("Não era para buscar Usuário - email inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.buscaUsuario("luiz@g@mail.com");
            fail("Não era para buscar Usuário - email inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.buscaUsuario("luiz@gmail.com1");
            fail("Não era para buscar Usuário - email inválido ou inexistente");
        } catch (HumQueCaroException e) {
        }
    }
}
