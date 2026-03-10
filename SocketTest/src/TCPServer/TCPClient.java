package TCPServer;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPClient {
    private Socket s = null;
    private DataInputStream server_in = null;
    private DataInputStream client_in = null;
    private DataOutputStream server_out = null;

    public TCPClient(int port) throws IOException{
        s = new Socket("127.0.0.1",port);

        server_in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
        client_in = new DataInputStream(System.in);
        server_out = new DataOutputStream(s.getOutputStream());

        String m = server_in.readUTF();
        System.out.println(m);
        m=client_in.readLine();
        server_out.writeUTF(m);

        s.close();
        server_out.close();
        server_in.close();
        client_in.close();
        System.out.println("Port "+port+" closed successfully");
    }

    public static void main(String[] args) {
        try{
            TCPClient tcpc = new TCPClient(5005);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
