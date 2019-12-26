import java.util.Timer;
import java.util.TimerTask;

public class ThreadTest02 {

    public static void main(String[] args){
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        };
        Timer timer=new Timer();
        long delay=5000;
        long intevalPeriod=1*1000;
        timer.scheduleAtFixedRate(task,delay,intevalPeriod);
    }
}
