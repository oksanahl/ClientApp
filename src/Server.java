import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    private DataOutputStream out     = null;

    // constructor with port
    public Server(int port) {
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            //System.out.println("Closing connection");

            // close connection
            //socket.close();
            //in.close();
        }
        catch(IOException i) {
            System.out.println(i);
        }

    }

    public void sendMachineArray (String array)  {
        System.out.println("Sending machineArray to client");

        try{ OutputStream out = socket.getOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(out);
        oout.writeObject(array);
        oout.close();
        } catch (IOException e) {

            System.out.println("Generic Exception Caught in command Server Manager: " + e.getMessage());
        }}

    public static void main(String args[]) throws IOException {

        MachineList machines = new MachineList();
        Server server = new Server(5000);

        server.sendMachineArray(machines.parseJson("machinelist.json"));
    }
}