package myapplocation.jose.myappenglish;

import android.media.MediaPlayer;
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

import java.util.ArrayList;
import java.util.List;

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
        List<String> myDataset = new ArrayList<String>();
        myDataset.add("Fala 1: Vaider: No I am your father. \n(Vaider: Não Eu sou o seu pai.)");
        myDataset.add("Fala 2: Luke: No. No. No. That's not true. It's impossible. \n(Luke: Não. Não. Não é verdade. É impossível.)");
        myDataset.add("Fala 3: Vaider: Listen your heart. You know it's true. \n(Vaider: Ouça o seu coração. Sabe que é verdade.)");
        myDataset.add("Fala 4: Luke: No. No. \n(Luke: Não. Não.)");
        myDataset.add("Fala 5: Vaider: Luke, you can destroy the Emperor. He already foresaw this. \n(Vaider: Luke, você pode destruir o Imperador. Ele já previu isso.)");
        myDataset.add("Fala 6: Vaider: It is your destiny. Join me. \n(Vaider: É o seu destino. Junte-se a mim.)");
        myDataset.add("Fala 7: Vaider: Together we can rule the galaxy as father and son. \n(Vaider: Juntos poderemos governar a galáxia como pai e filho.)");
        myDataset.add("Fala 8: ... \n(...)");
        myDataset.add("Fala 9: Vaider: Come with me. \n(Vaider: Venha comigo.)");
        myDataset.add("Fala 10: Vaider: It's your only way out. \n(Vaider: É sua única saída.)");
        mAdapter = new TabFragment2Adapter(myDataset, view.getContext());
        mRecyclerView.setAdapter(mAdapter);
        vvPraticar = (VideoView) view.findViewById(R.id.vvPraticar);
        return view;
    }

    public static void onPlayVideo(int video_id){
        try {
            vvPraticar.setVideoURI(Uri.parse("sdcard/Download/f1-" + video_id + ".mp4"));
            vvPraticar.start();
        } catch (Exception e) {

        }
    }

}
