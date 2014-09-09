package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Login;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.enumerations.Dados;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;
import ifpb.monteiro.ads.pd.validacao.Validacao;
import java.util.List;

public class GerenciadorProduto implements GerenciadorProdutoIF {

    private FachadaBancoIF pDAO;
    private GerenciadorLoginIF gLogin;

    public GerenciadorProduto() {
        pDAO = new FachadaBD();
        gLogin = GerenciadorLogin.getInstance();
    }

    @Override
    public void adicionaProduto(String nomeProduto, String codigo,
            String fabricante, String valor) throws HumQueCaroException {
        gLogin.logado();
        Validacao.validaEntrada(nomeProduto, "Campo nome do produto invalido");
        Validacao.validaEntrada(codigo, "Campo codigo invalido");
        Validacao.validaEntrada(fabricante, "Campo fabricante invalido");
        Validacao.validaEntrada(valor, "Campo valor invalido");
            try {
                if (pDAO.buscaProduto(codigo) == null) {
                    pDAO.addProduto(new Produto(nomeProduto, codigo, fabricante, valor));
                } else {
                    throw new HumQueCaroException("Produto já cadastrado");
                }
            } catch (HumQueCaroException e) {
                throw new HumQueCaroException(e.getMessage());
            }
        }

    @Override
    public void alteraProduto(String codigo, String atributo, String novoValor)
            throws HumQueCaroException {
        gLogin.logado();
        Validacao.validaEntrada(codigo, "Campo código inválido");
        Validacao.validaEntrada(atributo, "Campo atributo inválido");
        Validacao.validaEntrada(novoValor, "Campo novoValor inválido");
        Produto produto = pDAO.buscaProduto(codigo);
        if (Dados.NOME.getNome().equals(atributo)) {
            produto.setNome(novoValor);
        } else if (Dados.FABRICANTE.getNome().equals(atributo)) {
            produto.setFabricante(novoValor);
        } else if (Dados.VALOR.getNome().equals(atributo)) {
            produto.setValor(novoValor);
        } else {
            throw new HumQueCaroException("Campo atributo invalido");
        }
        pDAO.alteraProduto(produto);
    }

    @Override
    public void removeProduto(String codigo) throws HumQueCaroException {
        gLogin.logado();
        buscaProduto(codigo);
        pDAO.removeProduto(codigo);
    }

    @Override
    public Produto buscaProduto(String codigo) throws HumQueCaroException {
        Produto produto = pDAO.buscaProduto(codigo);
        if (produto == null) {
            throw new HumQueCaroException("Produto não cadastrado");
        }
        return produto;
    }

    @Override
    public List<Produto> getProdutos() throws HumQueCaroException {
        return pDAO.getProdutos();
    }
}
