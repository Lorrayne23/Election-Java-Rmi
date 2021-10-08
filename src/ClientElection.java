import Interface.Election;

import java.rmi.RemoteException;
import java.util.Scanner;
public class ClientElection {
    public static void main(String[] args) throws RemoteException {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Type your name :\n"+">");
        String name = keyboard.nextLine();
        Client client = new Client(name);

        System.out.println("MENU");
        System.out.println("\n- List Candidates\n");
        System.out.println("\n- Vote \n");
        System.out.println("\n - Candidate Results");
        int op = keyboard.nextInt();

        switch (op){
            case 1:
                ElectionServant electionServant  = new ElectionServant();
                electionServant.Candidades();
                electionServant.listCandidates();
            case 2 :

            case 3 :

        }
    }
}
