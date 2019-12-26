
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadTest {

    public static void main(String[] args){
        final long timeInterval=1000;
        Runnable runnable = new Runnable() {
            int i=0;
            @Override
            public void run() {
                while (true){
                    i++;
                    System.out.println(i+":Hello alibaba qa!");
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }

}
