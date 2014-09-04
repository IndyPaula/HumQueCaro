/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.util.List;

/**
 *
 * @author DVD
 */
public interface GerenciadorPedidoIF {

    public void addPedido(String telefoneCliente, String codigoProduto) throws HumQueCaroException;

    public void setStatusPedido(String codigo, String novoStatus) throws HumQueCaroException;

    public List<Pedido> getPedidos() throws HumQueCaroException;
    
    public  Pedido buscaPedido(String codigoPedido) throws HumQueCaroException;
}
