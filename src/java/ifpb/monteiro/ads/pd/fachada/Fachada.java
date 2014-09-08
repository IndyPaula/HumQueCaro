package ifpb.monteiro.ads.pd.fachada;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorCliente;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorClienteIF;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorLogin;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorLoginIF;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorPedido;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorPedidoIF;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorProduto;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorProdutoIF;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorUsuario;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorUsuarioIF;
import java.util.List;

public class Fachada implements FachadaIF {

    GerenciadorProdutoIF gProduto = new GerenciadorProduto();
    GerenciadorUsuarioIF gUsuario = new GerenciadorUsuario();
    GerenciadorClienteIF gCliente = new GerenciadorCliente();
    GerenciadorPedidoIF gPedido = new GerenciadorPedido();
    GerenciadorLoginIF gLogin = new GerenciadorLogin();

    @Override
    public void adicionaUsuario(String email, String senha, String nome)
            throws HumQueCaroException {
        gUsuario.adicionaUsuario(email, senha, nome);
    }

    @Override
    public void alteraUsuario(String email, String atributo, String novoValor)
            throws HumQueCaroException {
        gUsuario.alteraUsuario(email, atributo, novoValor);
    }

    @Override
    public void removeUsuario(String email, String senha)
            throws HumQueCaroException {
        gUsuario.removeUsuario(email, senha);
    }

    @Override
    public Usuario buscaUsuario(String email) throws HumQueCaroException {
        return gUsuario.buscaUsuario(email);
    }

    @Override
    public void adicionaProduto(String nomeProduto, String codigo,
            String fabricante, String valor) throws HumQueCaroException {
        gProduto.adicionaProduto(nomeProduto, codigo, fabricante, valor);
    }

    @Override
    public void alteraProduto(String codigo, String atributo, String novoValor)
            throws HumQueCaroException {
        gProduto.alteraProduto(codigo, atributo, novoValor);
    }

    @Override
    public void removeProduto(String codigo) throws HumQueCaroException {
        gProduto.removeProduto(codigo);
    }

    @Override
    public Produto buscaProduto(String codigo) throws HumQueCaroException {
        return gProduto.buscaProduto(codigo);
    }

    @Override
    public List<Produto> getProdutos() throws HumQueCaroException {
        return gProduto.getProdutos();
    }

    @Override
    public void adicionaCliente(String nome, String telefone)
            throws HumQueCaroException {
        gCliente.adicionaCliente(nome, telefone);
    }

    @Override
    public void alteraCliente(String telefone, String atributo, String novoValor)
            throws HumQueCaroException {
        gCliente.alteraCliente(telefone, atributo, novoValor);

    }

    @Override
    public void removeCliente(String telefone) throws HumQueCaroException {
        gCliente.removeCliente(telefone);

    }

    @Override
    public Cliente buscaCliente(String telefone) throws HumQueCaroException {
        return gCliente.buscaCliente(telefone);
    }

    @Override
    public List<Cliente> getClientes() throws HumQueCaroException {
        return gCliente.getClientes();
    }

    @Override
    public void addPedido(String telefoneCliente, List<Produto> produtos) throws HumQueCaroException {
        gPedido.addPedido(telefoneCliente, produtos);
        
    }

    @Override
    public void setStatusPedido(String codigo, String novoStatus) throws HumQueCaroException {
        gPedido.setStatusPedido(codigo, novoStatus);
    }

    @Override
    public List<Pedido> getPedidos() throws HumQueCaroException {
        return gPedido.getPedidos();
    }

    @Override
    public Pedido buscaPedido(String codigo) throws HumQueCaroException {
        return gPedido.buscaPedido(codigo);
    }

    @Override
    public void fazerLogin(String email, String senha) throws HumQueCaroException {
        gLogin.fazerLogin(email, senha);
    }

    @Override
    public boolean isLogged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disconnect() throws HumQueCaroException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
