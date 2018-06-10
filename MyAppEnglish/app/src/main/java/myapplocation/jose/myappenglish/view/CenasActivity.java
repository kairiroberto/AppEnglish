package myapplocation.jose.myappenglish.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.controll.layout.AdapterCenas;
import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.Cena;

public class CenasActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycler_view_cenas);
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_cena);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            Intent intent = getIntent();
            if (intent.getExtras().get("filme") != null) {
                Toast.makeText(this, intent.getExtras().get("filme").toString(), Toast.LENGTH_SHORT).show();
            }

            mAdapter = new AdapterCenas(MainActivity.criarCenas(), this);
            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}
