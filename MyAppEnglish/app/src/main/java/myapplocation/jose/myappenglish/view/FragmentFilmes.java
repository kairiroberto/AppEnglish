package myapplocation.jose.myappenglish.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import myapplocation.jose.myappenglish.controll.layout.AdapterFilmes;
import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.dao.FilmeDao;

public class FragmentFilmes extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context context;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycler_view_filmes);
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_filme);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new AdapterFilmes(FilmeDao.listarFilmes(), this);
            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recycler_view_filmes, container, false);

        context = view.getContext();

        try {

            mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view_filme);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(context);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new AdapterFilmes(FilmeDao.listarFilmes(), context);
            mRecyclerView.setAdapter(mAdapter);

        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        return view;
    }

}
