
package clienttcp;
import java.io.*; 
import java.net.*;

public class ClientTCP {

    public static void main(String[] args) throws Exception  {
        // TODO code application logic here
        int count =3;
        while(count!=0){
        String sentence; 
        
        String modifiedSentence; 
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
        Socket clientSocket = new Socket("DESKTOP-2I776AV",6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
        sentence = inFromUser.readLine(); 
        outToServer.writeBytes(sentence + '\n'); 
        modifiedSentence = inFromServer.readLine(); 
        System.out.println("FROM  SERVER: " + modifiedSentence);
      count--;
    } 
        //clientSocket.close();
    }
    
}
