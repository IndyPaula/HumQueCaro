/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;
import java.util.List;

/**
 *
 * @author DVD
 */
public class GerenciadorPedido implements GerenciadorPedidoIF {
    
    private FachadaBancoIF pedidoDAO;
    
    public GerenciadorPedido() {
        pedidoDAO = new FachadaBD();
    }
    
    @Override
    public void addPedido(String telefoneCliente, String codigoProduto) throws HumQueCaroException {
        pedidoDAO.addPedidos(new Pedido(telefoneCliente, codigoProduto, "Pendente"));
    }
    
    @Override
    public void setStatusPedido(String codigo, String novoStatus) throws HumQueCaroException {
        pedidoDAO.pedidoStatus(codigo, novoStatus);
    }
    
    @Override
    public List<Pedido> getPedidos() throws HumQueCaroException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido buscaPedido(String codigoPedido) throws HumQueCaroException {
        return pedidoDAO.buscaPedido(codigoPedido);
    }
}
