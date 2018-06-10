package myapplocation.jose.myappenglish.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import myapplocation.jose.myappenglish.controll.layout.AdapterCenas;
import myapplocation.jose.myappenglish.R;

public class CenasActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int filme = 0;

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
                this.filme = (int) intent.getExtras().get("filme");
            }

            mAdapter = new AdapterCenas(MainActivity.listarCenasIdFilme(this.filme), this);
            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}
