package com.kaisar.gym.menu;

import com.kaisar.gym.model.*;
import com.kaisar.gym.database.*;

import java.util.Scanner;
import java.util.List;

public class GymManagementMenu implements Menu{
    private SessionDAO sessionDAO;
    private static Scanner scanner;

    public GymManagementMenu(){
        this.sessionDAO = new SessionDAO();
        this.scanner = new Scanner(System.in);

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       GYM MANAGEMENT SYSTEM v2.0       ║");
        System.out.println("║     Week 8: Fully Database-Driven      ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("✅ All data is stored in PostgreSQL");
        System.out.println("✅ No in-memory ArrayLists");
        System.out.println("✅ Complete CRUD operations");
    }

    @Override
    public void displayMenu(){
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         MAIN MENU - Week 8             ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("┌─ STAFF MANAGEMENT ─────────────────────┐");
        System.out.println("│ 1. Add Strength Workout Session        │");
        System.out.println("│ 2. Add Yoga Workout Session            │");
        System.out.println("│ 3. View All Workout Sessions           │");
        System.out.println("│ 4. View Strength Workout Session Only  │");
        System.out.println("│ 5. View Yoga Workout Session Only      │");
        System.out.println("│ 6. Update Session                      │");
        System.out.println("│ 7. Delete Session                      │");
        System.out.println("├─ SEARCH & FILTER ──────────────────────┤");
        System.out.println("│ 8. Search by Name                      │");
        System.out.println("│ 9. Search by Duration Minute Range     │");
        System.out.println("│10. High-intensive sessions(X >= 60)    │");
        System.out.println("├─ DEMO & OTHER ─────────────────────────┤");
        System.out.println("│11. Polymorphism Demo                   │");
        System.out.println("│ 0. Exit                                │");
        System.out.println("└────────────────────────────────────────┘");
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
                        updateMember();
                        break;
                    case 7:
                        deleteMember();
                        break;
                    case 8:
                        searchByName();
                        break;
                    case 9:
                        searchByRange();
                        break;
                    case 10:
                        searchByMin();
                        break;
                    case 11:
                        demonstratePolymorphism();
                        break;
                    case 0:
                        running = false;  // Exit loop
                        System.out.println("\n╔════════════════════════════════════════╗");
                        System.out.println("║  Thank you for using our system!       ║");
                        System.out.println("║  Goodbye! 👋                           ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
                    default:
                        System.out.println("\n❌ Invalid choice! Please select 0-11.");
                }

                if (choice != 0) {
                    pressEnterToContinue();
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Please enter a valid number!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                scanner.nextLine();
                pressEnterToContinue();
            }
        }

        scanner.close();
    }

    // ========================================
    // CREATE OPERATIONS
    // ========================================

