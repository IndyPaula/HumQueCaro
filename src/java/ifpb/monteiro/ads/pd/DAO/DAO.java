package ifpb.monteiro.ads.pd.DAO;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.persistenciaSQL.PersistenciaSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO<T> {
	private Connection conexao;
	private Statement stmt;

	public void abrirBanco() throws SQLException {
		conexao = PersistenciaSQL.conectar();
		stmt = conexao.createStatement();
	}

	public void fecharBanco() throws SQLException {
		stmt.close();
		conexao.close();
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public abstract void adiciona(T algo) throws HumQueCaroException;

	public abstract void remove(T algo) throws HumQueCaroException;

	public abstract void altera(T algo) throws HumQueCaroException;

	public abstract T procura(String algo) throws HumQueCaroException;

}
