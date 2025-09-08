import java.util.Timer;
import java.util.TimerTask;

public class timertask{
    public static void main(String[] args){

        System.out.println(timeStart());        
        
    }

    public void timeStart() {

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            @override
            public void run(){
                return "Task completed";
            }
        };

        timer.scheduleFixedRate(task,0,1000);
    }
}
