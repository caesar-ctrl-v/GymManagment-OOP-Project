package com.kaisar.gym.model;

public class StrengthWorkout extends WorkoutSession{
    private String muscleGroup;
    private int sets;
    private int reps;
    private int restMinutes;

    public StrengthWorkout(int sessionId, Trainer trainer, int durationMinutes, String muscleGroup, int sets, int reps, int restMinutes){
        super(sessionId, trainer, durationMinutes);
        setMuscleGroup(muscleGroup);
        setSets(sets);
        setReps(reps);
        setRestMinutes(restMinutes);
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public int getRestMinutes() {
        return restMinutes;
    }

    public void setMuscleGroup(String muscleGroup) {
        if(muscleGroup == null || muscleGroup.trim().isEmpty()){
            throw new IllegalArgumentException("Muscle group cannot be empty");
        }
        this.muscleGroup = muscleGroup;
    }

    public void setSets(int sets) {
        if(sets <= 0){
            throw new IllegalArgumentException("Sets must be greater than 0");
        }
        this.sets = sets;
    }

    public void setReps(int reps) {
        if(reps <= 0){
            throw new IllegalArgumentException("Reps must be greater than 0");
        }
        this.reps = reps;
    }

    public void setRestMinutes(int restMinutes) {
        if(restMinutes <= 0){
            throw new IllegalArgumentException("Rest Minutes must be greater than 0");
        }
        this.restMinutes = restMinutes;
    }

    @Override
    public String getWorkoutType(){
        return "Strength Workout";
    }

    @Override
    public int calculateCaloriesBurned() {
        return (durationMinutes - getTotalRestTime()) * 3;
    }

    public int getTotalRestTime() {
        return (sets - 1) * restMinutes;
    }

    public int getTotalReps() {
        return sets * reps;
    }

    @Override
    public String toString(){
        return super.toString() + " | Muscle Group: '" + muscleGroup
                + "', Sets Amount: " + sets
                + ", Reps Amount: " + reps
                + ", Rest Minutes: " + restMinutes;
    }
}
