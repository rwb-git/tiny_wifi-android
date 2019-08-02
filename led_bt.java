package your_package.tiny_wifi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class led_bt {

    public static void esp_socket(String s){

        Socket socket = new Socket();

        try {

            byte[] ipb2 = {10,0,0,(byte)200};  // 200 nodemcu   201 wemos

            InetAddress ip4 = InetAddress.getByAddress(ipb2);

            try {

                socket.connect(new InetSocketAddress(ip4, 80));

                try {
                    socket.setSoTimeout(500);

                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                    DataInputStream dis = new DataInputStream(socket.getInputStream());

                    dos.writeBytes(s + "\r");

                    log("send this to esp: " + s);

                    log(" ");

                    dos.flush();

                    byte[] inb = new byte[2000];

                    int b;

                    String s2;

                    b = dis.read(inb);

                    while (b > 2) { // ignore \r\n

                        s2 = new String(inb, 0, b);

                        log("packet received from esp: ");

                        log(s2);

                        b = dis.read(inb);
                    }

                    dis.close();

                    dos.close();

                    log(" ");

                } catch (SocketException so){

                    log("socket exception");
                }

            } catch (IOException e){

                log("IO exception");
            }

        }catch(UnknownHostException u){

            log("unknown host exception");
        }
    }

    public static void log(String s){


        MainActivity.m_esp_hndl.obtainMessage(4, s).sendToTarget();
    }
}
