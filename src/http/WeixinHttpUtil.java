package http;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/19
 * */

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

public class WeixinHttpUtil {

    public static String httpsRequest(String requestUrl,String requestMethod,String outputStr){
        String str=null;
        StringBuffer buffer = new StringBuffer();
        try {
            TrustManager[] tm={new X509TrustManagerImpl()};
            SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
            sslContext.init(null,tm,new java.security.SecureRandom());
            SSLSocketFactory ssf=sslContext.getSocketFactory();
            URL url=new URL(requestUrl);
            HttpsURLConnection httpsURLConnection= (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(ssf);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod(requestMethod);
            if("GET".equalsIgnoreCase(requestMethod))
                httpsURLConnection.connect();
            if(null !=outputStr){
                OutputStream outputStream=httpsURLConnection.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            InputStream inputStream=httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            while ((str=bufferedReader.readLine()) != null){
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            httpsURLConnection.disconnect();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
