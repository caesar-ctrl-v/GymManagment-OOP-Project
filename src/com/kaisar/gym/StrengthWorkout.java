package com.kaisar.gym;

public class StrengthWorkout extends WorkoutSession{
    private String muscleGroup;
    private int sets;
    private int reps;
    private int restMinutes;

    public StrengthWorkout(int sessionId, Trainer trainer, int durationMinutes, String muscleGroup, int sets, int reps, int restMinutes){
        super(sessionId, trainer, durationMinutes);
        this.muscleGroup = muscleGroup;
        setSets(sets);
        setReps(reps);
        setRestMinutes(restMinutes);
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        if(sets >= 0){
            this.sets = sets;
        } else{
            System.out.println("Warning: sets cannot be negative! Setting to 0.");
            this.sets = 0;
        }
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        if(sets >= 0){
            this.reps = reps;
        } else{
            System.out.println("Warning: reps cannot be negative! Setting to 0.");
            this.reps = 0;
        }
    }

    public int getRestMinutes() {
        return restMinutes;
    }

    public void setRestMinutes(int restMinutes) {
        if(sets >= 0){
            this.restMinutes = restMinutes;
        } else{
            System.out.println("Warning: restMinutes cannot be negative! Setting to 0.");
            this.restMinutes = 0;
        }
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
