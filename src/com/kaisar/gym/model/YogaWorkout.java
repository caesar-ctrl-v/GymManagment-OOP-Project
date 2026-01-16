package com.kaisar.gym.model;

public class YogaWorkout extends WorkoutSession {
    private String yogaStyle;
    private int difficultyLevel;
    private boolean meditationIncluded;

    //constructor
    public YogaWorkout(int sessionId, Trainer trainer, int durationMinutes, String yogaStyle, int difficultyLevel, boolean meditationIncluded){
        super(sessionId, trainer, durationMinutes);
        setYogaStyle(yogaStyle);
        setDifficultyLevel(difficultyLevel);
        setMeditationIncluded(meditationIncluded);
    }

    public String getYogaStyle() {
        return yogaStyle;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public boolean isMeditationIncluded() {
        return meditationIncluded;
    }

    public void setYogaStyle(String yogaStyle) {
        if (yogaStyle == null || yogaStyle.trim().isEmpty()) {
            throw new IllegalArgumentException("Yoga Style cannot be empty");
        }
        this.yogaStyle = yogaStyle;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        if(difficultyLevel > 5 || difficultyLevel < 1){
            throw new IllegalArgumentException("Difficulty level must be between 1 and 5");
        }
        this.difficultyLevel = difficultyLevel;
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
