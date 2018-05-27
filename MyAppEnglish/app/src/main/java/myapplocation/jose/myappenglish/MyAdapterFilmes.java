package myapplocation.jose.myappenglish;

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

/**
 * Created by JOSE on 24-5-18.
 */

class MyAdapterFilmes extends RecyclerView.Adapter<MyAdapterFilmes.FilmesViewHolder> {

    private List<Filme> mDataset;
    private Context context;

    public static class FilmesViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cv;
        ImageView imageView;
        TextView nomeFilme;
        TextView cenasFilme;
        TextView duracaoFilme;
        Button botao;
        Context context;

        public FilmesViewHolder(View v) {
            super(v);
            this.context = context;
            cv = (CardView)v.findViewById(R.id.cvFilmes);
            nomeFilme = (TextView)v.findViewById(R.id.tvFilme_Nome);
            cenasFilme = (TextView)v.findViewById(R.id.tvFilme_Cenas);
            duracaoFilme = (TextView)v.findViewById(R.id.tvFilme_Duracao);
            botao = (Button) v.findViewById(R.id.btAcessarFilme);
        }

    }

    public MyAdapterFilmes(List<Filme> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public FilmesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_filmes, parent, false);
        FilmesViewHolder vh = new FilmesViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final FilmesViewHolder holder, int position) {
        //holder.imageView.findViewById(R.id.imageView);
        holder.nomeFilme.setText("Filme: " + mDataset.get(position).nomeFilme);
        holder.cenasFilme.setText("Cenas: " + mDataset.get(position).cenasFilme);
        holder.duracaoFilme.setText("Duração: " + mDataset.get(position).duracaoFilme);
        holder.botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CenasActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
