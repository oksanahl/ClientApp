import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Vector;

public class Client
{
    public static void main(String[] args) throws Exception
    {
        try
            {
                Scanner scn = new Scanner(System.in);
                InetAddress ip = InetAddress.getByName("localhost");
                Socket s = new Socket(ip, 5000);

                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Enter command to execute?[disconnect | list | grep]" + " " + "or type Exit to close the Client.");
                //System.out.println(dis.readUTF());
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);
                // the following loop performs the exchange of
                // information between client and client handler

                while (true) {



                    // If client sends exit,close this connection
                    // and then break from the while loop
                    /*if(tosend.equals("Exit"))
                    {
                        System.out.println("Closing this connection : " + s);
                        s.close();
                        System.out.println("Connection closed");
                        break;
                    }*/
                    {
                        switch (tosend) {
                case "list":
                    String received = dis.readUTF();
                    System.out.println(received);
                    break;
                case "grep":
                    received = dis.readUTF();
                    System.out.println(received);
                    break;
                case "phrase":
                    received = dis.readUTF();
                    System.out.println(received);
                    break;
                case "disconnect":
                    received = dis.readUTF();
                    System.out.println(received);
                    break;
                default:
                    received = dis.readUTF();
                    System.out.println(received);
                    break;
            }
                // closing resources
                scn.close();
                dis.close();
                dos.close();
            }
            }}catch(Exception e){
            e.printStackTrace();
        }
    }}

/* //for (int i=1; i<10; i++){
        while (true){
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
        }}*/
