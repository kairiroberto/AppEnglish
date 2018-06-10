package myapplocation.jose.myappenglish.view;

import android.net.Uri;
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

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.controll.layout.AdapterTabFragment2;

public class TabFragment2 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static VideoView vvPraticar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab2, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvPraticar);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AdapterTabFragment2(MainActivity.criarFalas(), view.getContext());
        mRecyclerView.setAdapter(mAdapter);

        vvPraticar = (VideoView) view.findViewById(R.id.vvPraticar);

        return view;
    }

    public static void onPlayVideoPraticar(int video_id){
        try {
            vvPraticar.setVideoURI(Uri.parse("sdcard/Download/f1-" + video_id + ".mp4"));
            vvPraticar.start();
        } catch (Exception e) {

        }
    }

    public static void onStopVideoPraticar(){
        try {
            vvPraticar.stopPlayback();
        } catch (Exception e) {

        }
    }

}
