import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.List;

public class UDPServer {

public static int serverPort = 31337;

    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(serverPort);
            double[] numbers = new double[3];
            int j = 0;

            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);

            String message;
            for(int i = 0;i<4;i++){
                serverSocket.receive(inPacket);
                message = new String(inPacket.getData(),0, inPacket.getLength());
                try {
                    numbers[j] = Double.parseDouble(message);
                    j++;
                } catch (NumberFormatException e) {

                }
                System.out.println(inPacket.getAddress().getHostAddress() + ": " + inPacket.getPort() + " - " + message);
            }
            numbers[2] = numbers[0] + numbers[1];
            String msg = String.valueOf(numbers[2]);

            DatagramPacket outPacket = new DatagramPacket(msg.getBytes(), msg.length(),
                    inPacket.getAddress(), inPacket.getPort());
            serverSocket.send(outPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null) {
                serverSocket.close();
            }


        }


    }
}
