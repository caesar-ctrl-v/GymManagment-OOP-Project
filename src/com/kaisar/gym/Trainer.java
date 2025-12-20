package com.kaisar.gym;

public class Trainer {
    private int trainerId;
    private String fullName;
    private String specialization;
    private int experienceYears;

    //constructor
    public Trainer(int trainerId, String fullName, String specialization, int experienceYears){
        this.trainerId = trainerId;
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
                ", fullName='" + fullName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }

    //additional methods
}