package ifpb.monteiro.ads.pd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.util.ArrayList;

public class ProdutoDAO extends DAO<Produto> {

    private ArrayList<Produto> produtos;

    public ProdutoDAO() {
    }

    @Override
    public void adiciona(Produto produto) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "INSERT INTO produtos (codigo_barras, nome, fabricante, valor) VALUES ('"
                    + produto.getCodigoBarras() + "', '" + produto.getNome()
                    + "', '" + produto.getFabricante() + "', '" + produto.getValor() + "' )");
            fecharBanco();
        } catch (SQLException e) {
            throw new HumQueCaroException("Erro no adiciona de Produto "
                    + e.getMessage());
        }
    }

    @Override
    public void remove(String codigoBarras) throws HumQueCaroException {
        Produto p = procura(codigoBarras);
        try {
            if (p != null) {
                abrirBanco();
                getStmt().execute(
                        "DELETE FROM produtos WHERE codigo_barras = '" + codigoBarras
                        + "' ");
                fecharBanco();
            } else {
                throw new HumQueCaroException("Produto não encontrado");
            }
        } catch (SQLException e) {
            throw new HumQueCaroException("Erro no remove de Produto "
                    + e.getMessage());
        }
    }

    @Override
    public void altera(Produto produto) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "UPDATE produtos SET codigo = '"
                    + produto.getCodigo() + "', codigo_barras = '"
                    + produto.getCodigoBarras() + "', nome ='" + produto.getNome()
                    + "', fabricante ='" + produto.getFabricante()
                    + "', valor ='" + produto.getValor()
                    + "' WHERE codigo_barras like '" + produto.getCodigoBarras() + "'");
            fecharBanco();
        } catch (SQLException e) {
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
                    "SELECT * FROM produtos WHERE codigo_barras = '" + codigo + "' ");
            if (rSet.next()) {
                produto = new Produto(rSet.getString("nome"),
                        rSet.getString("codigo_barras"), rSet.getString("fabricante"), rSet.getString("valor"));
                produto.setCodigo(rSet.getInt("codigo"));
            }
            fecharBanco();
            return produto;
        } catch (SQLException e) {
            throw new HumQueCaroException("Erro no procura de Produto "
                    + e.getMessage());
        }
    }

    @Override
    public ArrayList<Produto> getAll() {
        produtos = new ArrayList<>();
        try {
            abrirBanco();
            ResultSet rs;
            rs = getStmt().executeQuery("SELECT * FROM produtos");
            Produto prod;
            while (rs.next()) {
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo_barras");
                String fabricante = rs.getString("fabricante");
                String valor = rs.getString("valor");
                int codigo_produto = rs.getInt("codigo");
                prod = new Produto(nome, codigo, fabricante, valor);
                prod.setCodigo(codigo_produto);
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