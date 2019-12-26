import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        String content = "<img src=\"http://b\"><Section style=\"background:url(http://admin.wpub2018.tjyun.com:9000/eimage/pic//1.jpg) sad sad <section style=background:url(\"http://gggg\")</section></section>";
        String[] strs=content.split("url\\(\"");
        String text="";
        for (String str:strs){
            System.out.println(str);
            if(str.indexOf("http")!=0){
                String[] strs1=str.split("url\\(");
                for(String str1:strs1){
                 if(str1.indexOf("http")!=0){
                     text = text+str1+"url(";
                 }else{
                     int start=str1.indexOf(")");
                     String a=str1.substring(0,start);
                     String b=str1.substring(start+1);
                     text = text + a+ ")"+b+ "url(";
                 }
                }
            }else {
                    System.out.println(str.indexOf("\""));
                    int start=str.indexOf("\"");
                    String a=str.substring(0,start);
                    String b=str.substring(start+1);
                    text = text + a+ b+ "url(";
                    System.out.println(">>>>>" + text);
            }

        }
        System.out.println(content);
        System.out.println("text:"+text.substring(0,text.lastIndexOf("url(")));
        System.out.println("===================================================");
        Class ac= (Class) Class.forName("testService");
        Object obj=ac.newInstance();
        for(Method str:ac.getMethods()){
            System.out.println(str);
        }
        System.out.println("--------------------------------");
        Process process=Runtime.getRuntime().exec("cmd /c ipconfig");
        PrintWriter out=new PrintWriter(process.getOutputStream());
        String cmd="ipconfig";
        InputStream is=process.getInputStream();
        out.println(cmd);
        out.flush();
    }
}
