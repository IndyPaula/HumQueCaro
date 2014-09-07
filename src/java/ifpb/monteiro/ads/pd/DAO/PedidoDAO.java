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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pedido procura(String algo) throws HumQueCaroException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO Deivid, o consrutor de pedidos agora mudou. Agora recebe um List<Produto>.
    //Veja essa questão, por favor.
    @Override
    public List<Pedido> getAll() throws HumQueCaroException {
        pedidos = new ArrayList<>();
        try {
            abrirBanco();
            ResultSet rs;
            rs = getStmt().executeQuery("SELECT * FROM pedidos");
            Pedido ped;
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String telefoneCliente = rs.getString("telefone_cliente");
                String situacao = rs.getString("situacao");
                ped = new Pedido(telefoneCliente, null, situacao);
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
