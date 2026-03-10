package TCPServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerMain{
    private int clientNumber = 1;

    public int getClientNumber(){
        return clientNumber++;
    }

    public TCPServerMain(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server started at port: "+port);
        System.out.println("Awaiting clients...");

        while(true){
            Socket s = ss.accept();

            TCPServerThread tcpServerThread = new TCPServerThread(s,this);
            Thread thread = new Thread(tcpServerThread);
            thread.start();
        }
    }

    public static void main(String[] args) {

        try{
            TCPServerMain tcpsm = new TCPServerMain(5005);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}