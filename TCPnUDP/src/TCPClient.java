import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main(String[] args) {
        try(Socket clientSocket = new Socket("localhost", 31337)){
            OutputStream outputStream = clientSocket.getOutputStream();
            try (PrintStream printStream = new PrintStream(outputStream, true)) {

                printStream.println("Test");
            }

            var oos = new ObjectOutputStream(outputStream);

            oos.writeObject(new Temperatur(2,2.9));
            oos.flush();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
