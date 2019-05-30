import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Client {

    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  in   = null;
    private DataOutputStream out     = null;

    public Client(String localhost, int port) throws IOException {

        try
        {
            socket = new Socket(localhost, port);
            System.out.println("Connected"); // need to  change to log

            //in  = new DataInputStream(System.in);
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
       /* try
        {
            in.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }*/

    }

    public void getMachineArray() throws IOException, ClassNotFoundException {
        InputStream in = socket.getInputStream();
        ObjectInputStream oin = new ObjectInputStream(in);
        String stringFromServer = (String) oin.readObject();
        System.out.println(stringFromServer);
        in.close();
    }

    public void sendStopMachine () throws IOException {
        System.out.println("Termination of machine is started");
        //Scanner scanner = new Scanner(System.in);
        //String ipAddress = scanner.nextLine();
        InetAddress host = InetAddress.getLocalHost();
        String hostIP = host.getHostAddress() ;
        out.writeUTF(hostIP);
        System.out.println("Machine" + " " + hostIP +" is terminated" );
    }


    public static void main(String args[]) throws IOException, ClassNotFoundException {

        /*if(args.length == 0) {
        Client client = new Client("localhost",5000);
        client.sendStopMachine();*/

        //if(args[0] == "Stop") {
            Client client1 = new Client("localhost",5000);
            client1.getMachineArray();

    }}

     