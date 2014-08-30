package ifpb.monteiro.ads.pd.test.usuario;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 * Classe para testes do Usuario:
 * Adicionar, Alterar, Remover e Buscar. 
 * 
 * Agora esta classe está sobre meu poder. Um abraço!
 * Att, Luiz Antonio
 *
 * @author Luiz Antonio
 */
public class TestAdcionaUsuario {

    public Fachada fachada;

    @Before
    public void setUp() {
        fachada = new Fachada();
        try {
            fachada.adicionaUsuario("luiz.antonio95@live.com", "senha", "nome");
        } catch (HumQueCaroException e) {
            fail("Acusou erro no CriaUsuário: " + e.getMessage());
        }
        try {
            fachada.adicionaUsuario("luiz.antonioPS95@gmail.com", "senha", "Luiz Antonio P Silva");
        } catch (HumQueCaroException e) {
            fail("Acusou erro no CriaUsuário: " + e.getMessage());
        }
    }

    @After
    public static void tearDown() {
    }

    @Test
    public void testsUsuario() {
        
        //Valores nulos ou vazios
        try {
            fachada.adicionaUsuario(null, "senha", "nome");
            fail("Não era para adcionar Usuário - email nulo");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaUsuario(null, null, null);
            fail("Não era para adcionar Usuário - email nulo");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaUsuario("luiz@gmail.com", null, null);
            fail("Não era para adcionar Usuário - senha nulo");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaUsuario("luiz@gmail.com", "senha", null);
            fail("Não era para adcionar Usuário - nome nulo");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaUsuario("", "senha", "nome");
            fail("Não era para adcionar Usuário - email vazio");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaUsuario("luiz@gmail.com", "", "nome");
            fail("Não era para adcionar Usuário - senha vazia");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.adicionaUsuario("luiz@gmail.com", "senha", "");
            fail("Não era para adcionar Usuário - nome vazio");
        } catch (HumQueCaroException e) {
        }
        
        //Entrada para nome inválido
        try {
            fachada.adicionaUsuario("luiz@gmail.com", "senha", "Luiz1");
            fail("Não era para adcionar Usuário - nome inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@gmail.com", "senha", "LuizPS95");
            fail("Não era para adcionar Usuário - nome inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@gmail.com", "senha", "12");
            fail("Não era para adcionar Usuário - nome inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@gmail.com", "senha", " 01");
            fail("Não era para adcionar Usuário - nome inválido");
        } catch (HumQueCaroException e) {
        }
        
        //Entrada para email inválida
        try {
            fachada.adicionaUsuario("@gmail.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("@", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario(" @ ", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("@_.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("@_.", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@gmail", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@gmail.2", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@@gmail.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@g@mail.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@ntonio@gmail.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz antonio@gmail.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@g mail.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("lui;z@gmail.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("l:uiz@gmail.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz(LêFodovisk)@gmail.com", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@gmail", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@hotmail", "senha", "Luiz");
            fail("Não era para adcionar Usuário - email inválido");
        } catch (HumQueCaroException e) {
        }
        
        // Entrada para senha inválida(Senha conter pelo menos 4 caracteres)
        try {
            fachada.adicionaUsuario("luiz@gmail.com", "1", "Luiz");
            fail("Não era para adcionar Usuário - senha inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@gmail.com", " ", "Luiz");
            fail("Não era para adcionar Usuário - senha inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@gmail.com", "123", "Luiz");
            fail("Não era para adcionar Usuário - senha inválido");
        } catch (HumQueCaroException e) {
        }
        
        try {
            fachada.adicionaUsuario("luiz@gmail.com", "sen", "Luiz");
            fail("Não era para adcionar Usuário - senha inválido");
        } catch (HumQueCaroException e) {
        }
    }
}
