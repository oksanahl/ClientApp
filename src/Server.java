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

       public void getStopMachine() throws IOException {
           in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String ipAddress = null;
               try{ ipAddress =in.readUTF();
                System.out.println("Terminating machine" + " " + ipAddress);}
                catch(IOException i)
            {
                System.out.println(i);
            }

        }

    public static void main(String args[]) throws IOException {

       /* if(args.length == 0) {
        MachineList machines = new MachineList();
        Server server = new Server(5000);
        server.getStopMachine();*/

       // if (args[0] == "Stop") {
            MachineList machines1 = new MachineList();
            Server server1 = new Server (5000);
            server1.sendMachineArray(machines1.parseJson("machinelist.json"));
        }

}