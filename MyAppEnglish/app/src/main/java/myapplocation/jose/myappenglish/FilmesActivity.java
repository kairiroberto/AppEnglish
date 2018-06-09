package myapplocation.jose.myappenglish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
            List<Filme> myDataset = new ArrayList<Filme>();
            myDataset.add(new Filme("Filme 1", "10", "10:00", R.drawable.vaivsluk));
            myDataset.add(new Filme("Filme 2", "20", "20:00", 0));
            myDataset.add(new Filme("Filme 3", "30", "30:00", 0));
            myDataset.add(new Filme("Filme 4", "40", "40:00", 0));
            myDataset.add(new Filme("Filme 5", "50", "50:00", 0));
            mAdapter = new MyAdapterFilmes(myDataset, this);
            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
