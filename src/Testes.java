import java.rmi.RemoteException;

public class Testes {
    public static void main(String[] args) throws RemoteException {
        Client cliente1 = new Client("Juana");
        System.out.println(cliente1.getNameHash());

        ElectionServant teste1 = new ElectionServant();
        teste1.Candidades();
        teste1.listCandidates();



    }
}
