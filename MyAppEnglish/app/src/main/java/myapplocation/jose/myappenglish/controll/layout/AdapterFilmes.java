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

import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.Filme;
import myapplocation.jose.myappenglish.view.CenasActivity;

/**
 * Created by JOSE on 24-5-18.
 */

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.FilmesViewHolder> {

    private List<Filme> mDataset;
    private Context context;

    public static class FilmesViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cv;
        ImageView imageView;
        TextView nomeFilme;
        TextView cenasFilme;
        TextView duracaoFilme;
        ImageView imageFilme;
        Button botao;
        Context context;

        public FilmesViewHolder(View v, Context context) {
            super(v);
            this.context = context;
            cv = (CardView)v.findViewById(R.id.cvFilmes);
            imageFilme = (ImageView) v.findViewById(R.id.imageFilme);
            nomeFilme = (TextView)v.findViewById(R.id.tvFilme_Nome);
            cenasFilme = (TextView)v.findViewById(R.id.tvFilme_Cenas);
            duracaoFilme = (TextView)v.findViewById(R.id.tvFilme_Duracao);
            botao = (Button) v.findViewById(R.id.btAcessarFilme);
        }

    }

    public AdapterFilmes(List<Filme> myDataset, Context context) {
        this.mDataset = myDataset;
        this.context = context;
    }

    @Override
    public FilmesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.activity_card_filmes, parent, false);
        FilmesViewHolder vh = new FilmesViewHolder(v, this.context);
        return vh;
    }

    @Override
    public void onBindViewHolder(final FilmesViewHolder holder, final int position) {
        //holder.imageView.findViewById(R.id.imageView);
        holder.nomeFilme.setText("Filme: " + mDataset.get(position).getNomeFilme());
        holder.cenasFilme.setText("Cenas: " + mDataset.get(position).getCenasFilme());
        holder.duracaoFilme.setText("Duração: " + mDataset.get(position).getDuracaoFilme());
        if (mDataset.get(position).getImagem() != 0) {
            holder.imageFilme.setImageResource(mDataset.get(position).getImagem());
        } else {
            holder.imageFilme.setImageResource(R.mipmap.ic_launcher);
        }
        holder.botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CenasActivity.class);
                intent.putExtra("filme", mDataset.get(position).getId());
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
