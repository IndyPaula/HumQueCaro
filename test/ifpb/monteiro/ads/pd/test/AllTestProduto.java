
import ifpb.monteiro.ads.pd.test.produto.TestAdicionaProduto;
import ifpb.monteiro.ads.pd.test.produto.TestAlteraProduto;
import ifpb.monteiro.ads.pd.test.produto.TestBuscaProduto;
import ifpb.monteiro.ads.pd.test.produto.TestRemoveProduto;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * Classe para rodar todos os testes do Usuario:
 * Adcionar, Alterar, Buscar e Remover! 
 * 
 * @author Deivid Azevedo
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestAdicionaProduto.class,
    TestAlteraProduto.class,
    TestBuscaProduto.class,
    TestRemoveProduto.class
})
public class AllTestProduto {
}