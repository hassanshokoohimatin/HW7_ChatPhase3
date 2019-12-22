import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the IP and port of the server");
        try(Socket socket = new Socket(input.next(),input.nextInt())){
            System.out.println("Connected to the server...");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream reader = new DataInputStream(inputStream);
            PrintWriter writer = new PrintWriter(outputStream,true);

            System.out.println("Enter the username : ");
            String username;
            Scanner scan = new Scanner(System.in);
            username = scan.nextLine();
            writer.println(username);

            System.out.println("Enter the password : ");
            String password;
            password = scan.nextLine();
            writer.println(password);

            String status = reader.readLine();
            if (status.equals("true")) {


                System.out.println("Your message : ");
                String message;
                message = scan.nextLine();
                writer.println(message);

                String response = reader.readLine();
                System.out.println("Server : " + response);

                System.out.println("Your message : ");
                message = scan.nextLine();
                writer.println(message);

                response = reader.readLine();
                System.out.println("Server : " + response);

                System.out.println("Your message : ");
                message = scan.nextLine();
                writer.println(message);
            }
            else{
                System.out.println(status);

            }
        }catch (Exception e){
            System.out.println("INVALID IP OR PORT");
        }
    }
}
