package ifpb.monteiro.ads.pd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public class ProdutoDAO extends DAO<Produto> {

	@Override
	public void adiciona(Produto produto) throws HumQueCaroException {
		try {
			abrirBanco();
			getStmt().executeUpdate(
					"INSERT INTO produtos (codigo, nome, fabricante) VALUES ('"
							+ produto.getCodigo() + "', '" + produto.getNome()
							+ "', '" + produto.getFabricante() + "' )");
			fecharBanco();
		} catch (Exception e) {
			throw new HumQueCaroException("Erro no adciona de Produto "
					+ e.getMessage());
		}
	}

	@Override
	public void remove(Produto produto) throws HumQueCaroException {
		try {
			procura(produto.getCodigo());
			abrirBanco();
			getStmt().execute(
					"DELETE FROM produtos WHERE codigo = '" + produto.getCodigo()
							+ "' ");
			fecharBanco();
		} catch (HumQueCaroException e) {
			throw new HumQueCaroException(e.getMessage());
		} catch (Exception e) {
			throw new HumQueCaroException("Erro no remove de Produto "
					+ e.getMessage());
		}
	}

	@Override
	public void altera(Produto produto) throws HumQueCaroException {
		try {
			abrirBanco();
			getStmt().executeUpdate(
					"UPDATE produtos SET codigo_produtos = '"
							+ produto.getCodigoProduto() + "', codigo = '"
							+ produto.getCodigo() + "', nome ='" + produto.getNome()
							+ "', fabricante ='" + produto.getFabricante()
							+ "' WHERE codigo like '" + produto.getCodigo() + "'");
			fecharBanco();
		} catch (Exception e) {
			throw new HumQueCaroException("Erro no altera de Produto "
					+ e.getMessage());
		}
	}

	@Override
	public Produto procura(String codigo) throws HumQueCaroException {
		try {
			Produto produto = null;
			abrirBanco();
			ResultSet rSet = getStmt().executeQuery(
					"SELECT * FROM produtos WHERE codigo = '" + codigo + "' ");
			if (rSet.next()) {
				produto = new Produto(rSet.getString("nome"),
						rSet.getString("codigo"), rSet.getString("fabricante"));
				produto.setCodigoProduto(rSet.getInt("codigo_produtos"));
			} else {
				throw new HumQueCaroException(
						"Campo codigo de identificacao invalido");
			}
			fecharBanco();
			return produto;
		} catch (SQLException e) {
			throw new HumQueCaroException("Erro no procura de Produto "
					+ e.getMessage());
		}
	}

}
