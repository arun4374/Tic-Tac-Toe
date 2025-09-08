import java.util.Timer;
import java.util.TimerTask;

public class gameTimer {
    private int timeleft;
    private Timer timer;
    public gameTimer(int min){
        this.timeleft = min * 60;
    }
    private String formatTime(int timeleft){
        int min = timeleft / 60;
        int sec = timeleft % 60;

        return String.format("%d:%02d",min, sec);
    }

    public void start(){
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            public void run(){
                if(timeleft >0){
                    System.out.println("Time: "+formatTime(timeleft));
                    timeleft--;
                }else{
                    System.out.println("Time up !");
                    return;
                }
            }
        };

        timer.scheduleFixedRate(task,0.1000);
    }
}