package com.kaisar.gym.database;

import com.kaisar.gym.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {
    // ========================================
    // CREATE - INSERT OPERATIONS (Week 7)
    // ========================================

    public boolean insertStrengthWorkoutSession(StrengthWorkout workout){
        String sql = "INSERT INTO workout_session (session_id, member_name, trainer_name, duration_minutes, " +
                "workout_session_type, muscle_group, sets, reps, rest_minutes, " +
                "yoga_style, difficulty_level, meditation_included) "
                + "VALUES (?, ?, ?, ?, 'Strength Workout', ?, ?, ?, ?, NULL, NULL, NULL)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, workout.getSessionId());
            statement.setString(2, workout.getMember());
            statement.setString(3, workout.getTrainer());
            statement.setInt(4, workout.getDurationMinutes());
            statement.setString(5, workout.getMuscleGroup());
            statement.setInt(6, workout.getSets());
            statement.setInt(7, workout.getReps());
            statement.setInt(8, workout.getRestMinutes());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Strength Workout Session inserted: " + workout.getSessionId());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("❌ Insert Strength Workout Session failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public boolean insertYogaWorkoutSession(YogaWorkout workout){
        String sql = "INSERT INTO workout_session (session_id, member_name, trainer_name, duration_minutes, " +
                "workout_session_type, muscle_group, sets, reps, rest_minutes, " +
                "yoga_style, difficulty_level, meditation_included) "
                + "VALUES (?, ?, ?, ?, 'Yoga Workout', NULL, NULL, NULL, NULL, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, workout.getSessionId());
            statement.setString(2, workout.getMember());
            statement.setString(3, workout.getTrainer());
            statement.setInt(4, workout.getDurationMinutes());
            statement.setString(5, workout.getYogaStyle());
            statement.setInt(6, workout.getDifficultyLevel());
            statement.setBoolean(7, workout.isMeditationIncluded());


            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Yoga Workout Session inserted: " + workout.getSessionId());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("❌ Insert Yoga Workout Session failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    // ========================================
    // READ - SELECT OPERATIONS (Week 7)
    // ========================================

    public List<WorkoutSession> getAllSessions(){
        List <WorkoutSession> workoutSessions = new ArrayList<>();
        String sql = "SELECT * FROM workout_session";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return workoutSessions;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                WorkoutSession workoutSession = extractWorkoutSessionFromResultSet(resultSet);
                if(workoutSession != null){
                    workoutSessions.add(workoutSession);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " +  workoutSessions.size() + " WorkoutSessions from database");

        } catch (SQLException e){
            System.out.println("❌ Select All WorkoutSession failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return workoutSessions;
    }

    public WorkoutSession getWorkoutSessionById(int workoutSessionId){
        String sql = "SELECT * FROM workout_session WHERE session_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, workoutSessionId);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                WorkoutSession workoutSession = extractWorkoutSessionFromResultSet(resultSet);

                resultSet.close();
                statement.close();

                if(workoutSession != null){
                    System.out.println("✅ Found WorkoutSession with id: " + workoutSessionId);
                }

                return workoutSession;
            }

            System.out.println("⚠\uFE0F No WorkoutSession with id: " + workoutSessionId);

            resultSet.close();
            statement.close();

        } catch(SQLException e){
            System.out.println("❌ Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }

    public List<StrengthWorkout>  getAllStrengthWorkouts(){
        List <StrengthWorkout> strengthWorkouts = new ArrayList<>();
        String sql = "SELECT * FROM workout_session WHERE workout_session_type = 'Strength Workout' ORDER BY session_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return strengthWorkouts;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                WorkoutSession workoutSession = extractWorkoutSessionFromResultSet(resultSet);
                if(workoutSession instanceof StrengthWorkout){
                    strengthWorkouts.add((StrengthWorkout) workoutSession);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " +  strengthWorkouts.size() + " StrengthWorkouts from database");

        } catch(SQLException e){
            System.out.println("❌ Select Strength Workout sessions failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }

        return strengthWorkouts;
    }

    public List<YogaWorkout>  getAllYogaWorkouts(){
        List <YogaWorkout> yogaWorkouts = new ArrayList<>();
        String sql = "SELECT * FROM workout_session WHERE workout_session_type = 'Yoga Workout' ORDER BY session_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return yogaWorkouts;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                WorkoutSession workoutSession = extractWorkoutSessionFromResultSet(resultSet);
                if(workoutSession instanceof YogaWorkout){
                    yogaWorkouts.add((YogaWorkout) workoutSession);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " +  yogaWorkouts.size() + " YogaWorkouts from database");

        } catch(SQLException e){
            System.out.println("❌ Select Yoga Workout sessions failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }

        return yogaWorkouts;
    }

    // ========================================
    // WEEK 8: UPDATE OPERATION
    // ========================================

    public boolean updateStrengthWorkout(StrengthWorkout strengthWorkout){
        String sql = "UPDATE workout_session SET member_name = ?, trainer_name = ?, duration_minutes = ?, " +
                "muscle_group = ?, sets = ?, reps = ?, rest_minutes = ? " +
                "WHERE session_id = ? AND workout_session_type = 'Strength Workout'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, strengthWorkout.getMember());
            statement.setString(2, strengthWorkout.getTrainer());
            statement.setInt(3, strengthWorkout.getDurationMinutes());
            statement.setString(4, strengthWorkout.getMuscleGroup());
            statement.setInt(5, strengthWorkout.getSets());
            statement.setInt(6, strengthWorkout.getReps());
            statement.setInt(7, strengthWorkout.getRestMinutes());
            statement.setInt(8, strengthWorkout.getSessionId());

            int  rowsUpdated = statement.executeUpdate();
            statement.close();

            if(rowsUpdated > 0) {
                System.out.println("✅ Strength Workout [" + strengthWorkout.getSessionId() + "] updated successfully!");
                return true;
            } else{
                System.out.println("⚠\uFE0F No Strength Workout found with ID: " + strengthWorkout.getSessionId());
            }

        } catch(SQLException e){
            System.out.println("❌ Update Strength Workout session failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public boolean updateYogaWorkout(YogaWorkout yogaWorkout){
        String sql = "UPDATE workout_session SET member_name = ?, trainer_name = ?, duration_minutes = ?, " +
                "yoga_style = ?, difficulty_level = ?, meditation_included = ? " +
                "WHERE session_id = ? AND workout_session_type = 'Yoga Workout'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, yogaWorkout.getMember());
            statement.setString(2, yogaWorkout.getTrainer());
            statement.setInt(3, yogaWorkout.getDurationMinutes());
            statement.setString(4, yogaWorkout.getYogaStyle());
            statement.setInt(5, yogaWorkout.getDifficultyLevel());
            statement.setBoolean(6, yogaWorkout.isMeditativeSession());
            statement.setInt(7, yogaWorkout.getSessionId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if(rowsUpdated > 0) {
                System.out.println("✅ Yoga Workout [" + yogaWorkout.getSessionId() + "] updated successfully!");
                return true;
            } else{
                System.out.println("⚠\uFE0F No Yoga Workout found with ID: " + yogaWorkout.getSessionId());
            }

        } catch(SQLException e){
            System.out.println("❌ Update Yoga Workout session failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    // ========================================
    // WEEK 8: DELETE OPERATION
    // ========================================

    public boolean deleteWorkoutSession(int sessionId){
        String sql =  "DELETE FROM workout_session WHERE session_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, sessionId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if(rowsDeleted > 0) {
                System.out.println("✅ Workout Session deleted (ID: " + sessionId + ")");
                return true;
            } else{
                System.out.println("⚠\uFE0F No Workout Session found with ID: " + sessionId);
            }

        } catch (SQLException e){
            System.out.println("❌ Delete Workout session failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    // ========================================
    // WEEK 8: SEARCH BY NAME
    // ========================================

    public List<WorkoutSession> searchByName(String name){
        List<WorkoutSession> workoutSessionList = new ArrayList<>();

        String sql = "SELECT * FROM workout_session WHERE member_name ILIKE ? ORDER BY member_name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return workoutSessionList;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                WorkoutSession workoutSession = extractWorkoutSessionFromResultSet(resultSet);
                if(workoutSession != null){
                    workoutSessionList.add(workoutSession);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " +  workoutSessionList.size() + " Workout Sessions matching '" + name + "'");

        } catch(SQLException e){
            System.out.println("❌ Search by Name failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }

        return workoutSessionList;
    }

    // ========================================
    // WEEK 8: SEARCH BY DURATION MINUTES RANGE
    // ========================================

    public List<WorkoutSession> searchByDurationMinutesRange(int minMinutes, int maxMinutes){
        List<WorkoutSession> workoutSessionList = new ArrayList<>();

        String sql = "SELECT * FROM workout_session WHERE duration_minutes BETWEEN ? AND ? ORDER BY duration_minutes DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return workoutSessionList;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minMinutes);
            statement.setInt(2, maxMinutes);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                WorkoutSession workoutSession = extractWorkoutSessionFromResultSet(resultSet);
                if(workoutSession != null){
                    workoutSessionList.add(workoutSession);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + workoutSessionList.size() +
                    "sessions in Duration Minutes range " + minMinutes + "-" + maxMinutes);

        } catch(SQLException e){
            System.out.println("❌ Search by range failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }

        return workoutSessionList;
    }

    public List<WorkoutSession> searchByMinDurationMinutes(int minMinutes){
        List<WorkoutSession> workoutSessionList = new ArrayList<>();

        String sql = "SELECT * FROM workout_session WHERE duration_minutes >= ? ORDER BY duration_minutes DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return workoutSessionList;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minMinutes);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                WorkoutSession workoutSession = extractWorkoutSessionFromResultSet(resultSet);
                if(workoutSession != null){
                    workoutSessionList.add(workoutSession);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + workoutSessionList.size() +
                    " high-intensive sessions in Duration Minutes more than " + minMinutes);

        } catch(SQLException e){
            System.out.println("❌ Search by min minutes failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }

        return workoutSessionList;
    }

    public List<WorkoutSession> searchByTrainerName(String name){
        List<WorkoutSession> workoutSessionList = new ArrayList<>();

        String sql = "SELECT * FROM workout_session WHERE trainer_name ILIKE ? ORDER BY trainer_name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return workoutSessionList;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                WorkoutSession workoutSession = extractWorkoutSessionFromResultSet(resultSet);
                if(workoutSession != null){
                    workoutSessionList.add(workoutSession);
                }

                resultSet.close();
                statement.close();

                System.out.println("✅ Found" +  workoutSessionList.size() + " Workout Sessions matching '" + name + "'");

            }
        } catch(SQLException e){
            System.out.println("❌ Search by Trainer Name failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return workoutSessionList;
    }

    // ========================================
    // HELPER METHOD
    // ========================================

    private WorkoutSession extractWorkoutSessionFromResultSet(ResultSet resultSet) throws SQLException {
        int sessionId = resultSet.getInt("session_id");
        String member = resultSet.getString("member_name");
        String trainer = resultSet.getString("trainer_name");
        int durationMinutes = resultSet.getInt("duration_minutes");
        String workoutSessionType = resultSet.getString("workout_session_type");

        WorkoutSession workoutSession = null;

        if("Strength Workout".equals(workoutSessionType)){
            String muscleGroup = resultSet.getString("muscle_group");
            int reps = resultSet.getInt("reps");
            int sets = resultSet.getInt("sets");
            int restMinutes = resultSet.getInt("rest_minutes");

            workoutSession = new StrengthWorkout(sessionId, member, trainer, durationMinutes, muscleGroup, reps, sets, restMinutes);

        } else if("Yoga Workout".equals(workoutSessionType)){
            String yogaStyle = resultSet.getString("yoga_style");
            int difficultyLevel = resultSet.getInt("difficulty_level");
            boolean meditationIncluded = resultSet.getBoolean("meditation_included");

            workoutSession = new YogaWorkout(sessionId, member, trainer, durationMinutes, yogaStyle, difficultyLevel, meditationIncluded);
        }

        return workoutSession;
    }

    // ========================================
    // DISPLAY METHODS
    // ========================================

    public void displayAllWorkoutSession(){
        List <WorkoutSession> workoutSessionList = getAllSessions();

        System.out.println("\n========================================");
        System.out.println("   ALL WORKOUT SESSIONS FROM DATABASE");
        System.out.println("========================================");

        if(workoutSessionList.isEmpty()){
            System.out.println("No workout sessions in database");
        } else{
            for(int i = 0;  i < workoutSessionList.size(); i++){
                WorkoutSession workoutSession = workoutSessionList.get(i);
                System.out.print((i+1) + ". ");
                System.out.println("["  + workoutSession.getWorkoutType() + "] ");
                System.out.println(workoutSession);

            }
        }

        System.out.println("========================================\n");
    }

    public void demonstratePolymorphism(){
        List <WorkoutSession> workoutSessionList = getAllSessions();

        System.out.println("\n==============================================================");
        System.out.println("   POLYMORPHISM DEMONSTRATION: Workout Sessions from Database");
        System.out.println("==============================================================");
        System.out.println("Calling calculateCaloriesBurned() on all sessions:");
        System.out.println();

        if(workoutSessionList.isEmpty()){
            System.out.println("No workout sessions to demonstrate");
        } else{
            for(WorkoutSession w: workoutSessionList){
                System.out.println("[ " + w.getSessionId() + " ] This " + w.getWorkoutType() + " session burned calories total amount of: " + w.calculateCaloriesBurned());
            }
        }

        System.out.println("========================================\n");
    }
}
