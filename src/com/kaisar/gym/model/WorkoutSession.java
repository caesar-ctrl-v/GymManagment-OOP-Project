package com.kaisar.gym.model;

import java.util.ArrayList;

public abstract class WorkoutSession {
    protected int sessionId;
    protected String member;
    protected String trainer;
    protected int durationMinutes;

    //constructor
    public WorkoutSession(int sessionId,String member, String trainer, int durationMinutes) {
        setSessionId(sessionId);
        setMember(member);
        setTrainer(trainer);
        setDurationMinutes(durationMinutes);
    }
    //default constructor for workoutSessions without trainer
    public WorkoutSession(int sessionId, int durationMinutes){
        setSessionId(sessionId);
        this.trainer = null;
        setDurationMinutes(durationMinutes);
        member = null;
    }

    //getters and setters
    public int getSessionId() {
        return sessionId;
    }

    public String getMember() {
        return member;
    }

    public String getTrainer() {
        return trainer;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setSessionId(int sessionId) {
        if(sessionId <= 0){
            throw new IllegalArgumentException("Session ID must be greater than 0!");
        }
        this.sessionId = sessionId;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public void setTrainer(String trainer) {
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

    //toString() method
    @Override
    public String toString() {

        return "[ " + getWorkoutType() + " ] (Session ID: " + sessionId
                + ", Member: " + member
                + ", Trainer: " + trainer
                + ", Duration Minutes: " + durationMinutes + ")";
    }

    //additional methods
    //get workout type method
    public abstract String getWorkoutType();

    //calculate calories burned method
    public abstract int calculateCaloriesBurned();

}