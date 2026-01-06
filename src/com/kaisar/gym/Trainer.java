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
        setExperienceYears(experienceYears);
    }

    //getters and setters
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        if(trainerId >= 0){
            this.trainerId = trainerId;
        } else{
            System.out.println("Warning: Trainer ID cannot be negative!");
        }
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        if(trainerName != null && !trainerName.trim().isEmpty()){
            this.trainerName = trainerName;
        } else{
            System.out.println("Warning: Trainer Name cannot be empty!");
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if(specialization != null && !specialization.trim().isEmpty()){
            this.specialization = specialization;
        } else{
            System.out.println("Warning: Specialization cannot be empty!");
        }
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        if(experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else{
            System.out.println("Warning: Experience Years cannot be negative! Setting to 0.");
            this.experienceYears = 0;
        }
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