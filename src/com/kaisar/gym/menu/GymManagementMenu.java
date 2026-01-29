package com.kaisar.gym.menu;

import com.kaisar.gym.model.*;
import com.kaisar.gym.exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class GymManagementMenu implements Menu{
    private static ArrayList<Member> members;
    private static ArrayList<Trainer> trainers;
    private static ArrayList<Membership> memberships;
    private static ArrayList<WorkoutSession> workoutSessions;
    private static Scanner scanner;

    public GymManagementMenu(){
        this.members = new ArrayList<>();
        this.trainers = new ArrayList<>();
        this.memberships = new ArrayList<>();
        this.workoutSessions = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        //add test data
        try{
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
            trainers.add(new Trainer(2, "Jose Mourinho", "Football Trainer", 34));
            trainers.add(new Trainer(3, "Arnold Schwarzenegger", "Bodybuilding", 62));

           //Adding test workoutSession objects
        /*  workoutSessions.add(new WorkoutSession(1011, trainers.getFirst(), 15));
            workoutSessions.add(new WorkoutSession(1012, trainers.get(1), 90));
            workoutSessions.add(new WorkoutSession(1013, 60)); */

            workoutSessions.add(new YogaWorkout(4029, trainers.getFirst(), 60, "Yin", 5, true));
            workoutSessions.add(new YogaWorkout(4028, trainers.getFirst(), 90, "Default", 1, false));

            workoutSessions.add(new StrengthWorkout(3045, trainers.getLast(), 45, "Chest", 4, 3, 2));
            workoutSessions.add(new StrengthWorkout(3046, trainers.getLast(), 90, "Pull", 6, 4, 3));


            workoutSessions.get(0).addMember(members.get(0));
            workoutSessions.get(0).addMember(members.get(1));
            workoutSessions.get(1).addMember(members.get(0));
            workoutSessions.get(1).addMember(members.get(1));
            workoutSessions.get(1).addMember(members.get(2));
        } catch (IllegalArgumentException e){
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu(){
        System.out.println("\n========================================");
        System.out.println("  GYM MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Strength Workout");
        System.out.println("2. Add Yoga Workout");
        System.out.println("3. View All Objects");
        System.out.println("4. View Strength Workouts Only");
        System.out.println("5. View Yoga Workouts Only");
        System.out.println("6. Count Burned Calories of All Objects");
        System.out.println("7. Add Member");
        System.out.println("8. View All Members");
        System.out.println("9. Upgrade Member's membership");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    @Override
    public void run(){
        //Menu loop - continues until user exists
        boolean running = true;

        while (running) {
            displayMenu(); //Show menu options
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt(); // Read user's choice
                scanner.nextLine(); // IMPORTANT: consume leftover newline

                switch (choice) {
                    case 1:
                        addStrengthWorkout();
                        break;
                    case 2:
                        addYogaWorkout();
                        break;
                    case 3:
                        viewAllWorkoutSessions();
                        break;
                    case 4:
                        viewStrengthWorkouts();
                        break;
                    case 5:
                        viewYogaWorkouts();
                        break;
                    case 6:
                        demonstratePolymorphism();
                        break;
                    case 7:
                        addMember();
                        break;
                    case 8:
                        viewAllMembers();
                        break;
                    case 9:
                        upgradeMember();
                        break;
                    case 0:
                        running = false;  // Exit loop
                        System.out.println("\nGoodbye! 👋 ");
                        break;
                    default:
                        System.out.println("\n❌ Invalid choice! Please select 0-6.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Please enter a valid number!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void addMember() {
        try {
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
        } catch (java.util.InputMismatchException e){
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch(IllegalArgumentException e){
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
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
        try {
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
        } catch (java.util.InputMismatchException e){
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch(IllegalArgumentException e){
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
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
        try {
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
        } catch (java.util.InputMismatchException e){
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch(IllegalArgumentException e){
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
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

/*    private static void addWorkoutSession(){
        try {
            System.out.println("\n--- Add Workout Session ---");

            //Ask for each field
            System.out.println("Enter Workout Session ID: ");
            int sessionId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Choose Trainer: ");
            Trainer trainer = null;
            for (int i = 0; i < trainers.size(); i++) {
                Trainer t = trainers.get(i);
                System.out.println((i + 1) + ". " + t.getTrainerName());
            }
            System.out.println("0. Null");
            System.out.print("Number: ");
            int trainerChoice = scanner.nextInt() - 1; // Read user's choice
            scanner.nextLine();
            if (trainerChoice != -1) {
                trainer = trainers.get(trainerChoice);
            }

            System.out.println("Enter Duration Minutes: ");
            int durationMinutes = scanner.nextInt();
            scanner.nextLine();

            //Create new object
            WorkoutSession workoutSession = new WorkoutSession(sessionId, trainer, durationMinutes);

            //Add to ArrayList
            workoutSessions.add(workoutSession);

            boolean memberChoosing = true;
            while (memberChoosing) {
                System.out.println("--- Choose Members to add ---");
                for (int i = 0; i < members.size(); i++) {
                    Member member = members.get(i);
                    System.out.println((i + 1) + ". " + member.getFullName());
                }
                System.out.println("0. Any other number to finish");

                System.out.print("Number: ");
                int memberChoice = scanner.nextInt() - 1; // Read user's choice
                scanner.nextLine();

                if (memberChoice >= members.size() || memberChoice < 0) {
                    System.out.println("Finished!");
                    memberChoosing = false;
                } else if (workoutSession.addMember(members.get(memberChoice))) {
                    workoutSession.addMember(members.get(memberChoice));
                    System.out.println("✅ Member added successfully! Choose another one...");
                } else {
                    System.out.println("❌ Member is already in Workout Session! Choose another...");
                }
                System.out.println();
            }

            System.out.println("✅ Workout Session added successfully!");
        } catch (java.util.InputMismatchException e){
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch(IllegalArgumentException e){
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    } */

    private static void addStrengthWorkout(){
        try {
            System.out.println("\n--- Add Strength Workout Session ---");

            System.out.println("Enter Workout Session ID: ");
            int sessionId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Choose Trainer: ");
            Trainer trainer = null;
            for (int i = 0; i < trainers.size(); i++) {
                Trainer t = trainers.get(i);
                System.out.println((i + 1) + ". " + t.getTrainerName());
            }
            System.out.println("0. Null");
            System.out.print("Number: ");
            int trainerChoice = scanner.nextInt() - 1; // Read user's choice
            scanner.nextLine();
            if (trainerChoice != -1) {
                trainer = trainers.get(trainerChoice);
            }

            System.out.println("Enter Duration Minutes: ");
            int durationMinutes = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Muscle Group: ");
            String muscleGroup = scanner.nextLine();

            System.out.println("Enter Sets Amount: ");
            int sets = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Reps Amount: ");
            int reps = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Rest Minutes: ");
            int restMinutes = scanner.nextInt();
            scanner.nextLine();

            WorkoutSession workoutSession = new StrengthWorkout(sessionId, trainer, durationMinutes, muscleGroup, sets, reps, restMinutes);

            workoutSessions.add(workoutSession);

            boolean memberChoosing = true;
            while (memberChoosing) {
                System.out.println("--- Choose Members to add ---");
                for (int i = 0; i < members.size(); i++) {
                    Member member = members.get(i);
                    System.out.println((i + 1) + ". " + member.getFullName());
                }
                System.out.println("0. Done");

                System.out.print("Number: ");
                int memberChoice = scanner.nextInt() - 1; // Read user's choice
                scanner.nextLine();

                if (memberChoice >= members.size() || memberChoice < 0) {
                    System.out.println("Finished!");
                    memberChoosing = false;
                } else if (workoutSession.addMember(members.get(memberChoice))) {
                    workoutSession.addMember(members.get(memberChoice));
                    System.out.println("✅ Member added successfully! Choose another one...");
                } else {
                    System.out.println("❌ Member is already in Workout Session! Choose another...");
                }
                System.out.println();
            }

            System.out.println("✅ Strength Workout Session added successfully!");
        } catch (java.util.InputMismatchException e){
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch(IllegalArgumentException e){
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    private static void addYogaWorkout(){
        try {
            System.out.println("\n--- Add Yoga Workout Session ---");

            System.out.println("Enter Workout Session ID: ");
            int sessionId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Choose Trainer: ");
            Trainer trainer = null;
            for (int i = 0; i < trainers.size(); i++) {
                Trainer t = trainers.get(i);
                System.out.println((i + 1) + ". " + t.getTrainerName());
            }
            System.out.println("0. Null");
            System.out.print("Number: ");
            int trainerChoice = scanner.nextInt() - 1; // Read user's choice
            scanner.nextLine();
            if (trainerChoice != -1) {
                trainer = trainers.get(trainerChoice);
            }

            System.out.println("Enter Duration Minutes: ");
            int durationMinutes = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Yoga Style: ");
            String yogaStyle = scanner.nextLine();

            System.out.println("Enter Difficulty Level: ");
            int difficultyLevel = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Meditation Included: ");
            boolean meditationIncluded = scanner.nextBoolean();
            scanner.nextLine();

            WorkoutSession workoutSession = new YogaWorkout(sessionId, trainer, durationMinutes, yogaStyle, difficultyLevel, meditationIncluded);

            workoutSessions.add(workoutSession);

            boolean memberChoosing = true;
            while (memberChoosing) {
                System.out.println("--- Choose Members to add ---");
                for (int i = 0; i < members.size(); i++) {
                    Member member = members.get(i);
                    System.out.println((i + 1) + ". " + member.getFullName());
                }
                System.out.println("0. Done");

                System.out.print("Number: ");
                int memberChoice = scanner.nextInt() - 1; // Read user's choice
                scanner.nextLine();

                if (memberChoice >= members.size() || memberChoice < 0) {
                    System.out.println("Finished!");
                    memberChoosing = false;
                } else if (workoutSession.addMember(members.get(memberChoice))) {
                    workoutSession.addMember(members.get(memberChoice));
                    System.out.println("✅ Member added successfully! Choose another one...");
                } else {
                    System.out.println("❌ Member is already in Workout Session! Choose another...");
                }
                System.out.println();
            }

            System.out.println("✅ Yoga Workout Session added successfully!");
        } catch (java.util.InputMismatchException e){
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch(IllegalArgumentException e){
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    private static void viewAllWorkoutSessions(){
        System.out.println("\n========================================");
        System.out.println("         ALL WORKOUT SESSIONS(POLYMORPHIC LIST)");
        System.out.println("========================================");

        if (workoutSessions.isEmpty()) {
            System.out.println("No workout session found");
            return;
        }

        System.out.println("Total workout sessions: " + workoutSessions.size());
        System.out.println();

        for (int i = 0; i < workoutSessions.size(); i++) {
            WorkoutSession w = workoutSessions.get(i); //Get member at index i

            System.out.println((i+1)+ ". " + w);

            if(w instanceof YogaWorkout yogaWorkout){
                if(yogaWorkout.isMeditativeSession()){
                    System.out.println("  \uD83E\uDDD8\u200D♀️ This is a Meditative Session. ");
                }
            } else if(w instanceof StrengthWorkout strengthWorkout){
                System.out.println("  \uD83C\uDFCB️\u200D♂️ This session total amount of " + strengthWorkout.getTotalReps() + "reps.");
            }
        }

        System.out.println();
    }

    private static void demonstratePolymorphism(){
        System.out.println("\n========================================");
        System.out.println("   POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling calculateCaloriesBurned() on all sessions:");
        System.out.println();

        for(WorkoutSession w: workoutSessions){
            System.out.println("[ " + w.getSessionId() + " ] This " + w.getWorkoutType() + " session burned calories total amount of: " + w.calculateCaloriesBurned());
        }

        System.out.println();
    }

    private static void viewStrengthWorkouts(){
        System.out.println("\n========================================");
        System.out.println("         STRENGTH WORKOUT ONLY");
        System.out.println("========================================");

        int strengthWorkoutCount = 0;
        for(WorkoutSession w: workoutSessions){
            if(w instanceof StrengthWorkout){
                StrengthWorkout strengthWorkout = (StrengthWorkout) w;
                strengthWorkoutCount++;

                System.out.println(strengthWorkoutCount + ". " + strengthWorkout.getWorkoutType() + " (" + strengthWorkout.getSessionId() + ")");
                System.out.println("  Muscle Group: " + strengthWorkout.getMuscleGroup());
                System.out.println("  Sets: " + strengthWorkout.getSets());
                System.out.println("  Reps: " + strengthWorkout.getReps());
                System.out.println("  Rest Minutes: " + strengthWorkout.getRestMinutes());
                System.out.println("\uD83C\uDFCB️\u200D♂️ This session total amount of " + strengthWorkout.getTotalReps() + "reps.");
                System.out.println();
            }
        }
        if(strengthWorkoutCount == 0){
            System.out.println("No Strength Workout Sessions found.");
        }
    }

    private static void viewYogaWorkouts(){
        System.out.println("\n========================================");
        System.out.println("         YOGA WORKOUT ONLY");
        System.out.println("========================================");

        int yogaWorkoutCount = 0;
        for(WorkoutSession w: workoutSessions){
            if(w instanceof YogaWorkout){
                YogaWorkout yogaWorkout = (YogaWorkout) w;
                yogaWorkoutCount++;

                System.out.println(yogaWorkoutCount + ". " + yogaWorkout.getWorkoutType() + " (" + yogaWorkout.getSessionId() + ")");
                System.out.println("  Yoga Style: " + yogaWorkout.getYogaStyle());
                System.out.println("  Difficulty Level: " + yogaWorkout.getDifficultyLevel());
                System.out.println("  Meditation Included: " + yogaWorkout.isMeditationIncluded());

                if(yogaWorkout.isMeditativeSession()){
                    System.out.println("\uD83E\uDDD8\u200D♀️ This is a Meditative Session. ");
                }

                System.out.println();
            }
        }
        if(yogaWorkoutCount == 0){
            System.out.println("No Yoga Workout Sessions found.");
        }
    }

    private void upgradeMember() {
        System.out.println("\n--- Upgrade Member's Membership ---");

        if(members.isEmpty()){
            System.out.println("❌ No member available to upgrade!");
            return;
        }

        System.out.println("Available Members:");

        for(int i = 0; i < members.size(); i++){
            System.out.println((i+1) + ". " + members.get(i).getFullName());
        }

        try {
            System.out.print("Select member number to upgrade: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            if (choice < 1 || choice > members.size()) {
                throw new InvalidInputException("Invalid member number!");
            }

            Member member = members.get(choice - 1);
            member.upgrade();
            System.out.println("Membership can be upgraded again: " + member.canUpgrade() + (member.canUpgrade()? "✅" : "❌"));

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Please enter a valid number!");
            scanner.nextLine();
        } catch (InvalidInputException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}