import Interface.Election;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class ElectionServer implements Election {

    Map<String,Integer> candidates  = new HashMap<String,Integer>();
    List<CandidatesClass> candidatesClasses = new LinkedList<>();
    Map<String, Boolean> codeClient = new HashMap<String, Boolean>();

    public ElectionServer(){

    }

    @Override
    public void Candidades() throws RemoteException {
        try{
            File fileCandidates = new File("src/File/senadores.csv");
            BufferedReader bf = new BufferedReader(new FileReader(fileCandidates));
            String line;
            bf.readLine();
            while ((line = bf.readLine())!= null){
                String[] split = line.split(";");
                String candidateCode = split[0];
                String candidateName = split[1];
                String  candidateEntourage = split[2];
                CandidatesClass candidates1 = new CandidatesClass(candidateCode,candidateName,candidateEntourage);
                candidatesClasses.add(candidates1);
                if(!candidates.containsKey(split[0])){
                    candidates.put(split[0],0);

                }




            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public String result(String candidate) throws RemoteException {
        if(!candidates.containsKey(candidate)){
            return "Invalid code , candidate does not exist ";
        }

        return candidates.get(candidate).toString();
    }

    @Override
    public  String vote(String voterHash, String candidate) throws java.rmi.RemoteException {
        String answer;
        if (!codeClient.containsKey(voterHash)) {
            if (candidates.containsKey(candidate)) {
                Integer oldValue = candidates.get(candidate);
                codeClient.put(candidate, true);
                candidates.put(candidate, oldValue + 1);
                answer = "Vote was computed !";
            } else
                answer = "Candidate does not exist !";
        } else {
            answer = "You can only vote once ! ";
        }
        return answer;
    }

    @Override
    public ArrayList<String> listCandidates() throws RemoteException {
        ArrayList<String> names = new ArrayList<>();
        for (CandidatesClass candidate : candidatesClasses) {
            names.add(candidate.getCandidateName().concat("| Number:" + candidate.getCandidateCod()+"|"+ "Entourage: " + candidate.getCandidateEntourage()));
        }
        return names;

    }


    public static void main(String[] args) {
         try{
             ElectionServer obj = new ElectionServer();
             Election stub = (Election) UnicastRemoteObject.exportObject(obj, 0);
             Registry registry = LocateRegistry.createRegistry(1888);
             registry.rebind("Election", stub);
             stub.Candidades();
         }catch (Exception e) {
             System.out.println(e);
         }

         System.out.println("Running server");

    }
}
