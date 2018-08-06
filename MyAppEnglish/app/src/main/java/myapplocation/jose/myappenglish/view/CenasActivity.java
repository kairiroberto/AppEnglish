package myapplocation.jose.myappenglish.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import myapplocation.jose.myappenglish.controll.layout.AdapterCenas;
import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.controll.layout.AdapterFilmes;
import myapplocation.jose.myappenglish.model.dao.CenaDao;
import myapplocation.jose.myappenglish.model.dao.FilmeDao;

public class CenasActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int filme = 0;
    private Context context;

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

            mAdapter = new AdapterCenas(CenaDao.listarCenasIdFilme(this.filme), this);
            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_recycler_view_filmes, container, false);

        context = view.getContext();

        try {

            mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view_cena);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(context);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new AdapterCenas(CenaDao.listarCenasIdFilme(this.filme), context);
            mRecyclerView.setAdapter(mAdapter);

            Intent intent = getActivity().getIntent();
            if (intent.getExtras().get("filme") != null) {
                Toast.makeText(context, intent.getExtras().get("filme").toString(), Toast.LENGTH_SHORT).show();
                this.filme = (int) intent.getExtras().get("filme");
            }

        }
        catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        return view;
    }*/


}
