import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MachineList {

    public static void main(String[] args) {

        Vector<Object> listStrings = new Vector<Object>();

        Machine machineone = new Machine("172.34.56.78", 174, true, false);
        Machine machinetwo = new Machine("172.35.56.78", 175, true, false);
        listStrings.add(machineone);
        listStrings.add(machinetwo);

        System.out.println(listStrings.size());
        System.out.println("Vector: " + listStrings);


    }
}
