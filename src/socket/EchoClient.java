package socket;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/26
 * */

import com.sun.jmx.snmp.internal.SnmpSubSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args){
        System.out.println(args);
        if(args.length !=2){
            System.out.println("Usage : java EchoClient");
            System.exit(1);
        }

        String hostName=args[0];
        int portNumber = Integer.parseInt(args[1]);
        try(
                Socket echoSocket = new Socket(hostName,portNumber);
                PrintWriter out= new PrintWriter(echoSocket.getOutputStream(),true);
                BufferedReader in=new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                )
        {
            String userInput;
            while((userInput = stdIn.readLine()) != null){
                out.println(userInput);
                System.out.println("echo:"+in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
