package com.example.companyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;

public class StructureActivity extends AppCompatActivity {

    WebView web;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progress = new ProgressDialog(StructureActivity.this);
        progress.setMessage("Mohon Bersabar....");
        progress.show();

        web = findViewById(R.id.webstructure);

        web.loadUrl("https://smkn1tanjungpandan.sch.id/profile/struktur+organisasi  ");

        web.setWebViewClient(new webViewClient(){

            public void onPageFinished(WebView view, String url) {
                super.ononPageFinished(view, url);
                progress.dismiss();
                getSupportActionBar().setTitle(web.getTitle());

            } });

    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()){
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
