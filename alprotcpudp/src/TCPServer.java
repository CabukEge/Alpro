import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(31337);
            clientSocket = serverSocket.accept();
            var ois = new ObjectInputStream(clientSocket.getInputStream());
            Temperatur temperatur = (Temperatur) ois.readObject();
            System.out.println("Received Temperatur: " + temperatur.getTemperatur());



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(clientSocket != null)
            {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null)
            {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
