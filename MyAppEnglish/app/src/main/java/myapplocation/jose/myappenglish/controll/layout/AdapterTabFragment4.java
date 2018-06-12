package myapplocation.jose.myappenglish.controll.layout;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.Fala;
import myapplocation.jose.myappenglish.model.FilmeUsuario;
import myapplocation.jose.myappenglish.view.MainActivity;
import myapplocation.jose.myappenglish.view.TabFragment1;
import myapplocation.jose.myappenglish.view.TabFragment2;
import myapplocation.jose.myappenglish.view.TabFragment4;

/**
 * Created by JOSE on 24-5-18.
 */

public class AdapterTabFragment4 extends RecyclerView.Adapter<AdapterTabFragment4.Tab1ViewHolder> {

    private List<FilmeUsuario> mDataset;
    private Context context;
    private final Handler handler = new Handler();

    public static class Tab1ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cv;
        TextView frase;
        Context context;

        public Tab1ViewHolder(View v, Context context) {
            super(v);
            this.context = context;
            cv = (CardView)v.findViewById(R.id.cvTab4);
            frase = (TextView)v.findViewById(R.id.tvTab4);
        }
    }

    public AdapterTabFragment4(List<FilmeUsuario> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public Tab1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.layout_tab4_card, parent, false);
        Tab1ViewHolder vh = new Tab1ViewHolder(view, this.context);
        return vh;
    }

    @Override
    public void onBindViewHolder(final Tab1ViewHolder holder, final int position) {
        //holder.imageView.findViewById(R.id.imageView);
        holder.frase.setText("Filme:" + mDataset.get(position).getFilme() + " - " + "Cena:" + mDataset.get(position).getCena() + "-" + "Pers.:" + mDataset.get(position).getPersonagem() + "-" + "Tam.: " + MainActivity.listarFalasUsuarioIdFilme(mDataset.get(position).getId()));
        if (position % 2 == 0) {
            holder.frase.setTextColor(Color.RED);
        } else {
            holder.frase.setTextColor(Color.BLACK);
        }
        holder.frase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabFragment4.onPlayMeuVideoAssistir(mDataset.get(position).getId(), mDataset.get(position).getCena(), mDataset.get(position).getPersonagem());
                if (holder.frase.getCurrentTextColor() == Color.BLUE) {
                    if (position % 2 == 0) {
                        holder.frase.setTextColor(Color.RED);
                    } else {
                        holder.frase.setTextColor(Color.BLACK);
                    }
                } else {
                    holder.frase.setTextColor(Color.BLUE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
