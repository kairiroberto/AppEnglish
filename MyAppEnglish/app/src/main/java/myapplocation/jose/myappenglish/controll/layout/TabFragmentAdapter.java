package myapplocation.jose.myappenglish.controll.layout;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.List;

import myapplocation.jose.myappenglish.R;

/**
 * Created by JOSE on 24-5-18.
 */

public class TabFragmentAdapter extends RecyclerView.Adapter<TabFragmentAdapter.Tab1ViewHolder> {

    private List<String> mDataset;
    private Context context;
    private int tela;
    private final Handler handler = new Handler();

    public static class Tab1ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cv1;
        CardView cv2;
        TextView frase1;
        TextView frase2;
        Context context;
        VideoView vvAssistir;
        VideoView vvPraticar;
        Button btFilmePlay, btFilmeStop;

        public Tab1ViewHolder(View v, Context context) {
            super(v);
            this.context = context;
            cv1 = (CardView)v.findViewById(R.id.cvTab1);
            frase1 = (TextView)v.findViewById(R.id.tvTab1);
            cv2 = (CardView)v.findViewById(R.id.cvTab2);
            frase2 = (TextView)v.findViewById(R.id.tvTab2);
            vvPraticar = (VideoView) v.findViewById(R.id.vvPraticar);
            vvAssistir = (VideoView) v.findViewById(R.id.vvAssistir);
            btFilmePlay = (Button) v.findViewById(R.id.btFilmePlay);
            btFilmeStop = (Button) v.findViewById(R.id.btFilmeStop);
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
        }

        private void onPlayVideoAssistir(){
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

        private void onStopVideoAssistir(){
            try {
                vvAssistir.stopPlayback();
            } catch (Exception e) {

            }
        }

    }

    public TabFragmentAdapter(List<String> myDataset, Context context, int tela) {
        this.mDataset = myDataset;
        this.context = context;
        this.tela = tela;
    }

    @Override
    public Tab1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (this.tela == 1) {
            view = LayoutInflater.from(this.context).inflate(R.layout.layout_tab1_card, parent, false);
        } else if (this.tela == 2) {
            view = LayoutInflater.from(this.context).inflate(R.layout.layout_tab2_card, parent, false);
        }
        Tab1ViewHolder vh = new Tab1ViewHolder(view, this.context);
        return vh;
    }

    @Override
    public void onBindViewHolder(final Tab1ViewHolder holder, final int position) {
        holder.frase1.setText(mDataset.get(position));
        holder.frase2.setText(mDataset.get(position));
        if (position % 2 == 0) {
            holder.frase1.setTextColor(Color.RED);
            holder.frase2.setTextColor(Color.RED);
        } else {
            holder.frase1.setTextColor(Color.BLACK);
            holder.frase2.setTextColor(Color.BLACK);
        }
        holder.frase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.vvPraticar.setVideoURI(Uri.parse("sdcard/Download/f1-" + position+1 + ".mp4"));
                holder.vvPraticar.start();
                if (holder.frase2.getCurrentTextColor() == Color.BLUE) {
                    if (position % 2 == 0) {
                        holder.frase2.setTextColor(Color.RED);
                    } else {
                        holder.frase2.setTextColor(Color.BLACK);
                    }
                } else {
                    holder.frase2.setTextColor(Color.BLUE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
