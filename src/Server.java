import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static void main(String[] args) throws IOException {
        Map<String,String> userPass = new HashMap<>();
        userPass.put("hassan_shokoohi","12345");
        userPass.put("soren_shokoohi","12345");
        userPass.put("amin_ghasemi","12345");
        userPass.put("bahram_mirzayi","12345");
        try(ServerSocket serverSocket = new ServerSocket(80)){
            System.out.println("Witing for a connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to the client...");
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            DataInputStream reader = new DataInputStream(inputStream);
            PrintWriter writer = new PrintWriter(outputStream,true);

            String username = reader.readLine();
            String password = reader.readLine();

            if (userPass.containsKey(username)) {
                if (userPass.get(username).equals(password)) {
                    writer.println("true");
                    String fromClient = reader.readLine();
                    System.out.println("Client : " + fromClient);

                    writer.println("What is your name ? ");

                    fromClient = reader.readLine();
                    System.out.println("Client name : " + fromClient);

                    writer.println("What is your family name ? ");

                    fromClient = reader.readLine();
                    System.out.println("Client familyName : " + fromClient);
                }else{
                    System.out.println("wrong password by client");
                    writer.println("wrong pass");
                }
            }else{
                System.out.println("wrong username by client");
                writer.println("wrong user");

            }
        }
    }
}