package com.kaisar.gym.model;

import java.util.ArrayList;

public class Trainer {
    private int trainerId;
    private String trainerName;
    private String specialization;
    private int experienceYears;

    //constructor
    public Trainer(int trainerId, String trainerName, String specialization, int experienceYears){
        setTrainerId(trainerId);
        setTrainerName(trainerName);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    //getters and setters
    public int getTrainerId() {
        return trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setTrainerId(int trainerId) {
        if(trainerId <= 0){
            throw new IllegalArgumentException("Trainer ID must be greater than zero");
        }
        this.trainerId = trainerId;
    }

    public void setTrainerName(String trainerName) {
        if(trainerName == null && trainerName.trim().isEmpty()){
            throw new IllegalArgumentException("Trainer Name cannot be empty");
        }
        this.trainerName = trainerName;
    }

    public void setSpecialization(String specialization) {
        if(specialization == null && specialization.trim().isEmpty()){
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if(experienceYears <= 0) {
            throw new IllegalArgumentException("Experience Years must be greater than zero");
        }
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