package myapplocation.jose.myappenglish.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.controll.layout.AdapterTabFragment2;
import myapplocation.jose.myappenglish.controll.layout.PagerAdapter;
import myapplocation.jose.myappenglish.model.dao.FalaDao;

public class TabFragment2 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context context;
    private static VideoView vvPraticar;
    private static int cena = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab2, container, false);
        this.context = view.getContext();

        try {

            mRecyclerView = (RecyclerView) view.findViewById(R.id.rvPraticar);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(view.getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);

            this.cena = PagerAdapter.getCena();

            mAdapter = new AdapterTabFragment2(FalaDao.listarFalasIdCena(this.cena), view.getContext());
            mRecyclerView.setAdapter(mAdapter);

            vvPraticar = (VideoView) view.findViewById(R.id.vvPraticar);

        } catch (Exception e) {

        }

        return view;
    }

    public static void onPlayVideoPraticar(int video_id){
        try {
            /*TabFragment1.onStopVideoAssistir();
            TabFragment3.onStopOuvir();
            FragmentAssistir.onStopMeuVideoAssistir();*/
            vvPraticar.setVideoURI(Uri.parse(FalaDao.listarFalasIdCena(cena).get(video_id).getVideo()));
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
