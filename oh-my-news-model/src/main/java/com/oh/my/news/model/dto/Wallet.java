package com.oh.my.news.model.dto;

/**
 * Created by Administrator on 2017/4/30.
 */
public class Wallet {
    private String time;
    private String goal;
    private String sum;
    private String person;
    private String note;
    private int id;
    @Override
    public String toString() {
        return "Wallet{" +
                "time=" + time +
                ", goal='" + goal + '\'' +
                ", sum='" + sum + '\'' +
                ", person='" + person + '\'' +
                ", note='" + note + '\'' +
                ", id=" + id +
                '}';
    }

    public Wallet(String time, String goal, String sum, String person, String note, int id) {
        this.time = time;
        this.goal = goal;
        this.sum = sum;
        this.person = person;
        this.note = note;
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
