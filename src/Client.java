import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws Exception
    { MachineList machines2 = new MachineList();

    for (int i=1; i<10; i++){
    System.out.println("Enter command to execute?[Disconnect | List | Grep]" + " " + "or type Exit to close the Client.");
    Scanner scn = new Scanner(System.in);
    String tosend = scn.nextLine();

                if(tosend.equals("Exit"))
                {
                    System.out.println("Closing the client ");
                    System.out.println("Client closed");
                    break;
                }

              else if(tosend.equals("Grep"))
                {
                    System.out.println("Enter the phrase to search for: ");
                    Scanner scanner = new Scanner(System.in);
                    String phrase =  scanner.nextLine();
                    machines2.findPhrase(phrase);
                }

              else if(tosend.equals("List"))
              {
                  System.out.println(machines2.parseJson("machinelist.json"));
              }

              else if (tosend.equals("Disconnect"))
              {
                  InetAddress ip = InetAddress.getByName("localhost");
                  Socket s = new Socket(ip, 5000);

                  DataInputStream dis = new DataInputStream(s.getInputStream());
                  DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                  dos.writeUTF(tosend);
                  String received = dis.readUTF();
                  System.out.println(received);
              }

              else
                  {
                      System.out.println("Invalid input from user");
                  }

        }
        }}
