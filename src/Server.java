import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket listener = new ServerSocket(5000);
        System.out.println ("Server is running...");

        while (true)
        {
            Socket s = null;

            try
            {
                s = listener.accept();

                System.out.println("A new client is connected : " + s);

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Assigning new thread for this client");

                Thread t = new ClientHandler(s, dis, dos);

                t.start();

            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread
{
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run()
    {
        String received;
        String toreturn;

        MachineList machines1 = new MachineList();

        while (true)
        {
            try {

                received = dis.readUTF();

                received.equals("Disconnect");
                toreturn = machines1.sendStopMachine();
                dos.writeUTF(toreturn);
                break;

                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

    }
