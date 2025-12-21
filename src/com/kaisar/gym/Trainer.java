package com.kaisar.gym;

import java.util.ArrayList;

public class Trainer {
    private int trainerId;
    private String trainerName;
    private String specialization;
    private int experienceYears;

    //constructor
    public Trainer(int trainerId, String trainerName, String specialization, int experienceYears){
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    //getters and setters
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    //toString() method
    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", trainerName='" + trainerName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }

    //additional methods
    public boolean isActive(ArrayList<WorkoutSession> sessions){
        String trainerName = getTrainerName();
        for(WorkoutSession session: sessions){
            if(session.getTrainer().equals(trainerName)){
                return true;
            }
        }
        return false;
    }

    public boolean isExperienced(){
        return experienceYears > 20;
    }
}