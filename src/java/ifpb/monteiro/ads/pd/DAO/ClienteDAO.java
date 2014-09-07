package ifpb.monteiro.ads.pd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO<Cliente> {

    private List<Cliente> clientes;

    public ClienteDAO() {
    }

    @Override
    public void adiciona(Cliente cli) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "INSERT INTO clientes (nome, telefone) " + "VALUES('"
                    + cli.getNome() + "','" + cli.getTelefone() + "')");
            fecharBanco();
        } catch (SQLException e) {
            throw new HumQueCaroException("Cliente n�o adicionado"
                    + e.getMessage());
        }

    }

    @Override
    public void remove(String telefone) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "DELETE FROM clientes WHERE telefone like '"
                    + telefone + "'");
            fecharBanco();
        } catch (SQLException e) {
            throw new HumQueCaroException("Cliente n�o removido"
                    + e.getMessage());
        }
    }

    @Override
    public void altera(Cliente cli) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "UPDATE clientes SET nome = '" + cli.getNome()
                    + "', telefone = '" + cli.getTelefone()
                    + "', codigo ='" + cli.getCodigo()
                    + "' WHERE codigo like '" + cli.getCodigo()
                    + "'");
            fecharBanco();
        } catch (SQLException e) {
            throw new HumQueCaroException("Cliente n�o alterado"
                    + e.getMessage());
        }

    }

    @Override
    public Cliente procura(String telefone) throws HumQueCaroException {
        try {
            abrirBanco();
            ResultSet rs;
            Cliente cli = null;
            rs = getStmt().executeQuery(
                    "SELECT * FROM clientes WHERE telefone like '" + telefone
                    + "'");
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String fone = rs.getString("telefone");
                String nome = rs.getString("nome");
                cli = new Cliente(nome, fone);
                cli.setCodigo(codigo);
            }
            fecharBanco();
            return cli;
        } catch (SQLException e) {
            throw new HumQueCaroException("Cliente n�o encontrado"
                    + e.getMessage());
        }
    }

    @Override
    public List<Cliente> getAll() throws HumQueCaroException {
        clientes = new ArrayList<>();
        try {
            abrirBanco();
            ResultSet rs;
            rs = getStmt().executeQuery("SELECT * FROM clientes");
            Cliente cliente;
            while (rs.next()) {
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String codigo = rs.getString("codigo");
                cliente = new Cliente(nome, telefone);
                cliente.setCodigo(codigo);
                if (!clientes.contains(cliente)) {
                    clientes.add(cliente);
                }
            }
            rs.close();
            fecharBanco();
            return clientes;
        } catch (SQLException ex) {
        }
        return null;
    }
}
