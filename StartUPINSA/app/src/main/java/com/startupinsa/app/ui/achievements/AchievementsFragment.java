package com.startupinsa.app.ui.achievements;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.startupinsa.app.R;

/**
 * Created by robin, on 26/11/20 at 20:59.
 * For the StartUP'INSA project.
 */
public class AchievementsFragment extends Fragment {

    private AchievementsViewModel mAchievementsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container){

        mAchievementsViewModel = ViewModelProviders.of(this).get(AchievementsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_achievements, container, false);
        final TextView textView = root.findViewById(R.id.text_achievements);

        mAchievementsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
