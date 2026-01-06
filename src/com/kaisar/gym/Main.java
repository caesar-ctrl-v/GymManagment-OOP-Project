package com.kaisar.gym;

import java.util.Scanner;
import java.util.ArrayList; // Allows us to read user input

public class Main {
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    private static ArrayList<Membership> memberships = new ArrayList<>();
    private static ArrayList<WorkoutSession> workoutSessions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Gym Management System ===");
        System.out.println();

        //Adding test membership objects
        memberships.add(new Membership("Premium", 90, 39990, true));
        memberships.add(new Membership("Advanced", 90, 34990, false));
        memberships.add(new Membership("Basic", 30, 9990, true));

        //Adding test member objects
        members.add(new Member(1, "Kaisar Kyilau", 19, "Premium"));
        members.add(new Member(2, "Gaziz Zhaksybay", 18, "Basic"));
        members.add(new Member(3, "Yersultan Kurmanbek", 16, "Advanced"));


        //Adding test trainer objects
        trainers.add(new Trainer(1, "Mike Tyson", "Boxing Trainer", 40));
        trainers.add(new Trainer(2, "Jose Mourinho", "Basketball Trainer", 34));
        trainers.add(new Trainer(3, "Arnold Schwarzenegger", "Bodybuilding", 62));

        //Adding test workoutSession objects
        workoutSessions.add(new WorkoutSession(1, "Mike Tyson", 15));
        workoutSessions.add(new WorkoutSession(2, "Gennady Golovkin", 90));
        workoutSessions.add(new WorkoutSession(3, 60));

        workoutSessions.get(0).getMembers().add(members.get(0));
        workoutSessions.get(0).getMembers().add(members.get(1));
        workoutSessions.get(1).getMembers().add(members.get(0));
        workoutSessions.get(1).getMembers().add(members.get(1));
        workoutSessions.get(1).getMembers().add(members.get(2));


        //Menu loop - continues until user exists
        boolean running = true;
        while (running) {
            displayMenu(); //Show menu options
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // IMPORTANT: consume leftover newline
            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    viewAllMembers();
                    break;
                case 3:
                    addTrainer();
                    break;
                case 4:
                    viewAllTrainers();
                    break;
                case 5:
                    addMembership();
                    break;
                case 6:
                    viewAllMemberships();
                    break;
                case 7:
                    addWorkoutSession();
                    break;
                case 8:
                    viewAllWorkoutSessions();
                    break;
                case 0:
                    System.out.println("\nGoodbye! 👋 ");
                    running = false;  // Exit loop
                    break;
                default:
                    System.out.println("\n❌ Invalid choice!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();  // Wait for user
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("  GYM MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. Add Trainer");
        System.out.println("4. View All Trainers");
        System.out.println("5. Add Membership");
        System.out.println("6. View All Memberships");
        System.out.println("7. Add Workout Session");
        System.out.println("8. View All Workout Sessions");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static void addMember() {
        System.out.println("\n--- Add Member ---");

        //Ask for each field
        System.out.println("Enter Member ID: ");
        int memberId = scanner.nextInt(); // Read integer
        scanner.nextLine();

        System.out.println("Enter Member Full Name: ");
        String fullName = scanner.nextLine(); // Read string

        System.out.println("Enter Member Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Membership Type: ");
        String membershipName = scanner.nextLine();

        //Create new object
        Member member = new Member(memberId, fullName, age, membershipName);

        //Add to ArrayList
        members.add(member);

        System.out.println("\n✅ Member added successfully!");
    }

    private static void viewAllMembers() {
        System.out.println("\n========================================");
        System.out.println("         ALL MEMBERS");
        System.out.println("========================================");

        //Check if list is empty
        if (members.isEmpty()) {
            System.out.println("No members found");
            return;
        }

        System.out.println("Total members: " + members.size());
        System.out.println();

        //Loop through all members
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i); //Get member at index i

            System.out.println((i + 1) + ". " + member.getFullName() + " - ID: "
                    + member.getMemberId());
            System.out.println("  Age: " + member.getAge());
            System.out.println("  Membership: " + member.getMembershipName());

            System.out.println();
        }
    }

