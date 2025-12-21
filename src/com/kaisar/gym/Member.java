package com.kaisar.gym;

import java.util.ArrayList;

public class Member {
    private int memberId;
    private String fullName;
    private int age;
    private Membership membership;

    //constructor
    public Member(int memberId, String fullName, int age, Membership membership) {
        this.memberId = memberId;
        this.fullName = fullName;
        this.age = age;
        this.membership = membership;
    }

    //getters and setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    //toString() method
    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", membership='" + membership.getMembershipName() + '\'' +
                '}';
    }

    //additional methods
    public double costOfAppliedDiscount(double discount){
        double price = getMembership().getPrice();
        return price - price*(discount/100);
    }

    public void upgradeMembership(Membership advanced, Membership premium){
        String membershipName = membership.getMembershipName();
        if(membershipName.equals("Basic")){
            membership = advanced;
            System.out.println(getFullName() + "'s membership upgraded to Advanced");
        } else if(membershipName.equals("Advanced")){
            membership = premium;
            System.out.println(getFullName() + "'s membership upgraded to Premium");
        } else{
            System.out.println(getFullName() + "'s membership already at highest level");
        }
    }
}