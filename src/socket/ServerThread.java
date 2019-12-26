package socket;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/25
 * */

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket sk;
    public ServerThread(Socket sk){
        this.sk =sk;
    }

    @Override
    public void run() {
        BufferedReader br=null;
        try {
            br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
            String line=br.readLine();
            System.out.println("客户端："+line);
            String[] split=line.split(":");
            String[] split1=split[split.length-1].split(",");
            sk.shutdownInput();
            OutputStream os=sk.getOutputStream();
            PrintStream bw=new PrintStream(os);

            //给客户端返回消息
            for(int i=0;i<split1.length;i++){
                int str=Server.sentence.size();
                if(str == 0){
                    str =1;
                }
                bw.print(Server.sentence.get(Integer.parseInt(split1[i])%str)+"\n");
            }
            bw.flush();
            bw.close();
            sk.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
