package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfazRMI extends Remote{
	
    String getTiempo(String nombreciudad) throws RemoteException ;
    
}
