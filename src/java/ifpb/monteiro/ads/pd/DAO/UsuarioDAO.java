package ifpb.monteiro.ads.pd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.util.List;

public class UsuarioDAO extends DAO<Usuario> {

    @Override
    public void adiciona(Usuario algo) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "INSERT INTO usuarios (email, nome, senha) " + "VALUES('"
                    + algo.getEmail() + "','" + algo.getNome() + "','"
                    + algo.getSenha() + "')");
            fecharBanco();
        } catch (SQLException e) {
            throw new HumQueCaroException("Erro ao adicionar um usuario - "
                    + e.getMessage());
        }

    }

    @Override
    public void remove(String email) throws HumQueCaroException {
        try {
            abrirBanco();
            Usuario userAux = procura(email);
            getStmt().executeUpdate("DELETE FROM usuarios WHERE codigo ='" + userAux.getCodigoUsuario() + "'");
            fecharBanco();
        } catch (Exception e) {
            throw new HumQueCaroException("- Erro ao remover Usuario -" + e.getMessage());
        }

    }

    @Override
    public void altera(Usuario algo) throws HumQueCaroException {
        try {
            abrirBanco();
            getStmt().executeUpdate(
                    "UPDATE usuarios SET codigo = '"
                    + algo.getCodigoUsuario() + "', email = '"
                    + algo.getEmail() + "', nome ='" + algo.getNome()
                    + "', senha ='" + algo.getSenha()
                    + "' WHERE codigo like '" + algo.getCodigoUsuario() + "'");
            fecharBanco();
        } catch (Exception e) {
            throw new HumQueCaroException("Erro no altera de Produto "
                    + e.getMessage());
        }

    }

    @Override
    public Usuario procura(String algo) throws HumQueCaroException {
        try {
            abrirBanco();
            Usuario pessoa = null;
            ResultSet rs;
            rs = getStmt().executeQuery(
                    "SELECT * FROM usuarios WHERE usuarios.email like '"
                    + algo + "'");
            while (rs.next()) {
                pessoa = new Usuario(rs.getString("email"), rs.getString("senha"), rs.getString("nome"), rs.getInt("codigo"));
            }
            return pessoa;

        } catch (Exception e) {
            throw new HumQueCaroException(" Erro ao procurar um Usuario - "
                    + e.getMessage());
        }
    }

    @Override
    public List<Usuario> getAll() throws HumQueCaroException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
