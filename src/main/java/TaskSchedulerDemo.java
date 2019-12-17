import entity.TaskScheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskSchedulerDemo {

    public static void main(String[] args) throws InterruptedException, ParseException {
        TaskScheduler taskScheduler=new TaskScheduler();
        Runnable r1=()->System.out.println("job 1");
        Runnable r2=()->System.out.println("job 2");
        Runnable r3=()->System.out.println("job 3");
        Runnable r4=()->System.out.println("job 4");
        Runnable r6=()->System.out.println("job 6");
        Runnable r5=()->System.out.println("job 5");


        SimpleDateFormat sd=new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        taskScheduler.createJob(r1,2,sd.parse("17/12/2019 03:12:00"),null,new Date());
        taskScheduler.createJob(r2,3, sd.parse("17/12/2019 02:12:00"),null,new Date());
        taskScheduler.createJob(r3,2,sd.parse("17/12/2019 03:12:00"),null,new Date());
        taskScheduler.createJob(r4,3, sd.parse("17/12/2019 02:12:00"),null,new Date());
        taskScheduler.createJob(r5,2,sd.parse("17/12/2019 03:12:00"),null,new Date());
        taskScheduler.createJob(r6,3, sd.parse("17/12/2019 02:12:00"),null,new Date());

        taskScheduler.schedule();

    }
}
