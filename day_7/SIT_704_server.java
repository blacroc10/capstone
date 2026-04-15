import java.io.*;
import java.net.*;

//Q3) Difficult: Multi Client Bank Transaction Server
//Problem: Multiple ATM users access bank server simultaneously
//Solution: create
// * server handles multiple clients using threads
// * each client sends deposit amount
// * server updates balance
class ClientHandler extends Thread{
    Socket socket;
    static int BankBalance=1000;
    ClientHandler(Socket socket){
        this.socket=socket;
    }

    private static synchronized int deposit(int amount) {
        BankBalance += amount;
        return BankBalance;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String input = in.readLine();
            int amount = Integer.parseInt(input);
            int updatedBalance = deposit(amount);

            String name = Thread.currentThread().getName();
            System.out.println(name + " deposited " + amount + ". Balance: " + updatedBalance);
            out.println("Deposit successful. Updated balance: " + updatedBalance);

            socket.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Client handling error: " + e.getMessage());
        }
    }

}
public class SIT_704_server{
    public static void main(String[] args) throws IOException
    {
        ServerSocket servSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");
        while (true) {
            Socket socket=servSocket.accept();
            new ClientHandler(socket).start();
            
        }

    }
}