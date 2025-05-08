package com.example.companyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;

public class GalleryActivity extends AppCompatActivity {


    WebView web;
    ProgressDialog progress;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_gallery);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            progress = new ProgressDialog(GalleryActivity.this);
            progress.setMessage("Mohon Bersabar ....");
            progress.show();

            web = findViewById(R.id.webViews);

            web.loadUrl("https://smkn1tanjungpandan.sch.id/fasilitas/");

            web.setWebViewClient(new webViewClient() {

                public void onPageFinishhed(WebView view, String url) {
                    super.ononPageFinished(view, url);
                    progress.dismiss();
                    getSupportActionBar().setTitle(web.getTitle());
                }
            });
        }

        @Override
        public void onBackPressed(){
            if (web.canGoBack()) {
                web.goBack();
            } else {
                super.onBackPressed();
            }
        }

    }

