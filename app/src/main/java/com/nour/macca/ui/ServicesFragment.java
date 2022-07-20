package com.nour.macca.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nour.macca.R;

public class ServicesFragment extends Fragment {

    private  TextView service1, service2, service3, service4, service5;
    private LinearLayout service_layout1, service_layout2, service_layout3,service_layout4,service_layout5;
    private int state1 = 0, state2 = 0, state3 = 0, state4 = 0,state5 = 0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_services, container, false);
        service1 = root.findViewById(R.id.service1);
        service2 = root.findViewById(R.id.service2);
        service3 = root.findViewById(R.id.service3);
        service4 = root.findViewById(R.id.service4);
        service5 = root.findViewById(R.id.service5);

        service_layout1 = root.findViewById(R.id.service_layout1);
        service_layout2 = root.findViewById(R.id.service_layout2);
        service_layout3 = root.findViewById(R.id.service_layout3);
        service_layout4 = root.findViewById(R.id.service_layout4);
        service_layout5 = root.findViewById(R.id.service_layout5);


        service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state1 == 0){
                    service_layout1.setVisibility(View.VISIBLE);
                    service1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_up_24,0,0,0);
                    state1 = 1;
                }
                else {
                    service_layout1.setVisibility(View.GONE);
                    service1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_down_24,0,0,0);
                    state1 = 0;
                }

            }
        });

        service2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state2 == 0){
                    service_layout2.setVisibility(View.VISIBLE);
                    service2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_up_24,0,0,0);
                    state2 = 1;
                }
                else {
                    service_layout2.setVisibility(View.GONE);
                    service2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_down_24,0,0,0);
                    state2 = 0;
                }
            }
        });


        service3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state3 == 0){
                    service_layout3.setVisibility(View.VISIBLE);
                    service3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_up_24,0,0,0);
                    state3 = 1;
                }
                else {
                    service_layout3.setVisibility(View.GONE);
                    service3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_down_24,0,0,0);
                    state3 = 0;
                }
            }
        });

        service4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state4 == 0){
                    service_layout4.setVisibility(View.VISIBLE);
                    service4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_up_24,0,0,0);
                    state4 = 1;
                }
                else {
                    service_layout4.setVisibility(View.GONE);
                    service4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_down_24,0,0,0);
                    state4 = 0;
                }
            }
        });

        service5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state5 == 0){
                    service_layout5.setVisibility(View.VISIBLE);
                    service5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_up_24,0,0,0);
                    state5 = 1;
                }
                else {
                    service_layout5.setVisibility(View.GONE);
                    service5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_arrow_down_24,0,0,0);
                    state5 = 0;
                }
            }
        });
        return root;
    }
}