import java.io.*;
import java.net.*;

public class SIT_704_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.print("Enter deposit amount: ");
        String amount = console.readLine();
        if (amount == null || amount.trim().isEmpty()) {
            amount = "0";
        }

        out.println(amount.trim());
        String response = in.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}
