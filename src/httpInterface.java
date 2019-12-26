import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpInterface {
    public static void interfaceUtil(String path,String data){
        try {
            URL url=new URL(path);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.connect();
            InputStream is=conn.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String str="";
            while ((str=br.readLine()) != null){
                str=new String(str.getBytes(),"UTF-8");
                System.out.println(str);
            }
            is.close();
            conn.disconnect();
            System.out.println("完整结束");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        interfaceUtil("http://172.83.28.221:7001/NSRTRegistration/test/add.do?id=8888888&name=99999999","");
    }
}
