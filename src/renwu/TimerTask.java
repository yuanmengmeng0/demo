package renwu;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/30
 * */

import java.util.Timer;

public class TimerTask {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        },1000);
        Thread.sleep(2000);
        timer.cancel();
    }
}
