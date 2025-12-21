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
    public int users(ArrayList<Member> members){
        int count = 0;
        for(Member member: members){
            if(member.getMembership().getMembershipName().equals(membershipName)){
                count++;
            }
        }
        return count;
    }

    public void income(ArrayList<Member> members){
        double income = 0;
        for(Member member: members){
            if (member.getMembership().getMembershipName().equals(membershipName)) {
                income += price;
            }
        }
        System.out.println("Total income from " + membershipName + ": " + income);
    }
}