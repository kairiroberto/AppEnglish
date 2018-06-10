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
import myapplocation.jose.myappenglish.controll.layout.TabFragment1Adapter;
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

        List<Fala> myDataset = new ArrayList<Fala>();
        myDataset.add(new Fala(1, 1, "Fala 1: Vaider: No I am your father. \n(Vaider: Não Eu sou o seu pai.)"));
        myDataset.add(new Fala(1, 1, "Fala 2: Luke: No. No. No. That's not true. It's impossible. \n(Luke: Não. Não. Não é verdade. É impossível.)"));
        myDataset.add(new Fala(1, 1, "Fala 3: Vaider: Listen your heart. You know it's true. \n(Vaider: Ouça o seu coração. Sabe que é verdade.)"));
        myDataset.add(new Fala(1, 1, "Fala 4: Luke: No. No. \n(Luke: Não. Não.)"));
        myDataset.add(new Fala(1, 1, "Fala 5: Vaider: Luke, you can destroy the Emperor. He already foresaw this. \n(Vaider: Luke, você pode destruir o Imperador. Ele já previu isso.)"));
        myDataset.add(new Fala(1, 1, "Fala 6: Vaider: It is your destiny. Join me. \n(Vaider: É o seu destino. Junte-se a mim.)"));
        myDataset.add(new Fala(1, 1, "Fala 7: Vaider: Together we can rule the galaxy as father and son. \n(Vaider: Juntos poderemos governar a galáxia como pai e filho.)"));
        myDataset.add(new Fala(1, 1, "Fala 8: ... \n(...)"));
        myDataset.add(new Fala(1, 1, "Fala 9: Vaider: Come with me. \n(Vaider: Venha comigo.)"));
        myDataset.add(new Fala(1, 1, "Fala 10: Vaider: It's your only way out. \n(Vaider: É sua única saída.)"));

        mAdapter = new TabFragment1Adapter(myDataset, view.getContext());
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
                    if (i <= 10) {
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
