import java.io.*;
import java.util.ArrayList;

import com.google.gson.*;


public class MachineList {

    public static void main(String[] args) throws Exception {

        ArrayList<Object> machinelist = new ArrayList<Object>();
        //Gson gson = new Gson();

        Machine machine = new Machine("172.34.56.78", 174, true, false);
        Machine machine1 = new Machine("172.35.56.78", 175, true, false);
        Machine machine2 = new Machine("172.35.56.78", 176, false, true);
        Machine machine3 = new Machine("172.35.56.78", 176, false, true);
        machinelist.add(machine);
        machinelist.add(machine1);
        machinelist.add(machine2);
        machinelist.add(machine3);

        Gson gson = new Gson();
       /* Gson gsonBuilder = new GsonBuilder().create();
        Object jsonFromJavaArrayList = gsonBuilder.toJson(machinelist);

        System.out.println(jsonFromJavaArrayList);*/

       //Converts array to jsonarray and writes to a file
            String jsonArray = gson.toJson(machinelist);
            FileWriter writer = new FileWriter("machinelist.json");
            writer.write(jsonArray);
            writer.close();
            System.out.println(jsonArray);


            //Should be converting array back, but does not see to work
            Machine[] machineArray = gson.fromJson(jsonArray, Machine[].class);
            System.out.println(machineArray);


    }
}



