import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SIT_701_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Enter message to send to server: ");
        String message = console.readLine();

        if (message == null || message.trim().isEmpty()) {
            message = "Hello Support Team";
        }

        out.println(message);
        System.out.println("Message sent to server.");

        socket.close();
    }
}
//Key concepts:
//1) Socket Programming: This code demonstrates how to create a client socket that connects to a server socket. The client sends a message to the server, which is a fundamental aspect of socket programming.
//2) Input/Output Streams: The code uses BufferedReader and PrintWriter to handle input and output operations.
//3) accept: This method is used by the server to wait for and accept incoming client connections. It blocks the server until a client connects, at which point it returns a Socket object that represents the connection to the client.
//4) Client-Server Communication: The code illustrates a simple client-server communication model where the client sends a message to the server, and the server reads and processes that message. This is a common pattern in network programming.
//5) BufferedReader and PrintWriter: These classes are used to read from and write to the socket's input and output streams, respectively. BufferedReader allows for efficient reading of text data, while PrintWriter provides convenient methods for writing text data to the stream.