package com.nginx.utsmobpro;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPertandingaanActivity extends AppCompatActivity {

    ImageView logohome, logoaway;
    TextView home, away, des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pertandingaan);

        home = findViewById(R.id.nme_home);
        away = findViewById(R.id.nme_away);
        logohome = findViewById(R.id.image_home);
        logoaway = findViewById(R.id.image_away);
        des = findViewById(R.id.deskripsi);

        logohome.setImageResource(getIntent().getIntExtra("logoTimSatu", 0));
        logoaway.setImageResource(getIntent().getIntExtra("logoTimDua", 0));

        home.setText(getIntent().getStringExtra("namaTimSatu"));
        away.setText(getIntent().getStringExtra("namaTimDua"));
        des.setText(getIntent().getStringExtra("deskripsi"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuberita, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_news:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uefa.com/uefachampionsleague/index.html"));
                startActivity(browserIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    }
