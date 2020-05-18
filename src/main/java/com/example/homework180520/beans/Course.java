package com.example.homework180520.beans;

import com.example.homework180520.Exception.dateProblemException;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String title;
    @Column
    private int duration;
    @Column
    private Date startDate;

    public Course(String title, int duration, Date startDate) throws dateProblemException {
        this.title = title;
        this.duration = duration;
        Calendar cal = Calendar.getInstance();
        Date d = new Date(cal.getTimeInMillis());
    if(startDate.after(d))
        this.startDate = startDate;
    else
        throw new dateProblemException();
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", startDate=" + startDate +
                '}';
    }
}
