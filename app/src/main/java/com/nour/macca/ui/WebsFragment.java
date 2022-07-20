package com.nour.macca.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nour.macca.R;

public class WebsFragment extends Fragment {

    TextView link1, link2, link3, link4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_webs, container, false);

        link1 = root.findViewById(R.id.link1);
        link1.setMovementMethod(LinkMovementMethod.getInstance());
        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(
                        "https://gazt.gov.sa/ar/pages/default.aspx" );
                Intent intent = new Intent( Intent.ACTION_VIEW, uri );
                startActivity(intent);
            }
        });

        link2 = root.findViewById(R.id.link2);
        link2.setMovementMethod(LinkMovementMethod.getInstance());
        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(
                        "https://gstc.gov.sa/ar/Pages/default.aspx" );
                Intent intent = new Intent( Intent.ACTION_VIEW, uri );
                startActivity(intent);
            }
        });

        link3 = root.findViewById(R.id.link3);
        link3.setMovementMethod(LinkMovementMethod.getInstance());
        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(
                        "https://www.gosi.gov.sa/GOSIOnline/GOSIOnlineHomepage" );
                Intent intent = new Intent( Intent.ACTION_VIEW, uri );
                startActivity(intent);
            }
        });

        link4 = root.findViewById(R.id.link4);
        link4.setMovementMethod(LinkMovementMethod.getInstance());
        link4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(
                        "https://hrsd.gov.sa" );
                Intent intent = new Intent( Intent.ACTION_VIEW, uri );
                startActivity(intent);
            }
        });

        return root;
    }
}