package com.example.companyprofile;

import android.animation.LayoutTransition;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.companyprofile.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    WebView web;
    ProgressDialog progress;

    TextView textvisimisi;

    TextView text;
    LinearLayout layoutvisimisi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        text = findViewById(R.id.testasu);
        text.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text.setSelected(true);  // Set focus to the textview


        textvisimisi = findViewById(R.id.textvisimisi);

        layoutvisimisi = findViewById(R.id.layoutvisimisi);

        layoutvisimisi.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progress = new ProgressDialog(MainActivity.this);
        progress.setMessage("Mohon Bersabar....");
        progress.show();

        web = findViewById(R.id.webhome);

        web.loadUrl("https://smkn1tanjungpandan.sch.id/implementation-of-the-viera-vocational-institutional-english-readiness-asessment-for-class-11-all-majors-at-smk-n-1-tanjungpandan/");

        web.setWebViewClient(new webViewClient(){

            public void onPageFinished(WebView view, String url) {
                super.ononPageFinished(view, url);
                progress.dismiss();
                getSupportActionBar().setTitle(web.getTitle());

            }
        });


//        actionmenu
//        Whatsaap = findViewById(R.id.action_wa);
//        setContentView(R.layout.activity_main);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.layoutfragment, new HomeFragment())
//                .commit();

//        setSupportActionBar(binding.appBarMain.toolbar);
//        getSupportActionBar().setTitle("company");
//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.layoutfragment, new HomeFragment())
                            .commit();
                    getSupportActionBar().setTitle("Company Profile App");

                } else if (id == R.id.nav_gallery) {
                    Intent jump = new Intent(MainActivity.this, GalleryActivity.class);
                    startActivity(jump);

                } else if (id == R.id.nav_web) {
                    Intent jump = new Intent(MainActivity.this, WebActivity.class);
                    startActivity(jump);

                }   else if (id == R.id.nav_prestasi) {
                        Intent jump = new Intent(MainActivity.this, PrestasiActivity.class);
                        startActivity(jump);

                } else if (id == R.id.nav_struktur) {
                    Intent jump = new Intent(MainActivity.this, StructureActivity.class);
                    startActivity(jump);

                } else if (id == R.id.nav_jurusan) {
                    Intent jump = new Intent(MainActivity.this, JurusanActivity.class);
                    startActivity(jump);

                } else if (id == R.id.nav_send){
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:smkn1tgpandan@gmail.com"));
//                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "nama saya bla");
//                    emailIntent.putExtra(Intent.EXTRA_TEXT, "wow");
                    startActivity(Intent.createChooser(emailIntent, "kunkung"));

                } else if (id == R.id.nav_share) {
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.putExtra(Intent.EXTRA_TEXT, "Ayo Lihat Aplikasi SMKN1 Tanjung Pandan !!");
                    startActivity(Intent.createChooser(share,"Bagikan Ke Siapapun"));
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        navigationView.bringToFront();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
            String urlfb ="https://www.facebook.com/smkn1tanjungpandan?_rdc=1&_rdr";
            String urlig ="https://www.instagram.com/smkn1tanjungpandan/";
            String urlyt ="https://www.youtube.com/@smknegeri1tanjungpandan912/featured";

        if (id == R.id.action_fb ){
//            //intent call
            Intent call = new Intent(Intent.ACTION_VIEW);
            call.setData(Uri.parse(urlfb));
            startActivity(call);
        }
        if (id == R.id.action_ig ){
//            //intent call
            Intent call = new Intent(Intent.ACTION_VIEW);
            call.setData(Uri.parse(urlig));
            startActivity(call);
        }
        if (id == R.id.action_yt ){
//            //intent call
            Intent call = new Intent(Intent.ACTION_VIEW);
            call.setData(Uri.parse(urlyt));
            startActivity(call);
        }
            return super .onOptionsItemSelected(item);

    }

    public void expandvisimisi (View view ) {
        if (textvisimisi.getVisibility() == View.GONE){
            textvisimisi.setVisibility(View.VISIBLE);
        } else {
            textvisimisi.setVisibility(View.GONE);
        }
    }
    public void home (View view) {
        Toast.makeText(this,"Anda Sudah Berada Di Halaman Beranda !! ",Toast.LENGTH_SHORT).show();
    }
    public void prestasi (View view) {
        Intent jur = new Intent(MainActivity.this, PrestasiActivity.class);
        startActivity(jur);
    }
    public void fasilitas (View view) {
        Intent jur = new Intent(MainActivity.this, GalleryActivity.class);
        startActivity(jur);
    }
    public void jurusan (View view) {
        Intent jur = new Intent(MainActivity.this, JurusanActivity.class);
        startActivity(jur);
    }
    public void struktur (View view) {
        Intent jur = new Intent(MainActivity.this, StructureActivity.class);
        startActivity(jur);
    }
    public void web (View view) {
        Intent jur = new Intent(MainActivity.this, WebActivity.class);
        startActivity(jur);
    }
}