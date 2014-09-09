package ifpb.monteiro.ads.pd.test.pedido;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 * Classe para testes do Usuario:
 * Adicionar! 
 * 
 * Agora esta classe está sobre meu poder. Um abraço!
 * Att, Luiz Antonio
 *
 * @author Luiz Antonio
 */
public class TestAdcionaPedido {

    private Fachada fachada;
    List<Produto> produtos = null;
    List<Produto> produtosVazio = null;

    @Before
    public void setUp() {
        fachada = new Fachada();
        try {
//            fachada.adicionaProduto("Bis", "01", "Nestle", "0.50");
//            fachada.adicionaProduto("Biscoito", "02", "CremeCrack", "3.00");
//            produtos = fachada.getProdutos();
//            fachada.addPedido("08788888888", produtos);
            Pedido pedido = fachada.buscaPedido("1");
            produtos = pedido.getProdutos();
            produtosVazio = new  ArrayList<>();
        } catch (HumQueCaroException e) {
            fail("Acusou erro no Adiciona Pedido: " + e.getMessage());
        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testsUsuario() {
//        try {
//            Pedido pedido = fachada.buscaPedido("1");
//            assertEquals(1, pedido.getProdutos());
//            fail("Numero de produtos inválidos");
//        } catch (HumQueCaroException e) {
//            
//        }
//        
//        try {
//            Pedido pedido = fachada.buscaPedido("1");
//            assertEquals(7, pedido.getProdutos());
//            fail("Nomeros de produto inválido");
//        } catch (HumQueCaroException e) {
//            
//        }
        //Valores nulos ou vazios
        try {
            fachada.addPedido(null, produtos);
            fail("Campo telefone do cliente é nulo");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.addPedido("", produtos);
            fail("Campo telefone do cliente esta vazio");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.addPedido("08708766665555", produtos);
            fail("Campo produtos está vazio");
        } catch (HumQueCaroException e) {
        }

//        //Entrada para telefones inválido
        try {
            fachada.addPedido("oioirutiuty", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }
        try {
            fachada.addPedido("09876543213576565", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.addPedido("$#%$¨&*gfh", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.addPedido("087888888888", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.addPedido("087544teste", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.addPedido("teste857876", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.addPedido("7654", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }
        try {
            fachada.addPedido("#$HGHGF", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }

        //Entrada para produtos inválidos
        try {
            fachada.addPedido("poioiuuytr()*&*", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.addPedido("0", produtos);
            fail("Campo telefone do cliente é inválido");
        } catch (HumQueCaroException e) {
        }

        try {
            fachada.addPedido("08766665555", produtosVazio);
            fail("Campo produtos é inválido");
        } catch (HumQueCaroException e) {
        }
        
//        try {
//            fachada.addPedido("08766665555", produtosVazio = null);
//            fail("Campo produtos é inválido");
//        } catch (HumQueCaroException e) {
//        }
        
    }
}
