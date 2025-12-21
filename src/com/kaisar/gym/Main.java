package com.kaisar.gym;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Gym Management System ===");
        System.out.println();

        //create membership objects
        Membership premium = new Membership("Premium", 90, 39990, true);
        Membership advanced = new Membership("Advanced", 90, 34990, false);
        Membership basic= new Membership("Basic", 30, 9990, true);

        //create member objects
        Member member1 = new Member(1, "Kaisar Kyilau", 19, premium);
        Member member2 = new Member(2,"Gaziz Zhaksybay", 18, basic);
        Member member3 = new Member(3, "Yersultan Kurmanbek", 16, advanced);
        ArrayList<Member> members = new ArrayList<>();
        members.add(member1);
        members.add(member2);
        members.add(member3);

        //create trainer objects
        Trainer trainer1 = new Trainer(1, "Mike Tyson", "Boxing Trainer", 40);
        Trainer trainer2 = new Trainer(2, "Jose Mourinho", "Basketball Trainer", 34);
        Trainer trainer3 = new Trainer(3, "Arnold Schwarzenegger", "Bodybuilding", 62);

        //create workoutSession objects
        WorkoutSession workoutSession1 = new WorkoutSession(1, "Mike Tyson", 15);
        WorkoutSession workoutSession2 = new WorkoutSession(2, "Gennady Golovkin", 90);
        WorkoutSession workoutSession3 = new WorkoutSession(3, 60);
        ArrayList<WorkoutSession> sessions = new ArrayList<>();
        sessions.add(workoutSession1);
        sessions.add(workoutSession2);

        //adding members to workoutSession objects
        workoutSession1.getMembers().add(member1);
        workoutSession1.getMembers().add(member2);

        //displaying all objects
        System.out.println("--- MEMBERS ---");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);
        System.out.println();
        System.out.println("--- TRAINERS ---");
        System.out.println(trainer1);
        System.out.println(trainer2);
        System.out.println(trainer3);
        System.out.println();
        System.out.println("--- MEMBERSHIPS ---");
        System.out.println(basic);
        System.out.println(advanced);
        System.out.println(premium);
        System.out.println();
        System.out.println("--- WORKOUT SESSIONS ---");
        System.out.println(workoutSession1);
        System.out.println(workoutSession2);
        System.out.println(workoutSession3);
        System.out.println();

        //testing getters
        System.out.println("--- TESTING GETTERS ---");
        System.out.println("Member 1 fullName: " + member1.getFullName());
        System.out.println("Member 1 age: " + member1.getAge());
        System.out.println("Trainer 1 specialization: " + trainer1.getSpecialization());
        System.out.println("Basic price: " + basic.getPrice());
        System.out.println("Workout Session 1 members: " + workoutSession1.getMembers());
        System.out.println();

        //testing setters
        System.out.println("--- TESTING SETTERS ---");
        System.out.println("Updating member3...");
        member3.setFullName("Alsu Abdibait");
        member3.setAge(17);
        member3.setMembership(premium);
        System.out.println("Updated: " + member3);

        System.out.println("\nUpdating trainer2...");
        trainer2.setSpecialization("Football Trainer");
        System.out.println("Updated: " + trainer2);

        System.out.println("\nUpdating advanced...");
        advanced.setWorkoutDays(180);
        System.out.println("Updated: " + advanced);

        System.out.println("\nUpdating workoutSession2...");
        workoutSession2.setMembers(members);
        System.out.println("Updated: " + workoutSession2);
        System.out.println();

        //testing additional methods
        System.out.println("--- TESTING MEMBER METHODS ---");
        System.out.println("Applying 50% discount to " + member1.getFullName() + "'s membership");
        System.out.println("Price after applied discount: " + member1.costOfAppliedDiscount(50));
        member2.upgradeMembership(advanced, premium);
        member3.upgradeMembership(advanced, premium);
        System.out.println();

        System.out.println("--- TESTING TRAINER METHODS ---");
        System.out.println(trainer1.getTrainerName() + " is active: " + trainer1.isActive(sessions));
        System.out.println(trainer2.getTrainerName() + " is experienced: " + trainer2.isExperienced());
        System.out.println();

        System.out.println("--- TESTING MEMBERSHIP METHODS ---");
        System.out.println("Number of users using " + basic.getMembershipName() + " membership: " + basic.users(members));
        System.out.println("Checking income from " + premium.getMembershipName() + "...");
        premium.income(members);
        System.out.println();

        System.out.println("--- TESTING WORKOUT SESSION METHODS ---");
        System.out.println("WorkoutSession1 member names: " + workoutSession1.getMemberNames());
        System.out.println("WorkoutSession2 member ages: " + workoutSession2.getMemberAges());
        System.out.println("WorkoutSession2 type: " + workoutSession1.findWorkoutSessionType());
        System.out.println();

        System.out.println("--- FINAL STATE ---");
        System.out.println("Members:");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);
        System.out.println();

        System.out.println("Trainers:");
        System.out.println(trainer1);
        System.out.println(trainer2);
        System.out.println(trainer3);
        System.out.println();

        System.out.println("Memberships:");
        System.out.println(basic);
        System.out.println(advanced);
        System.out.println(premium);
        System.out.println();

        System.out.println("Workout Sessions:");
        System.out.println(workoutSession1);
        System.out.println(workoutSession2);
        System.out.println(workoutSession3);

        System.out.println("\n=== Program Complete ===");
    }
}