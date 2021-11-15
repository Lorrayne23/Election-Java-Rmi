### Elections with Java RMI
This work is based on a proposal from the book by Coulouris, Dollimore, Kinberg, Blair (2013), p. 227.
- The project was developed in java.



#### Main actions :

1.Consider an Election interface that provides two remote methods:
- vote(String voter, String candidate):
-  String voter: MD5 hash code generated from the voter's full name.
-  String candidate:  3-character numeric string that identifies a candidate.

- result(String candidate): this method has two parameters with which the server receives the number of a candidate and returns the number of votes for that candidate to the  client
2. Voter identifiers  generated from an MD5 function of the voter's full name.
3. The system  load the candidate list from the senators.csv file
4. Ensures its records the votes remain consistent when it is accessed simultaneously by multiple clients.






#### Operating instruction :
##### From the terminal, run the server:
```
$ ElectionServer.java
```
 
##### After the client :

```
$ ClientElection.java
```
