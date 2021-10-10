package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface Election extends  Remote{


        public void Candidades() throws RemoteException;
        public String  result(String voteCod) throws RemoteException;
        public String vote(String voterHash,String cadidate) throws RemoteException;
        public ArrayList<String> listCandidates() throws RemoteException;

}
