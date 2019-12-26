package socket;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/25
 * */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<String> sentence;
    private static String filename="src/socket/English900.txt";

    public static void main(String[] args) throws IOException {
        sentence = new ArrayList<>();
        System.out.println("------服务器启动------");
        FileReader fileReader = new FileReader(filename);
        BufferedReader br=new BufferedReader(fileReader);
        String inputLine= null;
        while ((inputLine = br.readLine()) !=null){
            sentence.add(inputLine);
        }
        ServerSocket ss=new ServerSocket(9999);
        while (true){
            Socket sk=ss.accept();
            ServerThread st=new ServerThread(sk);
            st.start();
        }
    }
}
