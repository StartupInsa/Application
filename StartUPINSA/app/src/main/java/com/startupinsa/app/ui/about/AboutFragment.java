package com.startupinsa.app.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.appcompat.app.AppCompatActivity;

import com.startupinsa.app.R;
import com.startupinsa.app.ui.home.HomeViewModel;

public class AboutFragment extends Fragment implements View.OnClickListener{

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about, container, false);


        String mWhoAreWeString1 = getString(R.string.about_who_are_we_text1);
        String mOurSchoolString1 = getString(R.string.about_our_school_text1);
        String mWhatDoWeDoString1 = getString(R.string.about_what_do_we_do_text1);
        String mComeInString1 = getString(R.string.about_come_in_text1);

        final TextView mWhoAreWeTextView1 = root.findViewById(R.id.who_are_we_text_1);
        final TextView mOurSchoolTextView1 = root.findViewById(R.id.our_school_text_1);
        final TextView mWhatDoWeDoTextView1 = root.findViewById(R.id.what_do_we_do_text_1);
        final TextView mComeInTextView1 = root.findViewById(R.id.come_in_text_1);

        mWhoAreWeTextView1.setText(mWhoAreWeString1);
        mOurSchoolTextView1.setText(mOurSchoolString1);
        mWhatDoWeDoTextView1.setText(mWhatDoWeDoString1);
        mComeInTextView1.setText(mComeInString1);



        Button mAboutPartButton1 = root.findViewById(R.id.about_part_1);
        Button mAboutPartButton2 = root.findViewById(R.id.about_part_2);
        Button mAboutPartButton3 = root.findViewById(R.id.about_part_3);
        Button mAboutPartButton4 = root.findViewById(R.id.about_part_4);

        String mAboutPartString1 = getString(R.string.about_part_1);
        String mAboutPartString2 = getString(R.string.about_part_2);
        String mAboutPartString3 = getString(R.string.about_part_3);
        String mAboutPartString4 = getString(R.string.about_part_4);

        mAboutPartButton1.setText(mAboutPartString1);
        mAboutPartButton2.setText(mAboutPartString2);
        mAboutPartButton3.setText(mAboutPartString3);
        mAboutPartButton4.setText(mAboutPartString4);

        mAboutPartButton1.setOnClickListener(this);
        mAboutPartButton2.setOnClickListener(this);
        mAboutPartButton3.setOnClickListener(this);
        mAboutPartButton4.setOnClickListener(this);

        mAboutPartButton1.setTag(1);
        mAboutPartButton2.setTag(2);
        mAboutPartButton3.setTag(3);
        mAboutPartButton4.setTag(4);


        return root;
    }

    @Override
    public void onClick(View v) {
        
    }

}