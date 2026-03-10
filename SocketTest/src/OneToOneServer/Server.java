package OneToOneServer;

import java.io.*;
import java.net.*;

public class Server {
    private Socket s = null;
    private ServerSocket ss;
    private DataInputStream din = null;

    public Server(int port){
        try{
            String m = "";

            ss = new ServerSocket(port);
            System.out.println("OneToOneServer.Server started!");

            System.out.println("Waiting for clients...");

            s = ss.accept();
            din = new DataInputStream(
                    new BufferedInputStream(s.getInputStream())
            );


            while(!m.equals("Over")){
                try{
                    m = din.readUTF();
                    System.out.println(m);
                }catch (IOException e){
                    System.out.println(e);
                }
            }
            System.out.println("OneToOneServer.Client closed connection");
            s.close();
            din.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        Server s = new Server(5000);
    }
}
