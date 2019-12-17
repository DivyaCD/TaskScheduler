package entity;

import enums.Status;

import java.util.Date;

public class Job{
    static int jobID=1;
    int id;
    Runnable jobFunction;
    Status jobStatus;
    Date start_date;
    Date end_date;
    Date jobTime;
    int freq;

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public static int getJobID() {
        return jobID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Runnable getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(Runnable jobFunction) {
        this.jobFunction = jobFunction;
    }

    public Status getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Status jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getJobTime() {
        return jobTime;
    }

    public void setJobTime(Date jobTime) {
        this.jobTime = jobTime;
    }

    public Job(Runnable jobFunction, int freq, Date start_date, Date end_date, Date jobTime) {
        this.id=jobID++;
        System.out.println("Create job:"+this.id);
        this.jobFunction = jobFunction;
        this.freq=freq;
        this.start_date = start_date;
        this.end_date = end_date;
        this.jobTime = jobTime;
    }
}