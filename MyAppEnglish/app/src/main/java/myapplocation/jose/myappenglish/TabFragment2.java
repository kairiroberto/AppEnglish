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
        return view;
    }

    private void onPlayVideo(){
        String[] videos = new String[10];
        videos[0] = "/sdcard/Download/f1-1.mp4";
        videos[1] = "/sdcard/Download/f1-2.mp4";
        videos[2] = "/sdcard/Download/f1-3.mp4";
        videos[3] = "/sdcard/Download/f1-4.mp4";
        videos[4] = "/sdcard/Download/f1-5.mp4";
        videos[5] = "/sdcard/Download/f1-6.mp4";
        videos[6] = "/sdcard/Download/f1-7.mp4";
        videos[7] = "/sdcard/Download/f1-8.mp4";
        videos[8] = "/sdcard/Download/f1-9.mp4";
        videos[9] = "/sdcard/Download/f1-10.mp4";
        for (int i = 0; i < videos.length; i++) {
            vvPraticar.setVideoPath(videos[i]);
            vvPraticar.start();
        }
    }

}
