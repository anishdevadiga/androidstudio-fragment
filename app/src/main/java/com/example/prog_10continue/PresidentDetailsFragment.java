package com.example.prog_10continue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class PresidentDetailsFragment extends Fragment {

    private ImageView imageView;
    private TextView nameTextView;
    private TextView detailsTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_president_details, container, false);
        imageView = view.findViewById(R.id.image_president);
        nameTextView = view.findViewById(R.id.text_name);
        detailsTextView = view.findViewById(R.id.text_details);
        Button exitButton = view.findViewById(R.id.back);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming that the parent activity needs to be finished
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });

        return view;
    }

    public void updateDetails(String name, String details, int imageResId) {
        nameTextView.setText(name);
        detailsTextView.setText(details);
        imageView.setImageResource(imageResId);
    }
}
