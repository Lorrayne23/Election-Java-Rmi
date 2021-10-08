import Interface.Election;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class CandidatesClass {

    public String candidateName;
    public String candidateCod;
    public String candidateEntourage;

    public CandidatesClass(String candidateCod,String candidateName,String candidateEntourage){
        this.candidateCod = candidateCod;
        this.candidateName = candidateName;
        this.candidateEntourage = candidateEntourage;
    }

    public void setCandidateCod(String candidateCod) {
        this.candidateCod = candidateCod;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public void setCandidateEntourage(String candidateEntourage) {
        this.candidateEntourage = candidateEntourage;
    }

    public String getCandidateCod() {
        return candidateCod;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getCandidateEntourage() {
        return candidateEntourage;
    }


}
