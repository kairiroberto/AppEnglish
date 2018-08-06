package myapplocation.jose.myappenglish.controll.layout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.Cena;
import myapplocation.jose.myappenglish.view.TabActivity;

/**
 * Created by JOSE on 24-5-18.
 */

public class AdapterCenas extends RecyclerView.Adapter<AdapterCenas.CenasViewHolder> {

    private List<Cena> mDataset;
    private Context context;

    public static class CenasViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cv;
        //ImageView imageView;
        TextView nomeCena;
        TextView cenaCena;
        TextView duracaoCena;
        ImageView imageCena;
        Button botao;
        Context context;

        public CenasViewHolder(View v, Context context) {
            super(v);
            try {
                this.context = context;
                cv = (CardView)v.findViewById(R.id.cvCenas);
                imageCena = (ImageView) v.findViewById(R.id.imageCena);
                nomeCena = (TextView)v.findViewById(R.id.tvCena_Nome);
                cenaCena = (TextView)v.findViewById(R.id.tvCena_Cenas);
                duracaoCena = (TextView)v.findViewById(R.id.tvCena_Duracao);
                botao = (Button)v.findViewById(R.id.btAcessarCena);
            } catch (Exception e) {
                Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            }
        }

    }

    public AdapterCenas(List<Cena> myDataset, Context context) {
        try {
            mDataset = myDataset;
            this.context = context;
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public CenasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.activity_card_cenas, parent, false);
        CenasViewHolder vh = new CenasViewHolder(v, this.context);
        return vh;
    }

    @Override
    public void onBindViewHolder(final CenasViewHolder holder, final int position) {
        //holder.imageView.findViewById(R.id.imageView);
        holder.nomeCena.setText("Fime: " + mDataset.get(position).getNomeCena());
        holder.cenaCena.setText("Cena: " + mDataset.get(position).getCenaCena());
        holder.duracaoCena.setText("Duração: " + mDataset.get(position).getDuracaoCena());
        if (mDataset.get(position).getImagem() != 0) {
            holder.imageCena.setImageResource(mDataset.get(position).getImagem());
        } else {
            holder.imageCena.setImageResource(R.mipmap.ic_launcher);
        }
        holder.botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, TabActivity.class);
                intent.putExtra("cena", mDataset.get(position).getId());
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
