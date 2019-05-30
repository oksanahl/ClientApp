import java.net.*;
import java.io.*;
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

            // takes input from terminal
            //input  = new DataInputStream(System.in);

            // sends output to the socket
            //out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }

    }

    public void sendStopMachine () throws IOException {
        System.out.println("Enter ipAddress of machine to be terminated");
        Scanner scanner = new Scanner(System.in);
        String ipAddress = scanner.nextLine();
        out.writeUTF(ipAddress);
        System.out.println("Machine" + " " + ipAddress +" will be terminated" );
    }

    public void getMachineArray() throws IOException, ClassNotFoundException {
        InputStream in = socket.getInputStream();
        ObjectInputStream oin = new ObjectInputStream(in);
        String stringFromServer = (String) oin.readObject();
        System.out.println(stringFromServer);
        //FileWriter writer = new FileWriter("received.txt");
        //writer.write(stringFromServer);
        in.close();
        //writer.close();
    }


    public static void main(String args[]) throws IOException, ClassNotFoundException {

        if(args.length == 0) {
        Client client = new Client("localhost",5000);
        //client.sendStopMachine();
        client.getMachineArray();

        //if(args[0] == "Stop") {
            //Client client1 = new Client("localhost",5000);
            //client1.sendStopMachine();



    }}}

        /*
        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }}*/
