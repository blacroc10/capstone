
import java.io.*;
import java.net.* ;
public class SIT_702_server {
    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = new ServerSocket(3500) ;
        System.out.println("Restaurant server started..") ;
        Socket socket = servSocket.accept() ;
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true) ;
        String order = in.readLine() ;
        System.out.println("Received order: " + order) ;
        out.println("Order received: " + order) ;
        socket.close();
        servSocket.close() ;



        
    }
    
}
