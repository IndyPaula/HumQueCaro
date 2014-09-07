package ifpb.monteiro.ads.pd.fachadaIF;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.util.List;

public interface FachadaBancoIF {

    void addUsuario(Usuario usuario) throws HumQueCaroException;

    void removeUsuario(String email) throws HumQueCaroException;

    Usuario buscaUsuario(String email) throws HumQueCaroException;

    void alteraUsuario(Usuario usuario) throws HumQueCaroException;

    void addProduto(Produto produto) throws HumQueCaroException;

    void removeProduto(String codigoBarras) throws HumQueCaroException;

    Produto buscaProduto(String codigoBarras) throws HumQueCaroException;

    void alteraProduto(Produto produto) throws HumQueCaroException;

    List<Produto> getProdutos() throws HumQueCaroException;

    void addCliente(Cliente cliente) throws HumQueCaroException;

    void removeCliente(String telefone) throws HumQueCaroException;

    Cliente buscaCliente(String telefone) throws HumQueCaroException;

    void alteraCliente(String telefone, String atributo, String novoValor) throws HumQueCaroException;

    List<Cliente> getClientes() throws HumQueCaroException;

    void addPedidos(Pedido pedido) throws HumQueCaroException;

    void pedidoStatus(String codigo, String novoStatus) throws HumQueCaroException;

    List<Pedido> getPedidos() throws HumQueCaroException;
    
    Pedido buscaPedido(String codigoPedido) throws HumQueCaroException;
}
