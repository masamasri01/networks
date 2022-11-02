/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;
import java.io.*; 
import java.net.*;
import java.util.Scanner;

public class ServerTCP {

    public static void main(String[] args) throws Exception{
     
ServerSocket welcomeSocket = new ServerSocket(6789); 
       String clientSentence; 
         String send="VEHICLE NOT FOUND";
      
while(true) { 
     
Socket connectionSocket = welcomeSocket.accept(); 
BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
clientSentence = inFromClient.readLine();   
System.out.println(" the incoming message from the client: "+ clientSentence);
       send="VEHICLE NOT FOUND";  
try{         
        File myObj = new File("carsDB.txt");
        Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String arrOfStrings []=data.split(" ");
        if (clientSentence.equals(arrOfStrings[0])){
             send= "Vehicle plate ID: " + clientSentence+", Make: "+arrOfStrings[1]+", Model: "+arrOfStrings[2]+", Year: "+arrOfStrings[3]+", Colour: "+arrOfStrings[4] +'\n';
             break;
        }
       
      }//while
     
         outToClient.writeBytes(send); 
     
           
   myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}//while (1)

}
}