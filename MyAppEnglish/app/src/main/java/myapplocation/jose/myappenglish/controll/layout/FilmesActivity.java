package myapplocation.jose.myappenglish.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.controll.layout.AdapterFilmes;
import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.Filme;

public class FilmesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycler_view_filmes);
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_filme);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new AdapterFilmes(MainActivity.criarFilmes(), this);
            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
