package ifpb.monteiro.ads.pd.connectionRMI;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Luiz Antonio
 */
public class RMIServidor extends UnicastRemoteObject implements ConexaoRMIIF{
    
    FachadaIF fachadaIF = new Fachada();

    public RMIServidor() throws RemoteException{
    }
    
    public static void main(String[] args) throws Exception {
        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
        
        RMIServidor servidor = new RMIServidor();
        
        Naming.rebind("//localhost/RMIServidor", servidor);
    }
    
    @Override
    public Pedido buscaPedido(String codigo) throws HumQueCaroException {
        return fachadaIF.buscaPedido(codigo);
    }

    @Override
    public List<Pedido> getPedidos() throws HumQueCaroException {
        return fachadaIF.getPedidos();
    }
    
    
}
