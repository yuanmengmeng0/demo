package socket;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/25
 * */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static String filename="src/socket/result.txt";
    public static void main(String[] args){
        try {
            Socket sk=new Socket("127.0.0.1",9999);
            System.out.println("-------客户端启动-------");
            PrintStream  ps=new PrintStream(sk.getOutputStream());
            System.out.println("发送：");
            Scanner sn=new Scanner(System.in);
            String str=sn.nextLine();
            ps.println(str);

            InputStream is=sk.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);

            //写文件
            FileWriter fw=new FileWriter(filename,true);
            //读文件
            String result =null;
            String s;
            while ((s = br.readLine()) != null){
                System.out.println("服务器推送："+s);
                if(result.contains(s)){
                    fw.write(s+"\n");
                }
            }
            sk.shutdownInput();
            ps.close();
            sk.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
