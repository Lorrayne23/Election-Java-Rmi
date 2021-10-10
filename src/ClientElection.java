import Interface.Election;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ClientElection {





    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        String voteCod;
        int op ;
        Scanner keyboard = new Scanner(System.in);
        boolean voted = false;

        System.out.println("Type your name :");
        String name = keyboard.nextLine();
        Client client = new Client(name);
        Registry registry = LocateRegistry.getRegistry(1888);
        Election stub = (Election) registry.lookup("Election");



           try{
               do {
                   System.out.println("------------------");
                   System.out.println("       MENU        ");
                   System.out.println("1- CANDIDATE LIST ");
                   System.out.println("2- VOTE ");
                   System.out.println("3- CANDIDATE RESULT");
                   System.out.println("4- EXIT THE PROGRAM");
                   op = keyboard.nextInt();
                   System.out.println("------------------");



                   switch (op) {

                       case 1:

                               listCandidates(stub);
                               break;

                       case 2:

                           if(voted == false) {
                               System.out.println("------------------");
                               System.out.println("Enter the candidate  three numbers :");
                               voteCod = keyboard.next();
                               String response = stub.vote(client.getNameHash(), voteCod);
                               voted = true;
                               System.out.println(response);
                               System.out.println("------------------");
                           }else {
                               System.out.println("You already vote !");
                           }

                           break;
                       case 3:
                           System.out.println("------------------");
                           System.out.println("Enter the three numbers of a candidate to see his results in the election :");
                           voteCod = keyboard.next();
                           String result = stub.result(voteCod);
                           System.out.println("Number of votes : " + result);
                           System.out.println("------------------");
                           break;


                       case 4:
                           System.out.println("Exiting program...");
                           break;
                       default:
                           System.out.println("Please,enter an option from the MENU.");


                   }

               }while (op!=4);

       }catch (Exception e) {
               System.out.println("Reconnecting to server...");
               try {
                   Thread.sleep(30);
               } catch (InterruptedException ex) {
                   Thread.currentThread().interrupt();
                   new ClientElection();
               }
           }
       }


    public static void listCandidates(Election stub) {
        try {
            for (String candidate : stub.listCandidates())
                System.out.println(candidate);
        } catch (RemoteException e) {
            System.err.println(" Error listing candidates: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }







