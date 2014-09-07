package ifpb.monteiro.ads.pd.test;

import ifpb.monteiro.ads.pd.test.produto.TestAdicionaProduto;
import ifpb.monteiro.ads.pd.test.produto.TestAlteraProduto;
import ifpb.monteiro.ads.pd.test.produto.TestBuscaProduto;
import ifpb.monteiro.ads.pd.test.produto.TestRemoveProduto;
import ifpb.monteiro.ads.pd.test.usuario.TestAdcionaUsuario;
import ifpb.monteiro.ads.pd.test.usuario.TestAlteraUsuario;
import ifpb.monteiro.ads.pd.test.usuario.TestBuscaUsuario;
import ifpb.monteiro.ads.pd.test.usuario.TestRemoveusuario;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * Classe para rodar todos os testes do Usuario:
 * Adcionar, Alterar, Buscar e Remover! 
 * 
 * Agora esta classe está sobre meu poder. Um abraço!
 * Att, Luiz Antonio
 *
 * @author Luiz Antonio
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestAdcionaUsuario.class,
    TestAlteraUsuario.class,
    TestBuscaUsuario.class,
    TestRemoveusuario.class,
    TestAdicionaProduto.class,
    TestAlteraProduto.class,
    TestBuscaProduto.class,
    TestRemoveProduto.class
})
public class AllTest {
}
