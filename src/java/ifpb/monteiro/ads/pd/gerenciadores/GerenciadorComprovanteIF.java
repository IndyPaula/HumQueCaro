/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

/**
 *
 * @author DVD
 */
public interface GerenciadorComprovanteIF {

    public void comprovanteSms(Pedido pedido) throws HumQueCaroException;

    public void gerarComprovante(String idCliente) throws HumQueCaroException;
}
