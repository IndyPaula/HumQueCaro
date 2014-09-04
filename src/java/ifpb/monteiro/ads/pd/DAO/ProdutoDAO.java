package ifpb.monteiro.ads.pd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.util.ArrayList;

public class ProdutoDAO extends DAO<Produto> {

    public ArrayList<Produto> produtos = new ArrayList<Produto>();

    @Override
    public void adiciona(Produto produto) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "INSERT INTO produtos (codigo, nome, fabricante, valor) VALUES ('"
                    + produto.getCodigo() + "', '" + produto.getNome()
                    + "', '" + produto.getFabricante() + "', '" + produto.getValor() + "' )");
            fecharBanco();
        } catch (Exception e) {
            throw new HumQueCaroException("Erro no adiciona de Produto "
                    + e.getMessage());
        }
    }

    @Override
    public void remove(Produto produto) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().execute(
                    "DELETE FROM produtos WHERE codigo = '" + produto.getCodigo()
                    + "' ");
            fecharBanco();
        } catch (Exception e) {
            throw new HumQueCaroException("Erro no remove de Produto "
                    + e.getMessage());
        }
    }

    @Override
    public void altera(Produto produto) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "UPDATE produtos SET codigo_produtos = '"
                    + produto.getCodigoProduto() + "', codigo = '"
                    + produto.getCodigo() + "', nome ='" + produto.getNome()
                    + "', fabricante ='" + produto.getFabricante()
                    + "', valor ='" + produto.getValor()
                    + "' WHERE codigo like '" + produto.getCodigo() + "'");
            fecharBanco();
        } catch (Exception e) {
            throw new HumQueCaroException("Erro no altera de Produto "
                    + e.getMessage());
        }
    }

    @Override
    public Produto procura(String codigo) throws HumQueCaroException {
        try {
            Produto produto = null;
            abrirBanco();
            ResultSet rSet = getStmt().executeQuery(
                    "SELECT * FROM produtos WHERE codigo = '" + codigo + "' ");
            if (rSet.next()) {
                produto = new Produto(rSet.getString("nome"),
                        rSet.getString("codigo"), rSet.getString("fabricante"), rSet.getString("valor"));
                produto.setCodigoProduto(rSet.getInt("codigo_produtos"));
            }
            fecharBanco();
            return produto;
        } catch (SQLException e) {
            throw new HumQueCaroException("Erro no procura de Produto "
                    + e.getMessage());
        }
    }

    public ArrayList<Produto> carregaProdutos() throws HumQueCaroException {
        try {
            abrirBanco();
            ResultSet rs;
            rs = getStmt().executeQuery("SELECT * FROM produtos");
            Produto prod;
            while (rs.next()) {
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                String fabricante = rs.getString("fabricante");
                String valor = rs.getString("valor");
                int codigo_produto = rs.getInt("codigo_produtos");
                prod = new Produto(nome, codigo, fabricante, valor);
                prod.setCodigoProduto(codigo_produto);
                if (!produtos.contains(prod)) {
                    produtos.add(prod);
                }
            }
            rs.close();
            fecharBanco();
            return produtos;
        } catch (SQLException ex) {
        }
        return null;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}