package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;
import java.util.List;

public class GerenciadorCliente implements GerenciadorClienteIF {

    private FachadaBancoIF cliDAO;

    public GerenciadorCliente() {
        cliDAO = new FachadaBD();
    }

    @Override
    public void adicionaCliente(String nome, String telefone)
            throws HumQueCaroException {
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
        cliDAO.alteraCliente(telefone, atributo, novoValor);
    }

    @Override
    public void removeCliente(String telefone) throws HumQueCaroException {
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
        if (cliente != null) {
            return cliente;
        } else {
            throw new HumQueCaroException("Cliente na� cadastrado");
        }
    }

    @Override
    public List<Cliente> getClientes() throws HumQueCaroException {
        return cliDAO.getClientes();
    }
}
