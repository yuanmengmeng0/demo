package liu;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/30
 * */

import http.X509TrustManagerImpl;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class localPic {
    public static void main(String[] args){
        try {
            TrustManager[] tm={new X509TrustManagerImpl()};
            SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
            sslContext.init(null,tm,new java.security.SecureRandom());
            SSLSocketFactory ssf=sslContext.getSocketFactory();
            URL url = new URL(null,"https://bdn.135editor.com/files/1/c8/a5a/c8a5a6d9bbedb28b9021f2c63185314a.jpg",new sun.net.www.protocol.https.Handler());
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            InputStream in = conn.getInputStream();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("F:/temp/皮卡丘.jpg"));
            int len;
            while((len = in.read()) !=-1){
                out.write(len);
            }
            out.flush();
            out.close();
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
