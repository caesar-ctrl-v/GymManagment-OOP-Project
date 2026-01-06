package com.kaisar.gym;

import java.util.ArrayList;

public class WorkoutSession {
    protected int sessionId;
    protected ArrayList<Member> members;
    protected Trainer trainer;
    protected int durationMinutes;

    //constructor
    public WorkoutSession(int sessionId, Trainer trainer, int durationMinutes){
        this.sessionId = sessionId;
        this.trainer = trainer;
        setDurationMinutes(durationMinutes);
        members = new ArrayList<>();
    }
    //default constructor for workoutSessions without trainer
    public WorkoutSession(int sessionId, int durationMinutes){
        this.sessionId = sessionId;
        this.trainer = null;
        this. durationMinutes = durationMinutes;
        members = new ArrayList<>();
    }

    //getters and setters
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        if(sessionId >= 0){
            this.sessionId = sessionId;
        } else{
            System.out.println("Warning: Session ID cannot be negative!");
        }
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        if(trainer != null){
            this.trainer = trainer;
        } else{
            System.out.println("Warning: Trainer cannot be empty! Setting to null.");
            this.trainer = null;
        }
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        if(durationMinutes >= 0 && durationMinutes <= 240){
            this.durationMinutes = durationMinutes;
        } else if(durationMinutes > 0){
            System.out.println("Warning: Duration Minutes cannot exceed 240! Setting to 240.");
            this.durationMinutes = 240;
        } else{
            System.out.println("Warning: Duration Minutes cannot be negative! Setting to 0.");
            this.durationMinutes = 0;
        }
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

        return "[ " + getWorkoutType() + " ] (Session ID: " + sessionId
                + ", Members: " + getMemberNames()
                + ", Trainer: " + getTrainerName()
                + ", Duration Minutes: " + durationMinutes + ")";
    }

    //additional methods
    //get workout type method
    public String getWorkoutType() {
        return "General workout";
    }

    //calculate calories burned method
    public int calculateCaloriesBurned() {
        return durationMinutes * 5;
    }

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