package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;
import java.util.List;

public class GerenciadorCliente implements GerenciadorClienteIF {

    private FachadaBancoIF cliDAO;
    private GerenciadorLoginIF gLogin;

    public GerenciadorCliente() {
        cliDAO = new FachadaBD();
        gLogin = GerenciadorLogin.getInstance();
    }

    @Override
    public void adicionaCliente(String nome, String telefone)
            throws HumQueCaroException {
        gLogin.logado();
        if (cliDAO.buscaCliente(telefone) == null
                && verificaAtributos(nome, telefone)) {
            cliDAO.addCliente(new Cliente(nome, telefone));
        } else {
            throw new HumQueCaroException("Cliente j� cadastrado");
        }
    }

    public boolean verificaAtributos(String nome, String telefone)
            throws HumQueCaroException {
        if (nome == null || nome.equals("")) {
            throw new HumQueCaroException("Campo nome do cliente inv�lido");
        }
        if (telefone == null || telefone.equals("") || telefone.length() != 11) {
            throw new HumQueCaroException("Campo telefone inv�lido");
        }
        return true;

    }

    @Override
    public void alteraCliente(String telefone, String atributo, String novoValor)
            throws HumQueCaroException {
        gLogin.logado();
        Cliente cliente = cliDAO.buscaCliente(telefone);
        if(cliente == null) {
            throw new HumQueCaroException("Cliente não existe");
        }
        if (atributo == null || atributo.equals("") || novoValor == null
                || novoValor.equals("")) {
            throw new HumQueCaroException("Campo invalido");
        }
        if (!atributo.equals("Nome") && !atributo.equals("Telefone")) {
            throw new HumQueCaroException("Campo atributo invalido");
        }
        if (atributo.equals("Nome") && (novoValor != null || novoValor != (""))) {
            cliente.setNome(novoValor);
        }
        if (atributo.equals("Telefone")
                && (novoValor != null || novoValor != (""))
                && novoValor.length() == 11) {
            cliente.setTelefone(novoValor);
        }
        cliDAO.alteraCliente(cliente);
    }

    @Override
    public void removeCliente(String telefone) throws HumQueCaroException {
        gLogin.logado();
        if (telefone == null || telefone.equals("")) {
            throw new HumQueCaroException("Campo telefone inv�lido");
        }
        if (buscaCliente(telefone) != null) {
            cliDAO.removeCliente(telefone);
        } else {
            throw new HumQueCaroException("Cliente n�o cadastrado");
        }
    }

    @Override
    public Cliente buscaCliente(String telefone) throws HumQueCaroException {
        Cliente cliente = cliDAO.buscaCliente(telefone);
        if (cliente == null) {
            throw new HumQueCaroException("Cliente na� cadastrado");
        }
        return cliente;
    }

    @Override
    public List<Cliente> getClientes() throws HumQueCaroException {
        return cliDAO.getClientes();
    }
}
