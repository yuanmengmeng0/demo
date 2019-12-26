package testSocket;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/26
 * */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class PortScanner {

    public static void main(String[] args){
        String host="localhost";
        if(args.length > 0){
            host=args[0];
        }
        new PortScanner().scan(host);
    }

  /*  private void scan(String host) {
        Socket socket=null;
        for(int port=1;port<1024;port++){
            try {
                socket = new Socket(host,port);
                System.out.println("连接到端口："+port);
            } catch (IOException e) {
                System.out.println("无法连接到端口："+port);
            }finally {
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }*/
  private void scan(String host) {
      Socket socket=null;
      socket = new Socket();
      SocketAddress address = new InetSocketAddress(host,8080);
      try {
          socket.connect(address,5000);
          System.out.println("连接成功！");
      } catch (IOException e) {
          System.out.println("连接超时");
          e.printStackTrace();
      }
  }

}
