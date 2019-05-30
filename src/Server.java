import com.google.gson.Gson;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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

            System.out.println("Sending machineArray to client");
            String str ="machine";
            out.writeUTF(str);


            // takes input from the client socket
            /*in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            String ipAddress = null;
            try{
                ipAddress =in.readUTF();
                System.out.println("Terminating machine" + " " + ipAddress);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }*/

            /*String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }*/
            //System.out.println("Closing connection");

            // close connection
            //socket.close();
            //in.close();
        }
        catch(IOException i) {
            System.out.println(i);
        }


    }

    public static void main(String args[]) throws IOException {


        ArrayList<Object> machinelist = new ArrayList<Object>();
        Machine machine = new Machine("172.34.56.78", 174, true, false);
        Machine machine1 = new Machine("172.35.56.78", 175, true, false);
        Machine machine2 = new Machine("172.35.56.78", 176, false, true);
        Machine machine3 = new Machine("172.35.56.78", 176, false, false);
        machinelist.add(machine);
        machinelist.add(machine1);
        machinelist.add(machine2);
        machinelist.add(machine3);
        MachineList machines = new MachineList();
        machines.writeJson(machinelist);
        machines.parseJson("machinelist.json");

        Server server = new Server(5000);


    }
}