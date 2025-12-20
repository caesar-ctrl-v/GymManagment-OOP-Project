package com.kaisar.gym;

public class Membership {
    private String membershipName;
    private int workoutDays;
    private double price;
    private boolean trainerIncluded;

    //constructor
    public Membership(String membershipName, int workoutDays, double price, boolean trainerIncluded){
        this.membershipName = membershipName;
        this.workoutDays = workoutDays;
        this.price = price;
        this.trainerIncluded = trainerIncluded;
    }

    //getters and setters
    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public int getWorkoutDays() {
        return workoutDays;
    }

    public void setWorkoutDays(int workoutDays) {
        this.workoutDays = workoutDays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isTrainerIncluded() {
        return trainerIncluded;
    }

    public void setTrainerIncluded(boolean trainerIncluded) {
        this.trainerIncluded = trainerIncluded;
    }

    //toString() method
    @Override
    public String toString() {
        return "Membership{" +
                "membershipName='" + membershipName + '\'' +
                ", workoutDays=" + workoutDays +
                ", price=" + price +
                ", trainerIncluded=" + trainerIncluded +
                '}';
    }

    // additional methods
}