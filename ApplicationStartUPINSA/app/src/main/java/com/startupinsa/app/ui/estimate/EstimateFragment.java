package com.startupinsa.app.ui.estimate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.startupinsa.app.R;

public class EstimateFragment extends Fragment {

    private EstimateViewModel estimateViewModel;


    public boolean verifyEmailAddress(String emailAddress){
        emailAddress = emailAddress.trim();
        return emailAddress.matches("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }

    public boolean verifyPhoneIndex(String subject){
        subject = subject.trim();
        return subject.matches("^\\+((1(((-| )[0-9]{3})|$))|(([2-9]{1})([0-9]{0,2})))$");
    }

    public boolean verifyPhoneNumber(String phoneNumber){
        phoneNumber = phoneNumber.trim();
        return phoneNumber.matches("^[0-9\\-\\(\\)\\. ]+$");
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        estimateViewModel =
                new ViewModelProvider(this).get(EstimateViewModel.class);

        return inflater.inflate(R.layout.fragment_estimate, container, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        EditText estimateName = requireView().findViewById(R.id.estimateName);
        EditText estimateFirstName = requireView().findViewById(R.id.estimateFirstName);
        EditText estimateEmail = requireView().findViewById(R.id.estimateEmail);
        EditText estimatePhone = requireView().findViewById(R.id.estimatePhone);
        EditText estimatePhoneIndex = requireView().findViewById(R.id.estimatePhoneIndex);
        EditText estimateSubject = requireView().findViewById(R.id.estimateSubject);
        EditText estimateMessage = requireView().findViewById(R.id.estimateMessage);

        ImageButton estimateNameError = requireView().findViewById(R.id.estimateNameError);
        ImageButton estimateFirstNameError = requireView().findViewById(R.id.estimateFirstNameError);
        ImageButton estimateEmailError = requireView().findViewById(R.id.estimateEmailError);
        ImageButton estimatePhoneIndexError = requireView().findViewById(R.id.estimatePhoneIndexError);
        ImageButton estimatePhoneError = requireView().findViewById(R.id.estimatePhoneError);
        ImageButton estimateSubjectError = requireView().findViewById(R.id.estimateSubjectError);
        ImageButton estimateMessageError = requireView().findViewById(R.id.estimateMessageError);

        TextView estimateNameErrorText = requireView().findViewById(R.id.estimateNameErrorText);
        TextView estimateFirstNameErrorText = requireView().findViewById(R.id.estimateFirstNameErrorText);
        TextView estimateEmailErrorText = requireView().findViewById(R.id.estimateEmailErrorText);
        TextView estimatePhoneIndexErrorText = requireView().findViewById(R.id.estimatePhoneIndexErrorText);
        TextView estimatePhoneErrorText = requireView().findViewById(R.id.estimatePhoneErrorText);
        TextView estimateSubjectErrorText = requireView().findViewById(R.id.estimateSubjectErrorText);
        TextView estimateMessageErrorText = requireView().findViewById(R.id.estimateMessageErrorText);

        Button estimateButtonSend = requireView().findViewById(R.id.estimateButtonSend);


        estimateName.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                estimateNameError.setVisibility(estimateName.getText().toString().trim().length() > 1 ? View.GONE : View.VISIBLE);
            }
        });

        estimateNameError.setOnTouchListener((v, event) -> {
            estimateName.clearFocus();
            estimateFirstName.clearFocus();
            estimateEmail.clearFocus();
            estimatePhoneIndex.clearFocus();
            estimatePhone.clearFocus();
            estimateSubject.clearFocus();
            estimateMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    estimateNameErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    estimateNameErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        estimateFirstName.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                estimateFirstNameError.setVisibility(estimateFirstName.getText().toString().trim().length() > 1 ? View.GONE : View.VISIBLE);
            }
        });

        estimateFirstNameError.setOnTouchListener((v, event) -> {
            estimateName.clearFocus();
            estimateFirstName.clearFocus();
            estimateEmail.clearFocus();
            estimatePhoneIndex.clearFocus();
            estimatePhone.clearFocus();
            estimateSubject.clearFocus();
            estimateMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    estimateFirstNameErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    estimateFirstNameErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        estimateEmail.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                estimateEmailError.setVisibility(verifyEmailAddress(estimateEmail.getText().toString()) ? View.GONE : View.VISIBLE);
            }
        });

        estimateEmailError.setOnTouchListener((v, event) -> {
            estimateName.clearFocus();
            estimateFirstName.clearFocus();
            estimateEmail.clearFocus();
            estimatePhoneIndex.clearFocus();
            estimatePhone.clearFocus();
            estimateSubject.clearFocus();
            estimateMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    estimateEmailErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    estimateEmailErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        estimatePhoneIndex.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                estimatePhoneIndexError.setVisibility(verifyPhoneIndex(estimatePhoneIndex.getText().toString()) ? View.GONE : View.VISIBLE);
            }
        });

        estimatePhoneIndexError.setOnTouchListener((v, event) -> {
            estimateName.clearFocus();
            estimateFirstName.clearFocus();
            estimateEmail.clearFocus();
            estimatePhoneIndex.clearFocus();
            estimatePhone.clearFocus();
            estimateSubject.clearFocus();
            estimateMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    estimatePhoneIndexErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    estimatePhoneIndexErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        estimatePhone.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                estimatePhoneError.setVisibility(verifyPhoneNumber(estimatePhone.getText().toString()) ? View.GONE : View.VISIBLE);
            }
        });

        estimatePhoneError.setOnTouchListener((v, event) -> {
            estimateName.clearFocus();
            estimateFirstName.clearFocus();
            estimateEmail.clearFocus();
            estimatePhoneIndex.clearFocus();
            estimatePhone.clearFocus();
            estimateSubject.clearFocus();
            estimateMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    estimatePhoneErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    estimatePhoneErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        estimateSubject.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                estimateSubjectError.setVisibility(estimateSubject.getText().toString().trim().length() > 1 ? View.GONE : View.VISIBLE);
            }
        });

        estimateSubjectError.setOnTouchListener((v, event) -> {
            estimateName.clearFocus();
            estimateFirstName.clearFocus();
            estimateEmail.clearFocus();
            estimatePhoneIndex.clearFocus();
            estimatePhone.clearFocus();
            estimateSubject.clearFocus();
            estimateMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    estimateSubjectErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    estimateSubjectErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        estimateMessage.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                estimateMessageError.setVisibility(estimateMessage.getText().toString().trim().length() > 1 ? View.GONE : View.VISIBLE);
            }
        });

        estimateMessageError.setOnTouchListener((v, event) -> {
            estimateName.clearFocus();
            estimateFirstName.clearFocus();
            estimateEmail.clearFocus();
            estimatePhoneIndex.clearFocus();
            estimatePhone.clearFocus();
            estimateSubject.clearFocus();
            estimateMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    estimateMessageErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    estimateMessageErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

    }


}
