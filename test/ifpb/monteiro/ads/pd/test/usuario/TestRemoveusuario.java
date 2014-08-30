package ifpb.monteiro.ads.pd.test.usuario;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Classe para testes do Usuario:
 * Remover! 
 * 
 * Agora esta classe está sobre meu poder. Um abraço!
 * Att, Luiz Antonio
 *
 * @author Luiz Antonio
 */
public class TestRemoveusuario {
    
    private Fachada fachada;
    
    @Before
    public void setUp() {
        fachada = new Fachada();
        try {
            fachada.removeUsuario("luiz.antonioPS95@gmail.com", "senha");
        } catch (HumQueCaroException e) {
            fail("Acusou erro no removeUsuário: " + e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRemoverUsuario() {
    
        //Valores nulos ou vazios
        try {
            fachada.removeUsuario(null, null);
            fail("Não era para remover Usuário - email nulo");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.removeUsuario("", null);
            fail("Não era para remover Usuário - email vazio");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.removeUsuario("luizAntonio@hotmail.com", null);
            fail("Não era para remover Usuário - senha nula");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.removeUsuario("luizAntonio@hotmail.com", "");
            fail("Não era para remover Usuário - senha vazia");
        } catch (HumQueCaroException e) {
        }
        
        //Removendo com email inválido
        try {
            fachada.removeUsuario("luizAntonio@gmail.com", "minhaSenha");
            fail("Não era para remover Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.removeUsuario("luiz-antonio95@live.com", "senha");
            fail("Não era para remover Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.removeUsuario("luiz.antonioPS95@gmail.com", "senha");
            fail("Não era para remover Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        //Removendo com senha inválida
        try {
            fachada.removeUsuario("luizAntonio@hotmail.com", "minhaSenha1");
            fail("Não era para remover Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.removeUsuario("luizAntonio@hotmail.com", "minha Senha");
            fail("Não era para remover Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.removeUsuario("luizAntonio@hotmail.com", "minhasenha");
            fail("Não era para remover Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.removeUsuario("luizAntonio@hotmail.com", " minhaSenha");
            fail("Não era para remover Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.removeUsuario("luizAntonio@hotmail.com", "senha");
            fail("Não era para remover Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
    }
}
