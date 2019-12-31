package socket;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/26
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args){
        System.out.println(args);
        if(args.length !=1){
            System.out.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        try (
            ServerSocket serverSocket=new ServerSocket(portNumber);
            Socket clientSocket=serverSocket.accept();
            PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ){
            String inputLine;
            while ((inputLine = in.readLine()) !=null){
                out.println(inputLine);
            }
        } catch (IOException e) {
           System.out.println("Exception caught"+portNumber+"or listening for");
           System.out.println(e.getMessage());
        }
    }
}
