package com.example.companyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JurusanActivity extends AppCompatActivity {

    TextView textViewrpl;
    TextView textviewtkj;
    TextView textviewakl;
    TextView textviewmp;
    TextView textviewpm;
    LinearLayout layoutrpl;
    LinearLayout layouttkj;
    LinearLayout layoutakl;
    LinearLayout layoutmp;
    LinearLayout layoutpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurusan);
//        textview
        textViewrpl = findViewById(R.id.textrpl);
        textviewtkj = findViewById(R.id.texttkj);
        textviewakl = findViewById(R.id.textakl);
        textviewmp = findViewById(R.id.textmp);
        textviewpm = findViewById(R.id.textpm);
//        layout
        layoutrpl = findViewById(R.id.layoutrpl);
        layouttkj = findViewById(R.id.layouttkj);
        layoutakl = findViewById(R.id.layoutakl);
        layoutmp = findViewById(R.id.layoutmp);
        layoutpm = findViewById(R.id.layoutpm);
//          layout transisi
        layoutrpl.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layouttkj.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layoutakl.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layoutmp.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layoutpm.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }
    public void expand(View view) {
        if (textViewrpl.getVisibility() == View.GONE){
            textViewrpl.setVisibility(View.VISIBLE);
        } else {
            textViewrpl.setVisibility(View.GONE);
        }
    }
    public void expand1(View view ) {
        if (textviewtkj.getVisibility() == View.GONE){
            textviewtkj.setVisibility(View.VISIBLE);
        } else {
            textviewtkj.setVisibility(View.GONE);
        }
    }
    public void expand2(View view ) {
        if (textviewakl.getVisibility() == View.GONE){
            textviewakl.setVisibility(View.VISIBLE);
        } else {
            textviewakl.setVisibility(View.GONE);
        }
    }
    public void expand3(View view ) {
        if (textviewmp.getVisibility() == View.GONE){
            textviewmp.setVisibility(View.VISIBLE);
        } else {
            textviewmp.setVisibility(View.GONE);
        }
    }
    public void expand4(View view ) {
        if (textviewpm.getVisibility() == View.GONE){
            textviewpm.setVisibility(View.VISIBLE);
        } else {
            textviewpm.setVisibility(View.GONE);
        }
    }
}

