package myapplocation.jose.myappenglish;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class TabFragment2 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private VideoView vvPraticar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab2, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvPraticar);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<String> myDataset = new ArrayList<String>();
        myDataset.add("Roberto: oi");
        myDataset.add("Davi: oi");
        myDataset.add("Roberto: onde você está?");
        mAdapter = new TabFragment1Adapter(myDataset, view.getContext());
        mRecyclerView.setAdapter(mAdapter);
        vvPraticar = (VideoView) view.findViewById(R.id.vvPraticar);
        vvPraticar.setVideoPath("/sdcard/Download/f1.mp4");
        vvPraticar.start();
        return view;
    }
}
