package com.startupinsa.app.ui.estimate;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.startupinsa.app.R;
import com.startupinsa.app.ui.about.AboutViewModel;

/**
 * Created by robin, on 26/11/20 at 21:26.
 * For the StartUP'INSA project.
 */
public class EstimateFragment extends Fragment {
    private EstimateViewModel mEstimateViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        mEstimateViewModel = ViewModelProviders.of(this).get(EstimateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_estimate, container, false);
        final TextView textView = root.findViewById(R.id.text_estimate);
        mEstimateViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
