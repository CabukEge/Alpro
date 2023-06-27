import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class UDPClient {

    public static void main(String[] args) {
        String a, b, c;
        c = "\n";
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(0);
            Scanner scanner = new Scanner(System.in);
            InetAddress host = InetAddress.getByName("localhost");
            while (true) {

                System.out.println("Erste Zahl Eingeben");
                a = scanner.nextLine();
                System.out.println("zweite Zahl Eingeben");
                b = scanner.nextLine();

                DatagramPacket outPacket = new DatagramPacket(a.getBytes(), a.getBytes().length,
                        host, UDPServer.serverPort);
                socket.send(outPacket);
                outPacket = new DatagramPacket(c.getBytes(), c.getBytes().length,
                        host, UDPServer.serverPort);
                socket.send(outPacket);

                outPacket = new DatagramPacket(b.getBytes(), b.getBytes().length,
                        host, UDPServer.serverPort);
                socket.send(outPacket);
                outPacket = new DatagramPacket(c.getBytes(), c.getBytes().length,
                        host, UDPServer.serverPort);
                socket.send(outPacket);

                byte[] buffer = new byte[256];

                DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(inPacket);

                String message = new String(inPacket.getData(), 0, inPacket.getLength());
                System.out.println(inPacket.getAddress().getHostAddress() + ": " + inPacket.getPort() + " - " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }

        }

    }


}
