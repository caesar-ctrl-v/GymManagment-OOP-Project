package com.kaisar.gym;

import java.util.ArrayList;

public class Member {
    private int memberId;
    private String fullName;
    private int age;
    private String membershipName;

    //constructor
    public Member(int memberId, String fullName, int age, String membershipName) {
        this.memberId = memberId;
        this.fullName = fullName;
        setAge(age);
        this.membershipName = membershipName;
    }

    //getters and setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        if(memberId >= 0) {
            this.memberId = memberId;
        } else{
            System.out.println("Warning: Member ID cannot be negative!");
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if(fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        } else{
            System.out.println("Warning: Full Name cannot be empty!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 0){
            this.age = age;
        } else{
            System.out.println("Warning: Age cannot be negative!");
        }
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        if(membershipName != null && !membershipName.trim().isEmpty()){
            this.membershipName = membershipName;
        } else{
            System.out.println("Warning: Membership Name cannot be empty");
        }
    }

    //toString() method
    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", membershipName='" + membershipName + '\'' +
                '}';
    }

    //additional methods
    public boolean isAdult(){
        return age >= 18;
    }

    public void updateMembership(){
        if(membershipName.equals("Basic")){
            setMembershipName("Advanced");
        } else if(membershipName.equals("Advanced")){
            setMembershipName("Premium");
        } else{
            System.out.println("Membership already at highest level!");
        }
    }
}