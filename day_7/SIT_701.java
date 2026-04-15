/*
      SOCKET PROGRAMMING

      Socket = Communication EndPoint
      A socket acts like a telephone connection between
      client and server.

      Client --> Socket --> Server
*/

//Q1) Basic : Chat Message Sender (Client --> Sender)
//    Problem : A customer sends a message to customer support

//Solution : Create
//        --> A server that waits for a client message.
//        --> A client that sends : "Hello Support Team"

//This is very simple communication system
//Server : waits for message from client.
//Client : sends message to server.

//Used for: BufferedReader & InputStreamReader
import java.io.*;
import java.net.*;

// This class represents SERVER
public class SIT_701 {
    public static void main(String[] args) throws IOException {
        // Create server on port i.e 3000.
        // Internal working: Java opens port 3000 and listens for incoming client
        // request.
        ServerSocket servSocket = new ServerSocket(3000);

        // Display message : "Server is waiting for client ....."
        System.out.println("Server is waiting for client .....");

        // Most important line
        // server waits until client connects.
        // Internal working: program pauses here & it stays blocked until client sends
        // request.

        Socket socket = servSocket.accept();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        String message = in.readLine();
        System.out.println("Client says:" + message);
        socket.close();

        servSocket.close();

    }
}