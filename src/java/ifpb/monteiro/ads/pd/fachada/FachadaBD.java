package ifpb.monteiro.ads.pd.fachada;

import ifpb.monteiro.ads.pd.DAO.ClienteDAO;
import ifpb.monteiro.ads.pd.DAO.DAO;
import ifpb.monteiro.ads.pd.DAO.PedidoDAO;
import ifpb.monteiro.ads.pd.DAO.ProdutoDAO;
import ifpb.monteiro.ads.pd.DAO.UsuarioDAO;
import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;
import ifpb.monteiro.ads.pd.validacao.Validacao;
import java.util.List;

public class FachadaBD implements FachadaBancoIF {

    private DAO<Cliente> cliDAO;
    private DAO<Produto> pDAO;
    private DAO<Usuario> pUsuario;
    private DAO<Pedido> pedidoDAO;

    public FachadaBD() {
        cliDAO = new ClienteDAO();
        pDAO = new ProdutoDAO();
        pUsuario = new UsuarioDAO();
        pedidoDAO = new PedidoDAO();
    }

    @Override
    public void addUsuario(Usuario usuario) throws HumQueCaroException {
        pUsuario.adiciona(usuario);
    }

    @Override
    public void removeUsuario(String email) throws HumQueCaroException {
        pUsuario.remove(email);
    }

    @Override
    public Usuario buscaUsuario(String email) throws HumQueCaroException {
        return pUsuario.procura(email);
    }

    @Override
    public void alteraUsuario(Usuario usuario) throws HumQueCaroException {
        pUsuario.altera(usuario);
    }

    @Override
    public void addProduto(Produto produto) throws HumQueCaroException {
        pDAO.adiciona(produto);
    }

    @Override
    public void removeProduto(String codigoBarras) throws HumQueCaroException {
        pDAO.remove(codigoBarras);
    }

    @Override
    public Produto buscaProduto(String codigo) throws HumQueCaroException {
        return pDAO.procura(codigo);
    }

    @Override
    public void alteraProduto(Produto produto)
            throws HumQueCaroException {
        pDAO.altera(produto);
    }

    @Override
    public List<Produto> getProdutos() throws HumQueCaroException {
        return pDAO.getAll();
    }

    @Override
    public void addCliente(Cliente cliente) throws HumQueCaroException {
        cliDAO.adiciona(cliente);

    }

    @Override
    public void removeCliente(String telefone) throws HumQueCaroException {
        cliDAO.remove(telefone);
    }

    @Override
    public Cliente buscaCliente(String telefone) throws HumQueCaroException {
        Cliente c = cliDAO.procura(telefone);
        if (telefone == null || telefone.equals("")) {
            throw new HumQueCaroException("Campo telefone inv�lido");
        }
        if (c != null) {
            return c;
        }
        return null;
    }

    @Override
    public void alteraCliente(String telefone, String atributo, String novoValor)
            throws HumQueCaroException {
        Cliente c = cliDAO.procura(telefone);
        if (atributo == null || atributo.equals("") || novoValor == null
                || novoValor.equals("")) {
            throw new HumQueCaroException("Campo invalido");
        }
        if (!atributo.equals("Nome") && !atributo.equals("Telefone")) {
            throw new HumQueCaroException("Campo atributo invalido");
        }
        if (atributo.equals("Nome") && (novoValor != null || novoValor != (""))) {
            c.setNome(novoValor);
        }
        if (atributo.equals("Telefone")
                && (novoValor != null || novoValor != (""))
                && novoValor.length() == 11) {
            c.setTelefone(novoValor);
        }
        cliDAO.altera(c);

    }

    @Override
    public List<Cliente> getClientes() throws HumQueCaroException {
        return cliDAO.getAll();
    }

    @Override
    public void addPedidos(Pedido pedido) throws HumQueCaroException {
        pedidoDAO.adiciona(pedido);
    }

    @Override
    public void pedidoStatus(String codigo, String novoStatus) throws HumQueCaroException {
    }

    @Override
    public List<Pedido> getPedidos() throws HumQueCaroException {
        return pedidoDAO.getAll();
    }

    @Override
    public Pedido buscaPedido(String codigoPedido) throws HumQueCaroException {
        return pedidoDAO.procura(codigoPedido);
    }
}
