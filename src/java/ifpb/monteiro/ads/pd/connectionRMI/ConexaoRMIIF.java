package ifpb.monteiro.ads.pd.connectionRMI;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Luiz Antonio
 */
public interface ConexaoRMIIF extends Remote{
    
    Pedido buscaPedido(String codigo) throws HumQueCaroException, RemoteException;
    
    List<Pedido> getPedidos() throws HumQueCaroException, RemoteException;
}
