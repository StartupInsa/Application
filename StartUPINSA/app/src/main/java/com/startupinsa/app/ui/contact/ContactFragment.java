package com.startupinsa.app.ui.contact;

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

/**
 * Created by robin, on 26/11/20 at 21:28.
 * For the StartUP'INSA project.
 */
public class ContactFragment extends Fragment {

    private ContactViewModel mContactViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container ,Bundle savedInstanceState){
        mContactViewModel =
                ViewModelProviders.of(this).get(ContactViewModel.class);

        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        final TextView textView = root.findViewById(R.id.text_contact);
        mContactViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }
}
