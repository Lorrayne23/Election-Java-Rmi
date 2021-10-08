package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Election extends  Remote{

        public void Candidades() throws RemoteException;
        public void result() throws RemoteException;
        public Boolean vote(String voter,String cadidate);


}
