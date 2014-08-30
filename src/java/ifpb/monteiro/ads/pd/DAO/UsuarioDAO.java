package ifpb.monteiro.ads.pd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

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
	public void remove(Usuario algo) throws HumQueCaroException {
		try {
			abrirBanco();
			Usuario userAux = procura(algo.getEmail());
			getStmt().executeUpdate("DELETE FROM usuarios WHERE codigo_usuario ='"+userAux.getCodigoUsuario()+"'");
			fecharBanco();
		} catch (Exception e) {
			throw new HumQueCaroException("- Erro ao remover Usuario -"+e.getMessage());
		}
		
	}

	@Override
	public void altera(Usuario algo) throws HumQueCaroException {
		// TODO Depois arrumar isso x.x

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
				pessoa = new Usuario(rs.getString("email"), rs.getString("senha"), rs.getString("nome"), rs.getInt("codigo_usuario"));
			}
			return pessoa;

		} catch (Exception e) {
			throw new HumQueCaroException(" Erro ao procurar uma Usuario - "
					+ e.getMessage());
		}
	}

}