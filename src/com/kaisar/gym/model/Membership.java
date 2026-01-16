package com.kaisar.gym.model;

import java.util.ArrayList;

public class Membership {
    private String membershipName;
    private int workoutDays;
    private double price;
    private boolean trainerIncluded;

    //constructor
    public Membership(String membershipName, int workoutDays, double price, boolean trainerIncluded){
        setMembershipName(membershipName);
        setWorkoutDays(workoutDays);
        setPrice(price);
        setTrainerIncluded(trainerIncluded);
    }

    //getters and setters
    public String getMembershipName() {
        return membershipName;
    }

    public int getWorkoutDays() {
        return workoutDays;
    }

    public double getPrice() {
        return price;
    }

    public boolean isTrainerIncluded() {
        return trainerIncluded;
    }

    public void setMembershipName(String membershipName) {
        if(membershipName == null && membershipName.trim().isEmpty()){
            throw new IllegalArgumentException("Membership Name cannot be empty");
        }
        this.membershipName = membershipName;
    }

    public void setWorkoutDays(int workoutDays) {
        if(workoutDays <= 0){
            throw new IllegalArgumentException("Workout Days must be greater than 0");
        }
        this.workoutDays = workoutDays;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.price = price;
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
    public int users(ArrayList<Member> members){
        int count = 0;
        for(Member member: members){
            if(member.getMembershipName().equals(membershipName)){
                count++;
            }
        }
        return count;
    }

    public double income(ArrayList<Member> members){
        double income = 0;
        for(Member member: members){
            if (member.getMembershipName().equals(membershipName)) {
                income += price;
            }
        }
        return income;
    }
}