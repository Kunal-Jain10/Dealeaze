package com.example.dealeaze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.DragAndDropPermissions;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SettingsActivity extends AppCompatActivity {

    RatingBar sexperience,sconnectivity;
    EditText sFeedback;
    Button submit;
    DatabaseReference settingReference;
    SettingsHelper settingsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        sexperience = (RatingBar)findViewById(R.id.experienceRatingBar);
        sconnectivity = (RatingBar)findViewById(R.id.connectivityRatingBar);
        sFeedback = (EditText)findViewById(R.id.editTextFeedback);
        submit = (Button)findViewById(R.id.submitButton);
        settingReference = FirebaseDatabase.getInstance().getReference().child("Ratings");
        settingsHelper = new SettingsHelper();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedback = sFeedback.getText().toString();
                float experience = ( sexperience.getRating());
                float connectivity = sconnectivity.getRating();

                if(!feedback.equals(""))
                {
                    settingsHelper.setFeedback(feedback);
                    settingsHelper.setExperience(experience);
                    settingsHelper.setConnectivity(connectivity);

                    settingReference.push().setValue(settingsHelper);
                    Toast.makeText(SettingsActivity.this, "Feedback Submitted!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SettingsActivity.this, "Error Submitting!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}