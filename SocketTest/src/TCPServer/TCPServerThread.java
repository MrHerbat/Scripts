package TCPServer;

import java.io.*;
import java.net.*;


public class TCPServerThread implements Runnable{

    private Socket s = null;
    private TCPServerMain tcpsm;
    private DataInputStream din = null;
    private DataOutputStream dout = null;

    public TCPServerThread(Socket s, TCPServerMain tcpsm) {
        this.s = s;
        this.tcpsm = tcpsm;
    }

    @Override
    public void run() {
        try{
            int clientNumber = tcpsm.getClientNumber();
            System.out.println("OneToOneServer.Client "+clientNumber+" at "+s.getInetAddress()+" has connected.");

            din = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            dout = new DataOutputStream(s.getOutputStream());

            dout.writeUTF("Welcome to TCP OneToOneServer.Server!");

            String m = din.readUTF();
            System.out.println("Client "+clientNumber+": "+m);

            s.close();
            din.close();
            dout.close();
            System.out.println("Client "+clientNumber+" at "+s.getInetAddress()+" has disconnected.");


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
