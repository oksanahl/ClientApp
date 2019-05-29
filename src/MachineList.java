import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MachineList {

    public static void main(String[] args) {

        ArrayList<Object> machinelist = new ArrayList<Object>();

        Machine machine = new Machine("172.34.56.78", 174, true, false);
        Machine machine1 = new Machine("172.35.56.78", 175, true, false);
        machinelist.add("machine");
        machinelist.add("machine1");

        System.out.println(machinelist.size());
        System.out.println("Array: " + machinelist);



    }
}
