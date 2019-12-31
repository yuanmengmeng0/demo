package liu;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/30
 * */

import java.io.*;
import java.util.ArrayList;

public class Demo3_Pet {
    public static void main(String[] args){
        File o =new File("F:/temp/pet.txt");
        File t =new File("F:/temp/pet.txt");
        ArrayList<Pet> arr=new ArrayList<>();
        Pet pet1=new Pet("001","小白");
        Pet pet2=new Pet("002","小黑");
        Pet pet3=new Pet("003","大黄");
        arr.add(pet1);
        arr.add(pet2);
        arr.add(pet3);

        InputStream ins=null;
        OutputStream outs=null;
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            outs = new FileOutputStream(o);
            oos=new ObjectOutputStream(outs);
            oos.writeObject(arr);
            oos.flush();
            System.out.println("写出成功");
            ins=new FileInputStream(o);
            ois=new ObjectInputStream(ins);
            Object ob=ois.readObject();
            if(ob instanceof ArrayList){
                @SuppressWarnings("unckecked")
                        ArrayList<Pet> li= (ArrayList<Pet>) ob;
                for(Pet p:li){
                    System.out.println(p);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
            if(ins!=null){
                ins.close();
            }
            if(outs!=null){
                    outs.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
