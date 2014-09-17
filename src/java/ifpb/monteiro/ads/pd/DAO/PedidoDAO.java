/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.DAO;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorProduto;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorProdutoIF;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DVD
 */
public class PedidoDAO extends DAO<Pedido> {

    private List<Pedido> pedidos;
    private List<Produto> prodDePedido;

    public PedidoDAO() {
    }

    @Override
    public void adiciona(Pedido algo) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "INSERT INTO pedidos (telefone_cliente, situacao, valor) VALUES ('"
                    + algo.getTelefoneCliente() + "', '"
                    + algo.getSituacao() + "', '"
                    + algo.getValor()
                    + "' )");

            for (Produto produto : algo.getProdutos()) {
                getStmt().executeUpdate(
                        "INSERT INTO produtos_de_pedido (codigo_pedido, codigo_produto) VALUES ((select LAST_INSERT_ID()), '"
                        + produto.getCodigoBarras()
                        + "' )");
            }
            fecharBanco();
        } catch (Exception e) {
            throw new HumQueCaroException("Erro no adiciona de Pedido "
                    + e.getMessage());
        }
    }

    /**
     * Este método não precisa ser implementado, visto que ficou decidido que um
     * pedido NÃO PODE SER REMOVIDO, apenas alterada a sua situação.
     *
     * @param algo
     * @throws HumQueCaroException
     */
    @Override
    public void remove(String algo) throws HumQueCaroException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Este método deve ser implementado apenas para alterar a SITUAÇÃO do
     * pedido. Podendo ser "Entregue", "Cancelado" ou "Pendente".
     *
     * @param algo
     * @throws HumQueCaroException
     */
    @Override
    public void altera(Pedido algo) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "UPDATE pedidos SET situacao = '"
                    + algo.getSituacao() + "' WHERE codigo like '" + algo.getCodigo() + "'");
            fecharBanco();
        } catch (Exception e) {
            throw new HumQueCaroException("Erro no altera status do pedido "
                    + e.getMessage());
        }
    }

    @Override
    public Pedido procura(String codigo) throws HumQueCaroException {
        try {
            abrirBanco();
            ResultSet rs;
            Pedido pedido = null;
            rs = getStmt().executeQuery(
                    "SELECT * FROM pedidos WHERE telefone_cliente like '" + codigo + "'");
            if (rs.next()) {
                String telefoneCliente = rs.getString("telefone_cliente");
                String situacao = rs.getString("situacao");
                String codBanco = rs.getString("codigo");
                Float valor = rs.getFloat("valor");
                pedido = new Pedido(telefoneCliente, null, situacao, valor);
                pedido.setCodigo(codBanco);
                prodDePedido = produtosDePedido(pedido);
                pedido.setProdutos(prodDePedido);
            }
            fecharBanco();
            return pedido;
        } catch (SQLException e) {
            throw new HumQueCaroException("Erro no procura de Pedido "
                    + e.getMessage());
        }
    }

    /**
     * Método para carregar todos os pedidos da lista cadastrados no banco de
     * dados. São carregados apenas os pedidos que constarem como "pendente" em
     * sua situação. Pedidos cancelados ou entregues serão descartados desta
     * listagem.
     *
     * @return lista de pedidos do banco
     * @throws HumQueCaroException
     */
    @Override
    public List<Pedido> getAll() throws HumQueCaroException {
        pedidos = new ArrayList<>();
        try {
            abrirBanco();
            ResultSet rs;
            rs = getStmt().executeQuery("SELECT * FROM pedidos WHERE situacao like 'Pendente'");
            Pedido ped;
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String telefoneCliente = rs.getString("telefone_cliente");
                String situacao = rs.getString("situacao");
                float valor = rs.getFloat("valor");
                ped = new Pedido(telefoneCliente, null, situacao, valor);
                ped.setCodigo(codigo + ""); // TIPO DE CODIGO DE PRODUTO NAO É O MESMO NO BANCO E NO BEAN / VERIFICAR
                prodDePedido = produtosDePedido(ped);
                ped.setProdutos(prodDePedido);
                pedidos.add(ped);
            }
            rs.close();
            fecharBanco();
            return pedidos;
        } catch (SQLException ex) {
        }
        return null;
    }

    /**
     * Método privado para fazer a captura da lista de produtos adicionados em
     * um determinado pedido no banco de dados.. Este método é necessário pois
     * são duas tabelas separadas no banco e para não deixar tudo em um método
     * só, optei por dividir as consultas no banco.
     *
     * @param pedido cadastrado anteriormente no sistema
     * @return List<Produto> que corresponde a este pedido
     *
     */
    private List<Produto> produtosDePedido(Pedido pedido) {
        GerenciadorProdutoIF gProd = new GerenciadorProduto();
        prodDePedido = new ArrayList<>();
        Produto produto;
        try {
            abrirBanco();
            ResultSet rs;
            rs = getStmt().executeQuery("SELECT * FROM produtos_de_pedido WHERE codigo_pedido like '"
                    + pedido.getCodigo() + "'");
            while (rs.next()) {
                String codigo_produto = rs.getString("codigo_produto");
                produto = gProd.buscaProduto(codigo_produto);
                prodDePedido.add(produto);
            }
            return prodDePedido;
        } catch (SQLException | HumQueCaroException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
