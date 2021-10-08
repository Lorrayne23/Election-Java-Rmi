import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Client {

    public String name;
    public String nameHash;


    public Client(String name){
        this.name = name;
        this.nameHash = defineNameHash(name);

    }
    public void setName(String name) {
        this.name = name;
    }

    public void setNameHash(String nameHash) {
        this.nameHash = nameHash;
    }

    public String getName() {
        return name;
    }

    public String getNameHash() {
        return nameHash;
    }

    public String defineNameHash(String name){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(name.getBytes());
            byte[] md5 = md.digest();
            BigInteger numMd5 = new BigInteger(1, md5);
            String hashMd5 = String.format("%022x", numMd5);
            return hashMd5;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }
}
