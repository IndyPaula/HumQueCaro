package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.util.List;

public interface GerenciadorProdutoIF {
	
	public void adicionaProduto(String nomeProduto, String codigo,
			String fabricante, String valor) throws HumQueCaroException;
	
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException;
	
	public void removeProduto(String codigo) throws HumQueCaroException;
	
	public Produto buscaProduto(String codigo) throws HumQueCaroException;
        
        public List<Produto> getProdutos() throws HumQueCaroException;
}
