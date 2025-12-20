package com.kaisar.gym;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Gym Management System ===");
        System.out.println();

        //create memberships
        Membership premium = new Membership("Premium", 90, 39990, true);
        Membership advanced = new Membership("Advanced", 90, 34990, false);
        Membership basic= new Membership("Basic", 30, 9990, true);

        //create members
        Member member1 = new Member(1, "Kaisar Kyilau", 19, premium);
        Member member2 = new Member(2,"Gaziz Zhaksybay", 18, basic);
        Member member3 = new Member(3, "Alsu Abdibait", 17, premium);

        //create trainers
        Trainer trainer1 = new Trainer(1, "Mike Tyson", "Boxing Trainer", 40);
        Trainer trainer2 = new Trainer(2, "Jose Mourinho", "Football Trainer", 34);

        //create workoutSessions
        WorkoutSession workoutSession1 = new WorkoutSession(1, "Mike Tyson", 15);
        WorkoutSession workoutSession2 = new WorkoutSession(2, "Jose Mourinho", 90);

        //adding members to workoutSessions
        workoutSession1.getMembers().add(member1);
        workoutSession1.getMembers().add(member2);

        //checking every method
        //getters and setters
        System.out.println(member1);
        System.out.println(member2.getMembership());
        member3.setMembership(advanced);
        System.out.println(member3.getMembership());

        //member additional methods
        //checking costOfAppliedDiscount method
        System.out.println(member1.costOfAppliedDiscount(50));

        //checking upgradeMembership method
        member3.upgradeMembership(advanced, premium);
        System.out.println();


    }
}

