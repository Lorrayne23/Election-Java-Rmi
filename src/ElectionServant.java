import Interface.Election;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public  class ElectionServant implements Election {
    public static final String FILE_NAME = "./file/senadores.csv";
    Map<String,Integer> candidates  = new HashMap<String,Integer>();
    List<CandidatesClass> candidatesClasses = new LinkedList<>();

    public ElectionServant(){
        super();
    }

    @Override
    public void Candidades() throws RemoteException {

        try{
            File fileCandidates = new File(FILE_NAME);
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


    } public void listCandidates(){
             System.out.println("LIST OF CANDIDATES");
          for(CandidatesClass c : candidatesClasses){
              System.out.println("----------------");
              System.out.println("Code:"+c.getCandidateCod()+"\nName:"+c.getCandidateName()+"\nEntourage:"+c.getCandidateEntourage());
              System.out.println("----------------");
          }
    }


    public void setCandidates(Map<String, Integer> candidates) {
        this.candidates = candidates;
    }

    public Map<String, Integer> getCandidates() {
        return candidates;
    }


    @Override
    public void result() throws RemoteException {

    }

    @Override
    public Boolean vote(String voter, String cadidate) {
        return null;
    }
}
