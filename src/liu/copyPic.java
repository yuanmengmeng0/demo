package liu;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/30
 * */

import java.io.*;

public class copyPic {
    public static void main(String[] args){
        File file=new File("F:/temp/下载.jpg");
        File file1=new File("F:/temp/复制.png");

        try {
            FileInputStream fileInputStream =new FileInputStream(file);
            FileOutputStream fileOutputStream =new FileOutputStream(file1);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream out =new BufferedOutputStream(fileOutputStream);
            int len;
            byte[] bytes =new byte[1024];
            while ((len = bufferedInputStream.read()) !=-1){
                out.write(len);
            }
            out.flush();
            out.close();
            bufferedInputStream.close();
            fileOutputStream.close();
            fileInputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
