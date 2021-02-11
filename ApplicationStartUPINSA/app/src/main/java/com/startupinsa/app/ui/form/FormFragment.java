package com.startupinsa.app.ui.form;

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

public class FormFragment extends Fragment {

    private FormViewModel formViewModel;


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
        formViewModel =
                new ViewModelProvider(this).get(FormViewModel.class);

        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        EditText formName = requireView().findViewById(R.id.formName);
        EditText formFirstName = requireView().findViewById(R.id.formFirstName);
        EditText formEmail = requireView().findViewById(R.id.formEmail);
        EditText formPhone = requireView().findViewById(R.id.formPhone);
        EditText formPhoneIndex = requireView().findViewById(R.id.formPhoneIndex);
        EditText formSubject = requireView().findViewById(R.id.formSubject);
        EditText formMessage = requireView().findViewById(R.id.formMessage);

        ImageButton formNameError = requireView().findViewById(R.id.formNameError);
        ImageButton formFirstNameError = requireView().findViewById(R.id.formFirstNameError);
        ImageButton formEmailError = requireView().findViewById(R.id.formEmailError);
        ImageButton formPhoneIndexError = requireView().findViewById(R.id.formPhoneIndexError);
        ImageButton formPhoneError = requireView().findViewById(R.id.formPhoneError);
        ImageButton formSubjectError = requireView().findViewById(R.id.formSubjectError);
        ImageButton formMessageError = requireView().findViewById(R.id.formMessageError);

        TextView formNameErrorText = requireView().findViewById(R.id.formNameErrorText);
        TextView formFirstNameErrorText = requireView().findViewById(R.id.formFirstNameErrorText);
        TextView formEmailErrorText = requireView().findViewById(R.id.formEmailErrorText);
        TextView formPhoneIndexErrorText = requireView().findViewById(R.id.formPhoneIndexErrorText);
        TextView formPhoneErrorText = requireView().findViewById(R.id.formPhoneErrorText);
        TextView formSubjectErrorText = requireView().findViewById(R.id.formSubjectErrorText);
        TextView formMessageErrorText = requireView().findViewById(R.id.formMessageErrorText);

        Button formButtonSend = requireView().findViewById(R.id.formButtonSend);


        formName.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                formNameError.setVisibility(formName.getText().toString().trim().length() > 1 ? View.GONE : View.VISIBLE);
            }
        });

        formNameError.setOnTouchListener((v, event) -> {
            formName.clearFocus();
            formFirstName.clearFocus();
            formEmail.clearFocus();
            formPhoneIndex.clearFocus();
            formPhone.clearFocus();
            formSubject.clearFocus();
            formMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    formNameErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    formNameErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        formFirstName.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                formFirstNameError.setVisibility(formFirstName.getText().toString().trim().length() > 1 ? View.GONE : View.VISIBLE);
            }
        });

        formFirstNameError.setOnTouchListener((v, event) -> {
            formName.clearFocus();
            formFirstName.clearFocus();
            formEmail.clearFocus();
            formPhoneIndex.clearFocus();
            formPhone.clearFocus();
            formSubject.clearFocus();
            formMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    formFirstNameErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    formFirstNameErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        formEmail.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                formEmailError.setVisibility(verifyEmailAddress(formEmail.getText().toString()) ? View.GONE : View.VISIBLE);
            }
        });

        formEmailError.setOnTouchListener((v, event) -> {
            formName.clearFocus();
            formFirstName.clearFocus();
            formEmail.clearFocus();
            formPhoneIndex.clearFocus();
            formPhone.clearFocus();
            formSubject.clearFocus();
            formMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    formEmailErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    formEmailErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        formPhoneIndex.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                formPhoneIndexError.setVisibility(verifyPhoneIndex(formPhoneIndex.getText().toString()) ? View.GONE : View.VISIBLE);
            }
        });

        formPhoneIndexError.setOnTouchListener((v, event) -> {
            formName.clearFocus();
            formFirstName.clearFocus();
            formEmail.clearFocus();
            formPhoneIndex.clearFocus();
            formPhone.clearFocus();
            formSubject.clearFocus();
            formMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    formPhoneIndexErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    formPhoneIndexErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        formPhone.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                formPhoneError.setVisibility(verifyPhoneNumber(formPhone.getText().toString()) ? View.GONE : View.VISIBLE);
            }
        });

        formPhoneError.setOnTouchListener((v, event) -> {
            formName.clearFocus();
            formFirstName.clearFocus();
            formEmail.clearFocus();
            formPhoneIndex.clearFocus();
            formPhone.clearFocus();
            formSubject.clearFocus();
            formMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    formPhoneErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    formPhoneErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        formSubject.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                formSubjectError.setVisibility(formSubject.getText().toString().trim().length() > 1 ? View.GONE : View.VISIBLE);
            }
        });

        formSubjectError.setOnTouchListener((v, event) -> {
            formName.clearFocus();
            formFirstName.clearFocus();
            formEmail.clearFocus();
            formPhoneIndex.clearFocus();
            formPhone.clearFocus();
            formSubject.clearFocus();
            formMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    formSubjectErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    formSubjectErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

        formMessage.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                formMessageError.setVisibility(formMessage.getText().toString().trim().length() > 1 ? View.GONE : View.VISIBLE);
            }
        });

        formMessageError.setOnTouchListener((v, event) -> {
            formName.clearFocus();
            formFirstName.clearFocus();
            formEmail.clearFocus();
            formPhoneIndex.clearFocus();
            formPhone.clearFocus();
            formSubject.clearFocus();
            formMessage.clearFocus();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                //lorsque le bouton rouge est appuyé
                case MotionEvent.ACTION_DOWN:
                    formMessageErrorText.setVisibility(View.VISIBLE);
                    break;
                //Lorsque le bouton rouge est relevé
                case MotionEvent.ACTION_UP:
                    formMessageErrorText.setVisibility(View.GONE);
                    break;
            }
            return false;
        });

    }


}
