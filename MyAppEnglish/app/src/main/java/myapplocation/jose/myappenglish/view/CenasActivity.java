package myapplocation.jose.myappenglish.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.controll.layout.MyAdapterCenas;
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

            List<Cena> myDataset = new ArrayList<Cena>();
            myDataset.add(new Cena(1, 1, "Filme 1", "1", "10:00", R.drawable.vaivsluk));
            myDataset.add(new Cena(1, 2, "Filme 1", "2", "20:00", 0));
            myDataset.add(new Cena(1, 3, "Filme 1", "3", "30:00", 0));
            myDataset.add(new Cena(1, 4, "Filme 1", "4", "40:00", 0));
            myDataset.add(new Cena(1, 5, "Filme 1", "5", "50:00", 0));

            mAdapter = new MyAdapterCenas(myDataset, this);
            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}
