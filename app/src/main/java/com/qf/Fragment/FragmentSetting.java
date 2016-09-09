package com.qf.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.administrator.androidproject.R;

public class FragmentSetting extends Fragment {
    RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         radioGroup= (RadioGroup) view.findViewById(R.id.ridioGroup2Id);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton1Id2:

                        break;
                    case R.id.radioButton2Id2:
                        break;
                    case R.id.radioButton3Id2:
                        break;
                    case R.id.radioButton4Id2:
                        break;
                    case R.id.radioButton5Id2:
                        break;
                    case R.id.radioButton6Id2:
                        break;
                    case R.id.radioButton7Id2:
                        break;
                    case R.id.radioButton8Id2:
                        break;

                }
            }
        });
    }
}