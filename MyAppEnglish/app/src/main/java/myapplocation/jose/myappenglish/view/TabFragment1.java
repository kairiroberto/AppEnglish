package myapplocation.jose.myappenglish.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.controll.layout.AdapterTabFragment1;
import myapplocation.jose.myappenglish.controll.layout.PagerAdapter;

public class TabFragment1 extends Fragment implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static VideoView vvAssistir;
    private Button btFilmePlay;
    private Button btFilmeStop;
    private static Context context;
    private int cena = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab1, container, false);
        context = view.getContext();

        try {

            mRecyclerView = (RecyclerView) view.findViewById(R.id.rvAssistir);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(view.getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);

            this.cena = PagerAdapter.getCena();

            mAdapter = new AdapterTabFragment1(MainActivity.listarFalasIdCena(this.cena), view.getContext());
            mRecyclerView.setAdapter(mAdapter);

            vvAssistir = (VideoView) view.findViewById(R.id.vvAssistir);
            btFilmePlay = (Button) view.findViewById(R.id.btFilmePlay);
            btFilmeStop = (Button) view.findViewById(R.id.btFilmeStop);

            btFilmePlay.setOnClickListener(this);
            btFilmeStop.setOnClickListener(this);

        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btFilmePlay) {
            onPlayVideoAssistir(this.cena);
        } else if (v.getId() == R.id.btFilmeStop) {
            onStopVideoAssistir();
        }
    }

    public static void onPlayVideoAssistir(final int cena){
        try {
            TabFragment2.onStopVideoPraticar();
            TabFragment3.onStopOuvir();
            TabFragment4.onStopMeuVideoAssistir();
            final int[] i = {0};
            vvAssistir.setVideoURI(Uri.parse(MainActivity.listarFalasIdCena(cena).get(i[0]).getVideo()));
            vvAssistir.start();
            Toast.makeText(context, "Fala: " + String.valueOf(i[0] + 1) + "/" + String.valueOf(MainActivity.listarFalasIdCena(cena).size()), Toast.LENGTH_SHORT).show();
            i[0]++;
            vvAssistir.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (i[0] < MainActivity.listarFalasIdCena(cena).size()) {
                        Toast.makeText(context, "Fala: " + String.valueOf(i[0] + 1) + "/" + MainActivity.listarFalasIdCena(cena).size(), Toast.LENGTH_SHORT).show();
                        vvAssistir.setVideoURI(Uri.parse(MainActivity.listarFalasIdCena(cena).get(i[0]).getVideo()));
                        vvAssistir.start();
                        i[0]++;
                    }
                }
            });

        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void onStopVideoAssistir(){
        try {
            vvAssistir.stopPlayback();
        } catch (Exception e) {

        }
    }

}
