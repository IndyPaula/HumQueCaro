/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.DAO;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DVD
 */
public class PedidoDAO extends DAO<Pedido> {

    private List<Pedido> pedidos;

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
                String telefoneCliente = rs.getString("codigo_cliente");
                String codigoProduto = rs.getString("codigo_produto");
                String situacao = rs.getString("situacao");
                String codigo = rs.getString("codigo");
//                ped = new Pedido(telefoneCliente, codigoProduto, situacao);
//                ped.setCodigo(codigo);
//                ped.setSituacao(situacao);
//                if (!pedidos.contains(ped)) {
//                    pedidos.add(ped);
//                }
            }
            rs.close();
            fecharBanco();
            return pedidos;
        } catch (SQLException ex) {
        }
        return null;
    }
}
