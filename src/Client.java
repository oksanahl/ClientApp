import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Client {

    // initialize socket and input output streams
    private Socket socket            = null;
    //private DataInputStream  input   = null;
    private DataOutputStream out     = null;

    /// constructor to put localhost and port  - We need to make sure we have server part for this
    public Client(String localhost, int port) throws IOException {

        try
        {
            socket = new Socket(localhost, port);
            System.out.println("Connected"); // need to  change to log

            // takes input from terminal
            //input  = new DataInputStream(System.in);

            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

    }

    public Vector<String> getCurrentMachineList() throws IOException {

        Vector<String> responseList = new Vector<>();

        System.out.println("Finding active machines: "); //change to log

        BufferedReader reader = new BufferedReader(new FileReader("machinelist.txt"));

        String st;
        while ((st = reader.readLine()) != null) {
            {
                System.out.println(st);
                responseList.add(st);
            }
        }

        System.out.println("Found " + responseList.size() + " " + "machines"); //change to log

        return responseList;

    }

    public void sendStopMachine () throws IOException {
        System.out.println("Enter ipAddress of machine to be terminated");
        Scanner scanner = new Scanner(System.in);
        String ipAddress = scanner.nextLine();
        out.writeUTF(ipAddress);
        System.out.println("Machine" + " " + ipAddress +" will be terminated" );
    }

    public static void main(String args[]) throws IOException {

        if(args.length == 0) {
        Client client = new Client("localhost",59898);
        client.getCurrentMachineList();}

        if(args[0] == "Stop") {
            Client client1 = new Client("localhost",5000);
            client1.sendStopMachine();



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
