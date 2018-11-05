package com.nginx.utsmobpro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class ListPertandinganActivity extends AppCompatActivity {

    private final LinkedList<ModelPertandingan> listPertandingan = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private ListPertandinganAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pertandingan);

        //set data
        listPertandingan.addLast(new ModelPertandingan(
                "Man.United",
                "Man.City", R.drawable.mufc, R.drawable.mcfc,
                "Citizen Dijagokan pada pertandingan 7 november nanti karena rekor tandang yang baik"));
        listPertandingan.addLast(new ModelPertandingan(
                "Dortmund",
                "München", R.drawable.bvb, R.drawable.fcbm,
                "München Dijagokan pada pertandingan 7 november nanti karena rekor tandang yang baik"));
        listPertandingan.addLast(new ModelPertandingan(
                "Gdańsk",
                "Juventus", R.drawable.lgfc, R.drawable.juve,
                "Gdańsk Dijagokan pada pertandingan 7 november nanti karena performa egy maulana vikri dalam keadaan puncak"));
        listPertandingan.addLast(new ModelPertandingan(
                "Man.United",
                "Juventus", R.drawable.mufc, R.drawable.juve,
                "WELCOME HOME C.RONALDO, Menjadi Tajuk dalam Pertandingan ini"));
        listPertandingan.addLast(new ModelPertandingan(
                "München",
                "Man.City", R.drawable.fcbm, R.drawable.mcfc,
                "Bola.com, Miami - Manchester City dan Bayern Munchen akan memainkan laga terakhir mereka pada ajang International Champions Cup 2018 di Hard Rock Stadium, Miami, Minggu (29/7/2018) pagi WIB. Kali ini, The Citizens akan diperkuat amunisi baru."));

        mRecyclerView = (RecyclerView) findViewById(R.id.list_pertandingan_cyc);

        mAdapter = new ListPertandinganAdapter(ListPertandinganActivity.this, listPertandingan);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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

