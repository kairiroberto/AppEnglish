package myapplocation.jose.myappenglish;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.RGBToHSV;
import static android.graphics.Color.YELLOW;
import static myapplocation.jose.myappenglish.R.color.colorPrimary;

public class TabFragment1 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private VideoView vvAssistir;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab1, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvAssistir);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<String> myDataset = new ArrayList<String>();
        myDataset.add("Roberto: oi");
        myDataset.add("Davi: oi");
        myDataset.add("Roberto: onde você está?");
        mAdapter = new TabFragment1Adapter(myDataset, view.getContext());
        mRecyclerView.setAdapter(mAdapter);
        vvAssistir = (VideoView) view.findViewById(R.id.vvAssistir);
        vvAssistir.setVideoPath("/sdcard/Download/f1.mp4");
        vvAssistir.start();
        return view;
    }
}
