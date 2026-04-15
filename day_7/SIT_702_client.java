import java.io.*;
import java.net.*;
public class SIT_702_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3500) ;
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true) ;
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
        String order = "Pizza" ;
        out.println(order) ;
        String response = in.readLine() ;
        System.out.println("Server response: " + response) ;
        socket.close() ;
    }
    
}
