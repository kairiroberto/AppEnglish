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
import myapplocation.jose.myappenglish.controll.layout.AdapterTabFragment4;
import myapplocation.jose.myappenglish.controll.layout.PagerAdapter;
import myapplocation.jose.myappenglish.model.Fala;
import myapplocation.jose.myappenglish.model.FalaUsuario;

public class TabFragment4 extends Fragment implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static VideoView vvMeusVideos;
    private Button btMeusVideosStop;
    private static Context context;
    private int cena = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab4, container, false);

        context = view.getContext();

        try {

            mRecyclerView = (RecyclerView) view.findViewById(R.id.rvMeusVideos);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(view.getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);

            this.cena = PagerAdapter.getCena();

            mAdapter = new AdapterTabFragment4(MainActivity.listarFilmesUsuario(), view.getContext());
            mRecyclerView.setAdapter(mAdapter);

            vvMeusVideos = (VideoView) view.findViewById(R.id.vvMeusVideos);
            btMeusVideosStop = (Button) view.findViewById(R.id.btMeusVideosStop);

            btMeusVideosStop.setOnClickListener(this);

        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btMeusVideosStop) {
            /*TabFragment1.onStopVideoAssistir();
            TabFragment2.onStopVideoPraticar();
            TabFragment3.onStopOuvir();
            onStopMeuVideoAssistir();*/

        }
    }

    public static void onPlayMeuVideoAssistir(final int meuFilme, final int cena, final int personagem){
        try {
            final List<FalaUsuario> mDataSet = MainActivity.listarFalasUsuarioIdFilme(meuFilme);
            final List<Fala> dataSet = MainActivity.listarFalasIdCena(cena);
            final int[] i = {0};

            if (personagem == 1) {
                vvMeusVideos.setVideoURI(Uri.parse(mDataSet.get(i[0]).getLocalGravacao()));
                vvMeusVideos.start();
            } else if (personagem == 2) {
                vvMeusVideos.setVideoURI(Uri.parse(dataSet.get(i[0]).getVideo()));
                vvMeusVideos.start();
            }

            Toast.makeText(context, (i[0]+1) + "/" + dataSet.size(), Toast.LENGTH_SHORT).show();

            vvMeusVideos.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    i[0]++;
                    if (i[0] < dataSet.size()) {
                        if (personagem == 1) {
                            if (i[0] % 2 == 0) {
                                vvMeusVideos.setVideoURI(Uri.parse(mDataSet.get(i[0]).getLocalGravacao()));
                                vvMeusVideos.start();
                            } else {
                                vvMeusVideos.setVideoURI(Uri.parse(dataSet.get(i[0]).getVideo()));
                                vvMeusVideos.start();
                            }
                        } else if (personagem == 2) {
                            if (i[0] % 2 != 0) {
                                vvMeusVideos.setVideoURI(Uri.parse(mDataSet.get(i[0]).getLocalGravacao()));
                                vvMeusVideos.start();
                            } else {
                                vvMeusVideos.setVideoURI(Uri.parse(dataSet.get(i[0]).getVideo()));
                                vvMeusVideos.start();
                            }
                        }
                    }
                    Toast.makeText(context, (i[0]+1) + "/" + dataSet.size(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void onStopMeuVideoAssistir(){
        try {
            vvMeusVideos.stopPlayback();
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
