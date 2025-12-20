package com.kaisar.gym;

import java.util.ArrayList;

public class WorkoutSession {
    private int sessionId;
    private ArrayList<Member> members;
    private String trainer;
    private int durationMinutes;

    //constructor
    public WorkoutSession(int sessionId, String trainer, int durationMinutes){
        this.sessionId = sessionId;
        this.trainer = trainer;
        this. durationMinutes = durationMinutes;
        members = new ArrayList<>();
    }

    //getters and setters
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    //toString() method
    @Override
    public String toString() {

        return "WorkoutSession{" +
                "sessionId=" + sessionId +
                ", members=" + getMemberNames() +
                ", trainer='" + trainer + '\'' +
                ", durationMinutes=" + durationMinutes +
                '}';
    }

    //additional methods
    //get array of names of members
    public ArrayList<String> getMemberNames(){
        ArrayList<String> names = new ArrayList<>();
        for (Member m : members) {
            names.add(m.getFullName());
        }
        return names;
    }
    //get array of ages of members
    public ArrayList<Integer> getMemberAges(){
        ArrayList<Integer> ages = new ArrayList<>();
        for(Member a: members){
            ages.add(a.getAge());
        }
        return ages;
    }
    //find whether group is senior or junior
    public String findWorkoutSessionType(){
        ArrayList<Integer> ages = getMemberAges();
        int max = ages.getFirst();
        for(int age: ages){
            if(age > max){
                max = age;
            }
        }
        if(max < 16){
            return "Junior Group";
        } else{
            return "Senior Group";
        }
    }
}