import java.net.*;
import java.io.*;

class Client
{
    public static void main(String Arg[]) throws Exception
    {
        System.out.println("Client Application is Running");  
        
        Socket sobj = new Socket("localhost",2100); // Request To Server
        System.out.println("Connection established with the client..");

        PrintStream ps = new PrintStream(sobj.getOutputStream());
        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String str1, str2;
        System.out.println("Chat Messenger Applica1tion Started..");
        while(!(str1 = br2.readLine()).equals("end"))
        {
            ps.println(str1);    // send msg to server
            str2 = br1.readLine();   // wait for server reply
            System.out.println("Server says : "+str2);
            System.out.println("Enter the Message for Server : ");        
        }
        System.out.println("Thank you for using the My Chat Application..");
    }
}