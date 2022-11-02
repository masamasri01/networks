
package serverudp;
import java.io.*; 
import java.net.*; 
import java.util.Scanner;
public class ServerUDP {

   
    public static void main(String[] args) throws Exception {
       DatagramSocket serverSocket = new DatagramSocket(9876); 
    byte[] receiveData = new byte[4]; 
    byte[] sendData = new byte[1024]; 
     String modifiedSentence="Vehicle is not found";
        while(true) 
        { 
            modifiedSentence="Vehicle is not found";
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
        serverSocket.receive(receivePacket);
        String sentence = new String(receivePacket.getData()); 
        System.out.println(" the incoming message from the client: "+ sentence);

        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort(); 
        
         File myObj = new File("carsDB.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        
        String arrOfStrings []=data.split(" ");
        String s2=arrOfStrings[0];
        if (sentence.compareTo(s2)==0){
                modifiedSentence = "Vehicle plate ID: " +arrOfStrings[0] + ", Make: "+arrOfStrings[1]+", Model: "+arrOfStrings[2]+", Year: "+arrOfStrings[3]+", Colour: "+arrOfStrings[4] +'\n';
             break;
        }
     
         }
        
        sendData = modifiedSentence.getBytes(); 
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); 
        serverSocket.send(sendPacket);

       
    }
    
    }}