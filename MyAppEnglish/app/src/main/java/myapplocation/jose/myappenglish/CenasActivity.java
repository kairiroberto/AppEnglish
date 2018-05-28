package myapplocation.jose.myappenglish;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
            List<Cena> myDataset = new ArrayList<Cena>();
            myDataset.add(new Cena("Filme 1", "1", "10:00"));
            myDataset.add(new Cena("Filme 1", "2", "20:00"));
            myDataset.add(new Cena("Filme 1", "3", "30:00"));
            myDataset.add(new Cena("Filme 1", "4", "40:00"));
            myDataset.add(new Cena("Filme 1", "5", "50:00"));
            mAdapter = new MyAdapterCenas(myDataset, this);
            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}
