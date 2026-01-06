package com.kaisar.gym;

public class YogaWorkout extends WorkoutSession {
    private String yogaStyle;
    private int difficultyLevel;
    private boolean meditationIncluded;

    //constructor
    public YogaWorkout(int sessionId, Trainer trainer, int durationMinutes, String yogaStyle, int difficultyLevel, boolean meditationIncluded){
        super(sessionId, trainer, durationMinutes);
        this.yogaStyle = yogaStyle;
        this.difficultyLevel = difficultyLevel;
        this.meditationIncluded = meditationIncluded;
    }

    public String getYogaStyle() {
        return yogaStyle;
    }

    public void setYogaStyle(String yogaStyle) {
        if (yogaStyle != null && !yogaStyle.trim().isEmpty()) {
            this.yogaStyle = yogaStyle;
        } else{
            System.out.println("Warning: Yoga Style cannot be empty!");
        }
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        if(difficultyLevel <=5 && difficultyLevel >= 1){
            this.difficultyLevel = difficultyLevel;
        } else if(difficultyLevel > 5){
            System.out.println("Such difficulty level does not exist!");
        } else{
            System.out.println("Difficulty level must be more than 1!");
        }
    }

    public boolean isMeditationIncluded() {
        return meditationIncluded;
    }

    public void setMeditationIncluded(boolean meditationIncluded) {
        this.meditationIncluded = meditationIncluded;
    }

    @Override
    public String getWorkoutType(){
        return "Yoga Workout";
    }

    @Override
    public int calculateCaloriesBurned() {
        return durationMinutes * difficultyLevel * 3;
    }

    public boolean isMeditativeSession() {
        return meditationIncluded && durationMinutes >= 45;
    }

    public boolean isMeditationCushionNeeded(){
        return isMeditativeSession() && (yogaStyle.equals("Yin") || yogaStyle.equals("Hatha"));
    }

    @Override
    public String toString(){
        return super.toString() + " | Yoga Style: '" + yogaStyle
                + "', Difficulty Level: " + difficultyLevel
                + ", Meditation Included: " + meditationIncluded;
    }
}
