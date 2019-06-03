import java.io.*;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import com.google.gson.*;

public class MachineList {

    public String writeJson(ArrayList<Object> array) throws IOException {
        Gson gson = new Gson();
        String jsonArray = gson.toJson(array);
        FileWriter writer = new FileWriter("machinelist.json");
        writer.write(jsonArray);
        writer.close();
        return(jsonArray);
    }

    public String parseJson(String filepath) throws FileNotFoundException {
        Gson gson = new Gson();
        String path = "machinelist.json";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Machine[] machineArray = gson.fromJson(bufferedReader, Machine[].class);
        String stringMachineArray = Arrays.toString(machineArray);
        return(stringMachineArray);

    }

    public String sendStopMachine() throws IOException {
        InetAddress host = InetAddress.getLocalHost();
        String hostIP = host.getHostAddress() ;
        String mystring = "Disconnecting machine" + " " + hostIP;
        return (mystring);

    }

    public static void main(String[] args) throws Exception {

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

    }
}



