package entity;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskScheduler {

    Comparator<Job> nextTask = (j1, j2) -> j1.getJobTime().compareTo(j2.getJobTime());
    PriorityQueue<Job> activeTasks = new PriorityQueue<Job>(nextTask);
    List<Job> inactive_jobe = new ArrayList<>();
    List<Job> inprogress = new ArrayList<>();


    public PriorityQueue<Job> getActiveTasks() {
        return activeTasks;
    }

    public void setActiveTasks(PriorityQueue<Job> activeTasks) {
        this.activeTasks = activeTasks;
    }

    public List<Job> getInactive_jobe() {
        return inactive_jobe;
    }

    public void setInactive_jobe(List<Job> inactive_jobe) {
        this.inactive_jobe = inactive_jobe;
    }

    public void createJob(Runnable jobFunction,int freq, Date startDate, Date endDate, Date jobTime) {

        Job job = new Job(jobFunction, freq, startDate, endDate, jobTime);
        activeTasks.add(job);
    }

    public void deleteJob(int jobID) {
        Job job = activeTasks.stream().filter(j -> j.getId() == jobID).findFirst().get();
        activeTasks.remove(job);
        System.out.println("Job is deleted:" + jobID);
    }

    public void schedule() throws InterruptedException {
        ExecutorService threadPool=Executors.newFixedThreadPool(3);
        while(true){
            Date currentTime=new Date();
//            System.out.println("currentTime:" + currentTime);
            while(!activeTasks.isEmpty() && activeTasks.peek().getJobTime().before(currentTime)){
                Job j1=activeTasks.poll();
                System.out.println("jobTime:" + j1.getJobTime());
                threadPool.execute(j1.jobFunction);
                inprogress.add(j1);
//                Job j2=new Job(j1.jobFunction,j1.freq,j1.start_date,j1.end_date,j1.jobTimej1+freq);
//                activeTasks.add(j2);

            }

            Thread.sleep(30);

        }
    }
}
