import java.util.*;

public class test {

    public static void main(String[] args){
        Map<String,String> map=new LinkedHashMap<>();
        map.put("tom","张");
        map.put("sandy","李");
        map.put("xioa","王");
       /* Set<Map.Entry<String, String>> entries=map.entrySet();
        for (Map.Entry<String, String> entry: entries){
            System.out.println("key:"+entry.getKey()+"value:"+entry.getValue());
        }*/
       Set keySet=map.keySet();
       Iterator it=keySet.iterator();
       while (it.hasNext()){
           Object key=it.next();
           Object value=map.get(key);
           System.out.println("key:"+key+",value："+value);
       }
    }
}
