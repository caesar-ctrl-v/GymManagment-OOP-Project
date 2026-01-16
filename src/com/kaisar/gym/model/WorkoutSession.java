package com.kaisar.gym.model;

import java.util.ArrayList;

public abstract class WorkoutSession {
    protected int sessionId;
    protected ArrayList<Member> members;
    protected Trainer trainer;
    protected int durationMinutes;

    //constructor
    public WorkoutSession(int sessionId, Trainer trainer, int durationMinutes){
        setSessionId(sessionId);
        setTrainer(trainer);
        setDurationMinutes(durationMinutes);
        members = new ArrayList<>();
    }
    //default constructor for workoutSessions without trainer
    public WorkoutSession(int sessionId, int durationMinutes){
        setSessionId(sessionId);
        this.trainer = null;
        setDurationMinutes(durationMinutes);
        members = new ArrayList<>();
    }

    //getters and setters
    public int getSessionId() {
        return sessionId;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setSessionId(int sessionId) {
        if(sessionId <= 0){
            throw new IllegalArgumentException("Session ID must be greater than 0!");
        }
        this.sessionId = sessionId;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setDurationMinutes(int durationMinutes) {
        if(durationMinutes <= 0){
            throw new IllegalArgumentException("Duration Minutes must be greater than 0!");
        }
        if(durationMinutes > 240){
            throw new IllegalArgumentException("Duration Minutes must be less than 240!");
        }
        this.durationMinutes = durationMinutes;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    //toString() method
    @Override
    public String toString() {

        return "[ " + getWorkoutType() + " ] (Session ID: " + sessionId
                + ", Members: " + getMemberNames()
                + ", Trainer: " + getTrainerName()
                + ", Duration Minutes: " + durationMinutes + ")";
    }

    //additional methods
    //get workout type method
    public abstract String getWorkoutType();

    //calculate calories burned method
    public abstract int calculateCaloriesBurned();

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
    //add member method
    public boolean addMember(Member member) {
        if (member == null) {
            return false;
        }
        if (members.contains(member)) {
            return false;
        }
        members.add(member);
        return true;
    }
    //remove member method
    public boolean removeMember(Member member) {
        if (members.remove(member)) {
            return true;
        } else {
            System.out.println("Member not found in session.");
            return false;
        }
    }
    //get trainer name method
    public String getTrainerName(){
        if(trainer != null){
            return trainer.getTrainerName();
        } else{
            return null;
        }
    }
}