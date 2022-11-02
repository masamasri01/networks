
package clientudp;
import java.io.*; 
import java.net.*; 
public class ClientUDP {
    public static void main(String[] args) throws Exception {
        int count=4;
        while(count!=0){
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
DatagramSocket clientSocket = new DatagramSocket();
InetAddress IPAddress = InetAddress.getByName("DESKTOP-2I776AV"); 
byte[] sendData = new byte[1024]; 
byte[] receiveData = new byte[1024]; 
String sentence = inFromUser.readLine(); 
sendData = sentence.getBytes();
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
clientSocket.send(sendPacket); 
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
clientSocket.receive(receivePacket); 
String modifiedSentence = new String(receivePacket.getData()); 
System.out.println("FROM SERVER:" + modifiedSentence); 
clientSocket.close();
    
    count--;}
}}
