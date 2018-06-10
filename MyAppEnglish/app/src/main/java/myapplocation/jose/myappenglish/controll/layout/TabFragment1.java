package myapplocation.jose.myappenglish.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.controll.layout.AdapterTabFragment1;
import myapplocation.jose.myappenglish.model.Fala;

public class TabFragment1 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static VideoView vvAssistir;
    private Button btFilmePlay, btFilmeStop;
    private static Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab1, container, false);
        context = view.getContext();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvAssistir);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AdapterTabFragment1(MainActivity.criarFalas(), view.getContext());
        mRecyclerView.setAdapter(mAdapter);

        vvAssistir = (VideoView) view.findViewById(R.id.vvAssistir);
        btFilmePlay = (Button) view.findViewById(R.id.btFilmePlay);
        btFilmeStop = (Button) view.findViewById(R.id.btFilmeStop);

        btFilmePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayVideoAssistir();
            }
        });
        btFilmeStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStopVideoAssistir();
            }
        });

        return view;
    }

    public static void onPlayVideoAssistir(){
        TabFragment2.onStopVideoPraticar();
        try {
            vvAssistir.setVideoURI(Uri.parse("/sdcard/Download/f1-1.mp4"));
            vvAssistir.start();
            Toast.makeText(context, "Fala: 1", Toast.LENGTH_SHORT).show();
            vvAssistir.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                int i = 2;
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (i <= MainActivity.criarFalas().size()) {
                        Toast.makeText(context, "Fala: " + String.valueOf(i), Toast.LENGTH_SHORT).show();
                        vvAssistir.setVideoURI(Uri.parse("sdcard/Download/f1-" + i + ".mp4"));
                        vvAssistir.start();
                        i++;
                    }
                }
            });
        } catch (Exception e) {

        }
    }

    public static void onStopVideoAssistir(){
        try {
            vvAssistir.stopPlayback();
        } catch (Exception e) {

        }
    }

}
