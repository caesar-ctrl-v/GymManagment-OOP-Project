package com.kaisar.gym.model;

public class Member implements Upgradable{
    private int memberId;
    private String fullName;
    private int age;
    private String membershipName;

    //constructor
    public Member(int memberId, String fullName, int age, String membershipName) {
        setMemberId(memberId);
        setFullName(fullName);
        setAge(age);
        setMembershipName(membershipName);
    }

    //getters and setters
    public int getMemberId() {
        return memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMemberId(int memberId) {
        if(memberId <= 0){
            throw new IllegalArgumentException("Member ID must be greater than 0");
        }
        this.memberId = memberId;
    }

    public void setFullName(String fullName) {
        if(fullName == null || fullName.trim().isEmpty()){
            throw new IllegalArgumentException("Full Name cannot be empty");
        }
        this.fullName = fullName;
    }

    public void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        this.age = age;
    }

    public void setMembershipName(String membershipName) {
        if(membershipName == null || membershipName.trim().isEmpty()){
            throw new IllegalArgumentException("Membership Name cannot be empty");
        }
        this.membershipName = membershipName;
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

    @Override
    public void upgrade(){
        System.out.println("Membership upgraded successfully!");
        if(membershipName.equals("Basic")){
            setMembershipName("Advanced");
        } else{
            setMembershipName("Premium");
        }
    }

    @Override
    public boolean canUpgrade(){
        return !membershipName.equals("Premium");
    }
}