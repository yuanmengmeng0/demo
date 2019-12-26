import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadTest03 {
    public static void main(String[] args){
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        };
        ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable,0,5, TimeUnit.SECONDS);
    }
}
