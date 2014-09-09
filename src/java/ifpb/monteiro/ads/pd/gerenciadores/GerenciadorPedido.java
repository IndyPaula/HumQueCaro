/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;
import ifpb.monteiro.ads.pd.validacao.Validacao;
import java.util.List;

/**
 *
 * @author DVD
 */
public class GerenciadorPedido implements GerenciadorPedidoIF {
    
    private FachadaBancoIF pedidoDAO;
    private GerenciadorLoginIF gLogin;
    
    public GerenciadorPedido() {
        pedidoDAO = new FachadaBD();
        gLogin = GerenciadorLogin.getInstance();
    }
    
    @Override
    public void addPedido(String telefoneCliente, List<Produto> produtos) throws HumQueCaroException {
        gLogin.logado();
        float valorPedido = 0.0F;
        for (Produto produto : produtos) {
            valorPedido = valorPedido + Validacao.stringToFloat(produto.getValor());
        }
        pedidoDAO.addPedidos(new Pedido(telefoneCliente, produtos, "Pendente", valorPedido));
    }
    
    @Override
    public void setStatusPedido(String codigo, String novoStatus) throws HumQueCaroException {
        gLogin.logado();
        Validacao.validaEntrada(codigo, "Campo codigo inválido");
        Validacao.validaEntrada(novoStatus, "Novo status inválido");
        Validacao.validaSituacao(novoStatus," Situação inválida");
        
        Pedido pedido = pedidoDAO.buscaPedido(codigo);
        pedido.setSituacao(novoStatus);
        pedidoDAO.alteraStatusPedido(pedido);
    }
    
    @Override
    public List<Pedido> getPedidos() throws HumQueCaroException {
        return pedidoDAO.getPedidos();
    }

    @Override
    public Pedido buscaPedido(String codigoPedido) throws HumQueCaroException {
        return pedidoDAO.buscaPedido(codigoPedido);
    }
}
