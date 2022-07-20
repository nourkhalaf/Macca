package com.nour.macca.ui;

import android.content.Intent;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nour.macca.PdfActivity;
import com.nour.macca.R;



public class FilesFragment extends Fragment {

    TextView pdf1, pdf2, pdf3, pdf4, pdf5;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_files, container, false);

        pdf1 = root.findViewById(R.id.pdf1);
        pdf2 = root.findViewById(R.id.pdf2);
        pdf3 = root.findViewById(R.id.pdf3);
        pdf4 = root.findViewById(R.id.pdf4);
        pdf5 = root.findViewById(R.id.pdf5);

        pdf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PdfActivity.class);
                intent.putExtra("pdfNumber","pdf1.pdf");
                startActivity(intent);
            }
        });

        pdf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PdfActivity.class);
                intent.putExtra("pdfNumber","pdf2.pdf");
                startActivity(intent);
            }
        });

        pdf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PdfActivity.class);
                intent.putExtra("pdfNumber","pdf3.pdf");
                startActivity(intent);
            }
        });

        pdf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PdfActivity.class);
                intent.putExtra("pdfNumber","pdf4.pdf");
                startActivity(intent);
            }
        });

        pdf5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PdfActivity.class);
                intent.putExtra("pdfNumber","pdf5.pdf");
                startActivity(intent);
            }
        });


        return root;
    }


}