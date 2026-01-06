package com.kaisar.gym;

import java.util.ArrayList;

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
        if(membershipName != null && !membershipName.trim().isEmpty()){
            this.membershipName = membershipName;
        } else{
            System.out.println("Warning: Membership Name cannot be empty!");
        }
    }

    public int getWorkoutDays() {
        return workoutDays;
    }

    public void setWorkoutDays(int workoutDays) {
        if(workoutDays > 0){
            this.workoutDays = workoutDays;
        } else{
            System.out.println("Warning: Workout Days must be more than zero!");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0){
            this.price = price;
        } else{
            System.out.println("Warning: Price cannot be negative! Setting to 0.");
            this.price = 0;
        }
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