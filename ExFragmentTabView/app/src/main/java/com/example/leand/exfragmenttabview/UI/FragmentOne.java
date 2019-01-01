package com.example.leand.exfragmenttabview.UI;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leand.exfragmenttabview.R;

public class FragmentOne extends Fragment {

    public FragmentOne() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.activity_fragment_one, container, false);
        return view;
    }
}