    private static void addTrainer() {
        System.out.println("\n--- Add Trainer ---");

        //Ask for each field
        System.out.println("Enter Trainer ID: ");
        int trainerId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Trainer Name: ");
        String trainerName = scanner.nextLine();

        System.out.println("Enter Specialization: ");
        String specialization = scanner.nextLine();

        System.out.println("Enter Experience Years: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();

        //Create new object
        Trainer trainer = new Trainer(trainerId, trainerName, specialization, experienceYears);

        //Add to ArrayList
        trainers.add(trainer);
        System.out.println("\n✅ Trainer added successfully!");
    }

    private static void viewAllTrainers() {
        System.out.println("\n========================================");
        System.out.println("         ALL TRAINERS");
        System.out.println("========================================");

        if (trainers.isEmpty()) {
            System.out.println("No trainer found");
            return;
        }

        System.out.println("Total trainers: " + trainers.size());
        System.out.println();

        for (int i = 0; i < trainers.size(); i++) {
            Trainer trainer = trainers.get(i); //Get member at index i

            System.out.println((i + 1) + ". " + trainer.getTrainerName() + " - ID: "
                    + trainer.getTrainerId());
            System.out.println("  Specialization: " + trainer.getSpecialization());
            System.out.println("  Experience Years: " + trainer.getExperienceYears());
            System.out.println("  Is Active: " + (trainer.isActive(workoutSessions)? "✅ Yes" : "❌ No"));
            System.out.println("  Is Experienced: " + (trainer.isExperienced()? "✅ Yes" : "❌ No"));
            System.out.println();
        }
    }

    private static void addMembership() {
        System.out.println("\n--- Add Membership ---");

        //Ask for each field
        System.out.println("Enter Membership Name: ");
        String membershipName = scanner.nextLine();

        System.out.println("Enter Workout Days: ");
        int workoutDays = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Trainer Included: ");
        boolean trainerIncluded = scanner.nextBoolean();
        scanner.nextLine();

        //Create new object
        Membership membership = new Membership(membershipName, workoutDays, price, trainerIncluded);

        //Add to ArrayList
        memberships.add(membership);
        System.out.println("\n✅ Membership added successfully!");
    }

    private static void viewAllMemberships() {
        System.out.println("\n========================================");
        System.out.println("         ALL MEMBERSHIPS");
        System.out.println("========================================");

        if (memberships.isEmpty()) {
            System.out.println("No membership found");
            return;
        }

        System.out.println("Total memberships: " + memberships.size());
        System.out.println();

        for (int i = 0; i < memberships.size(); i++) {
            Membership membership = memberships.get(i); //Get member at index i

            System.out.println((i + 1) + ". " + membership.getMembershipName());
            System.out.println("  Workout Days: " + membership.getWorkoutDays());
            System.out.println("  Price: " + membership.getPrice());
            System.out.println("  Trainer Included: " + (membership.isTrainerIncluded() ? "✅ Yes" : "❌ No"));
            System.out.println("  Number of Users: " + membership.users(members));
            System.out.println("  Total income: " + membership.income(members));
            System.out.println();

        }
    }

    private static void addWorkoutSession(){
        System.out.println("\n--- Add Workout Session ---");

        //Ask for each field
        System.out.println("Enter Workout Session ID: ");
        int sessionId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Trainer: ");
        String trainer = scanner.nextLine();

        System.out.println("Enter Duration Minutes: ");
        int durationMinutes = scanner.nextInt();
        scanner.nextLine();

        //Create new object
        WorkoutSession workoutSession = new WorkoutSession(sessionId, trainer, durationMinutes);

        //Add to ArrayList
        workoutSessions.add(workoutSession);
        System.out.println("\n✅ Workout Session added successfully!");
    }

    private static void viewAllWorkoutSessions(){
        System.out.println("\n========================================");
        System.out.println("         ALL WORKOUT SESSIONS");
        System.out.println("========================================");

        if (workoutSessions.isEmpty()) {
            System.out.println("No workout session found");
            return;
        }

        System.out.println("Total workout sessions: " + workoutSessions.size());
        System.out.println();

        for (int i = 0; i < workoutSessions.size(); i++) {
            com.kaisar.gym.WorkoutSession workoutSession = workoutSessions.get(i); //Get member at index i

            System.out.println((i + 1) + ". Session ID:" + workoutSession.getSessionId());
            System.out.println("  Members: " + workoutSession.getMemberNames());
            System.out.println("  Trainer: " + workoutSession.getTrainer());
            System.out.println("  Duration Minutes: " + workoutSession.getDurationMinutes());
            System.out.println();
        }
    }
}