    private void addStrengthWorkout(){
        try {
            System.out.println("\n┌─ ADD Strength Workout ─────────────────┐");

            System.out.print("│ Enter Session ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter Member Name: ");
            String memberName = scanner.nextLine();

            System.out.print("│ Enter Trainer Name: ");
            String trainerName = scanner.nextLine();

            System.out.print("│ Enter Duration Minutes: ");
            int durationMinutes = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter Muscle Group: ");
            String muscleGroup = scanner.nextLine();

            System.out.print("│ Enter amount of repetitions: ");
            int repetitions = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter amount of sets: ");
            int sets = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter rest time (minutes): ");
            int restMinutes = scanner.nextInt();
            scanner.nextLine();

            System.out.println("└────────────────────────────────────────┘");

            StrengthWorkout workout = new StrengthWorkout(id, memberName, trainerName, durationMinutes, muscleGroup, sets, repetitions, restMinutes);
            sessionDAO.insertStrengthWorkoutSession(workout);

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    private void addYogaWorkout(){
        try {
            System.out.println("\n┌─ ADD Yoga Workout ─────────────────────┐");

            System.out.print("│ Enter Session ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter Member Name: ");
            String memberName = scanner.nextLine();

            System.out.print("│ Enter Trainer Name: ");
            String trainerName = scanner.nextLine();

            System.out.print("│ Enter Duration Minutes: ");
            int durationMinutes = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter Yoga Style: ");
            String yogaStyle = scanner.nextLine();

            System.out.print("│ Enter Difficulty Level: ");
            int difficultyLevel = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Is Meditation Included(yes/no): ");
            String isMeditationIncluded = scanner.nextLine();

            boolean meditationIncluded = isMeditationIncluded.equals("yes");


            System.out.println("└────────────────────────────────────────┘");

            YogaWorkout workout = new YogaWorkout(id, memberName, trainerName, durationMinutes, yogaStyle, difficultyLevel, meditationIncluded);
            sessionDAO.insertYogaWorkoutSession(workout);

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    // ========================================
    // READ OPERATIONS
    // ========================================

    private void viewAllWorkoutSessions(){
        sessionDAO.displayAllWorkoutSession();
    }

    private void viewStrengthWorkouts(){
        List<StrengthWorkout> strengthWorkoutList = sessionDAO.getAllStrengthWorkouts();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         STRENGTH WORKOUT ONLY          ║");
        System.out.println("╚════════════════════════════════════════╝");

        if(strengthWorkoutList.isEmpty()){
            System.out.println("\uD83D\uDCED No Strength Workouts in database.");
        } else{
            for(int i = 0; i < strengthWorkoutList.size(); i++){
                StrengthWorkout strengthWorkout = strengthWorkoutList.get(i);
                System.out.println((i + 1) + ". " + strengthWorkout.toString());
                System.out.println("\uD83C\uDFCB️\u200D♂️ This session total amount of " + strengthWorkout.getTotalReps() + "reps.");
                System.out.println();
            }
            System.out.println("\uD83D\uDCAATotal Strength Workouts: " + strengthWorkoutList.size());
        }
    }

    private void viewYogaWorkouts(){
        List<YogaWorkout> yogaWorkoutList = sessionDAO.getAllYogaWorkouts();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         YOGA WORKOUT ONLY              ║");
        System.out.println("╚════════════════════════════════════════╝");

        if(yogaWorkoutList.isEmpty()){
            System.out.println("\uD83D\uDCED No Yoga Workouts in database.");
        } else{
            for(int i = 0; i < yogaWorkoutList.size(); i++){
                YogaWorkout yogaWorkout = yogaWorkoutList.get(i);
                System.out.println((i + 1) + ". " + yogaWorkout.toString());
                if(yogaWorkout.isMeditativeSession()){
                    System.out.println("\uD83E\uDDD8\u200D♀️ This is a Meditative Session. ");
                }
                System.out.println();
            }
            System.out.println("\uD83E\uDEB7Total Yoga Workouts: " + yogaWorkoutList.size());
        }
    }

    // ========================================
    // UPDATE OPERATIONS
    // ========================================

    private void updateMember(){
        System.out.println("\n┌─ UPDATE SESSION ───────────────────────────┐");
        System.out.print("│ Enter Session ID to update: ");

        try{
            int sessionsId = scanner.nextInt();
            scanner.nextLine();

            WorkoutSession existingSession = sessionDAO.getWorkoutSessionById(sessionsId);

            if(existingSession == null){
                System.out.println("❌ No Session found with ID: " + sessionsId);
                return;
            }

            // Display current info
            System.out.println("│ Current Info:");
            System.out.println("│ " + existingSession.toString());
            System.out.println("└────────────────────────────────────────┘");

            // Get new values
            System.out.println("\n┌─ ENTER NEW VALUES ─────────────────────┐");
            System.out.println("│ (Press Enter to keep current value)    │");

            System.out.print("│ New Member Name [" + existingSession.getMember() + "]: ");
            String newMemberName = scanner.nextLine();
            if (newMemberName.trim().isEmpty()) {
                newMemberName = existingSession.getMember();
            }

            System.out.print("│ New Trainer Name [" + existingSession.getTrainer() + "]: ");
            String newTrainerName = scanner.nextLine();
            if (newTrainerName.trim().isEmpty()) {
                newTrainerName = existingSession.getTrainer();
            }

            System.out.print("│ New Duration time [" + existingSession.getDurationMinutes() + "]: ");
            String durationMinutesInput = scanner.nextLine();
            int newDurationMinutes = durationMinutesInput.trim().isEmpty() ?
                    existingSession.getDurationMinutes() : Integer.parseInt(durationMinutesInput);

            if(existingSession instanceof StrengthWorkout){
                StrengthWorkout strengthWorkout = (StrengthWorkout) existingSession;
                
                System.out.print("│ New Muscle Group [" + strengthWorkout.getMuscleGroup() + "]: ");
                String newMuscleGroup = scanner.nextLine();
                if(newMuscleGroup.trim().isEmpty()) {
                    newMuscleGroup = strengthWorkout.getMuscleGroup();
                }

                System.out.print("│ New sets [" + strengthWorkout.getSets() + "]: ");
                String setsInput = scanner.nextLine();
                int newSets = setsInput.trim().isEmpty() ?
                        strengthWorkout.getSets() : Integer.parseInt(setsInput);

                System.out.print("│ New reps [" + strengthWorkout.getReps() + "]: ");
                String repsInput = scanner.nextLine();
                int newReps = repsInput.trim().isEmpty() ?
                        strengthWorkout.getReps() : Integer.parseInt(repsInput);

                System.out.print("│ New restMinutes [" + strengthWorkout.getRestMinutes() + "]: ");
                String restMinutesInput = scanner.nextLine();
                int newRestMinutes = restMinutesInput.trim().isEmpty() ?
                        strengthWorkout.getRestMinutes() : Integer.parseInt(restMinutesInput);
                
                StrengthWorkout updatedStrengthWorkout = new StrengthWorkout(sessionsId, newMemberName, newTrainerName, newDurationMinutes, newMuscleGroup, newSets, newReps, newRestMinutes);
                sessionDAO.updateStrengthWorkout(updatedStrengthWorkout);

            } else if(existingSession instanceof YogaWorkout){
                YogaWorkout yogaWorkout = (YogaWorkout) existingSession;

                System.out.print("│ New Yoga Style [" + yogaWorkout.getYogaStyle() + "]: ");
                String newYogaStyle = scanner.nextLine();
                if(newYogaStyle.trim().isEmpty()) {
                    newYogaStyle = yogaWorkout.getYogaStyle();
                }

                System.out.print("│ New Difficulty Level [" + yogaWorkout.getDifficultyLevel() + "]: ");
                String difficultyInput = scanner.nextLine();
                int newDifficultyLevel = difficultyInput.trim().isEmpty() ?
                        yogaWorkout.getDifficultyLevel() : Integer.parseInt(difficultyInput);

                System.out.print("│ New Meditation Included [" + yogaWorkout.isMeditationIncluded() + "]: ");
                String meditationIncludedInput = scanner.nextLine();
                boolean newMeditationIncluded = meditationIncludedInput.trim().isEmpty()?
                        yogaWorkout.isMeditationIncluded() : Boolean.parseBoolean(meditationIncludedInput);

                YogaWorkout updatedYogaWorkout = new YogaWorkout(sessionsId, newMemberName, newTrainerName, newDurationMinutes, newYogaStyle, newDifficultyLevel, newMeditationIncluded);
                sessionDAO.updateYogaWorkout(updatedYogaWorkout);
            }

            System.out.println("└────────────────────────────────────────┘");

        } catch(NumberFormatException e){
            System.out.println("❌ Error: Invalid number format!");
        } catch(IllegalArgumentException e){
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    // ========================================
    // DELETE OPERATIONS
    // ========================================

    private void deleteMember(){
        System.out.println("\n┌─ DELETE SESSION ───────────────────────────┐");
        System.out.print("│ Enter Session ID to delete: ");

        try{
           int sessionId = scanner.nextInt();
           scanner.nextLine();

           WorkoutSession workoutSession = sessionDAO.getWorkoutSessionById(sessionId);

           if(workoutSession == null){
               System.out.println("❌ No session found with ID: " + sessionId);
               return;
           }

           System.out.println("│ Session to delete:");
           System.out.println("│ " + workoutSession.toString());
           System.out.println("└────────────────────────────────────────┘");

            System.out.print("⚠️  Are you sure? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                sessionDAO.deleteWorkoutSession(sessionId);
            } else {
                System.out.println("❌ Deletion cancelled.");
            }

        } catch(java.util.InputMismatchException e){
            System.out.println("❌ Error: Invalid input!");
            scanner.nextLine();
        }
    }

    // ========================================
    // SEARCH OPERATIONS (Week 8)
    // ========================================

    private void searchByName(){
        System.out.println("\n┌─ SEARCH BY NAME ───────────────────────┐");
        System.out.print("│ Enter name to search: ");
        String name = scanner.nextLine();
        System.out.println("└────────────────────────────────────────┘");

        List<WorkoutSession> results = sessionDAO.searchByName(name);

        displaySearchResults(results, "Search: '" + name + "'");
    }

    private void searchByRange(){
        try {
            System.out.println("\n┌─ SEARCH BY SALARY RANGE ───────────────┐");
            System.out.print("│ Enter minimum duration in minutes: ");
            int minMinutes = scanner.nextInt();

            System.out.print("│ Enter maximum duration in minutes: ");
            int maxMinutes = scanner.nextInt();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<WorkoutSession> results = sessionDAO.searchByDurationMinutesRange(minMinutes, maxMinutes);

            displaySearchResults(results, "Range: " + minMinutes + " - " + maxMinutes + " minutes");

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }

    private void searchByMin(){
        try {
            System.out.println("\n┌─ HIGH-INTENSIVE SESSION────────────────┐");
            System.out.print("│ Enter minimum duration in minutes: ");
            int minMinutes = scanner.nextInt();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<WorkoutSession> results = sessionDAO.searchByMinDurationMinutes(minMinutes);

            displaySearchResults(results, "Duration >= " + minMinutes + " minutes");

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }

    private void displaySearchResults(List<WorkoutSession> results, String criteria) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         SEARCH RESULTS                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Criteria: " + criteria);
        System.out.println("─────────────────────────────────────────");

        if (results.isEmpty()) {
            System.out.println("📭 No session found matching criteria.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                WorkoutSession w = results.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + w.getWorkoutType() + "] ");
                System.out.println(w.toString());
            }
            System.out.println("─────────────────────────────────────────");
            System.out.println("Total Results: " + results.size());
        }
    }

    private void demonstratePolymorphism(){
        sessionDAO.demonstratePolymorphism();
    }

    // ========================================
    // HELPER METHOD
    // ========================================

    private void pressEnterToContinue() {
        System.out.println("\n[Press Enter to continue...]");
        scanner.nextLine();
    }
}