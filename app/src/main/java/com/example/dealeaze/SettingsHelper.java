package com.example.dealeaze;


public class SettingsHelper {
    String feedback;
    float experience;
    float connectivity;

    public SettingsHelper() {
    }

    public SettingsHelper(String feedback, float experience, float connectivity) {
        this.feedback = feedback;
        this.experience = experience;
        this.connectivity = connectivity;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public float getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(float connectivity) {
        this.connectivity = connectivity;
    }
}
