package com.example.prog_10continue;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class PresidentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_1, new PresidentListFragment())
                    .replace(R.id.fragment_container_2, new PresidentDetailsFragment())
                    .commit();
        }
    }

    public void updatePresidentDetails(String presidentName) {
        String details = "";
        int imageResId = 0;

        switch (presidentName) {
            case "Dr. Rajendra Prasad":
                details = "Presidential Period: 1950-1962\nQualification: MA in Economics\n" +
                        "Professional Experience: Lawyer, Statesman\nLifetime: 1884-1963\n" +
                        "Special Achievements: First President of India, played a key role in the Indian independence movement.";
                imageResId = R.drawable.ic_rajendra_prasad;
                break;
            case "Dr. Sarvepalli Radhakrishnan":
                details = "Presidential Period: 1962-1967\nQualification: MA in Philosophy, Doctorate in Philosophy\n" +
                        "Professional Experience: Educator, Philosopher, Vice President of India\nLifetime: 1888-1975\n" +
                        "Special Achievements: Renowned educator, recipient of the Bharat Ratna, played a significant role in the Indian education system.";
                imageResId = R.drawable.ic_radhakrishnan;
                break;
            case "Dr. Zakir Husain":
                details = "Presidential Period: 1967-1969\nQualification: MA in History\n" +
                        "Professional Experience: Educator, Politician, Vice President of India\nLifetime: 1897-1969\n" +
                        "Special Achievements: First Muslim President of India, promoted the cause of education and founded the Jamia Millia Islamia University.";
                imageResId = R.drawable.ic_zakir_husain;
                break;
        }

        PresidentDetailsFragment detailsFragment = (PresidentDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_2);
        if (detailsFragment != null) {
            detailsFragment.updateDetails(presidentName, details, imageResId);
        }
    }

}
