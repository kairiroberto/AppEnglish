package myapplocation.jose.myappenglish.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    public static VideoView vvMeusVideos;
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

    public static void onPlayMeuVideoAssistir(final int meuFilme, final int cena, final int personagem) {
        try {

            final List<FalaUsuario> mDataSet = MainActivity.listarFalasUsuarioIdFilme(meuFilme);
            final List<Fala> dataSet = MainActivity.listarFalasIdCena(cena);

            final int[] i_cena = {0};
            final int[] i_usuario = {0};
            final Uri[] uri = {null};

            if (personagem == 1) {
                uri[0] = Uri.parse(mDataSet.get(i_usuario[0]).getLocalGravacao());
            } else {
                uri[0] = Uri.parse(dataSet.get(i_cena[0]).getVideo());
            }

            if (uri != null) {
                vvMeusVideos.setVideoURI(uri[0]);
                vvMeusVideos.start();
            }

            vvMeusVideos.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (i_usuario[0] < mDataSet.size()) {
                        if (personagem == 1) {
                            if (uri[0].getPath().equals(mDataSet.get(i_usuario[0]).getLocalGravacao())) {
                                if (i_usuario[0] == 0) {
                                    i_cena[0]++;
                                } else {
                                    i_cena[0] = i_cena[0] + 2;
                                }
                                uri[0] = Uri.parse(dataSet.get(i_cena[0]).getVideo());
                                i_usuario[0]++;
                            } else {
                                uri[0] = Uri.parse(mDataSet.get(i_usuario[0]).getLocalGravacao());
                            }
                        } else {
                            if (uri[0].getPath().equals(dataSet.get(i_cena[0]).getVideo())) {
                                uri[0] = Uri.parse(mDataSet.get(i_usuario[0]).getLocalGravacao());
                                i_usuario[0]++;
                                i_cena[0] = i_cena[0] + 2;
                            } else {
                                uri[0] = Uri.parse(dataSet.get(i_cena[0]).getVideo());
                            }
                        }
                        vvMeusVideos.setVideoURI(uri[0]);
                        vvMeusVideos.start();
                    }
                }
            });

        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void onStopMeuVideoAssistir() {
        try {
            vvMeusVideos.stopPlayback();
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
