package com.kaisar.gym;

public class YogaWorkout extends WorkoutSession {
    private String yogaStyle;
    private int difficultyLevel;

    //constructor
    public YogaWorkout(int sessionId, String trainer, int durationMinutes, String yogaStyle, int difficultyLevel){
        super(sessionId, trainer, durationMinutes);
        this.yogaStyle = yogaStyle;
        this.difficultyLevel = difficultyLevel;
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
        }
    }
}
