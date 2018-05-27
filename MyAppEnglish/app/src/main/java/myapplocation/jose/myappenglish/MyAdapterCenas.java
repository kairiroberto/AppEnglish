package myapplocation.jose.myappenglish;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
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

class MyAdapterCenas extends RecyclerView.Adapter<MyAdapterCenas.CenasViewHolder> {

    private List<Cena> mDataset;
    private Context context;

    public static class CenasViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cv;
        ImageView imageView;
        TextView nomeCena;
        TextView cenaCena;
        TextView duracaoCena;
        Button botao;

        public CenasViewHolder(View v) {
            super(v);
            cv = (CardView)v.findViewById(R.id.cvCenas);
            nomeCena = (TextView)v.findViewById(R.id.tvCena_Nome);
            cenaCena = (TextView)v.findViewById(R.id.tvCena_Cenas);
            duracaoCena = (TextView)v.findViewById(R.id.tvCena_Duracao);
            botao = (Button) v.findViewById(R.id.btAcessarCena);
        }

    }

    public MyAdapterCenas(List<Cena> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public CenasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_filmes, parent, false);
        CenasViewHolder vh = new CenasViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CenasViewHolder holder, int position) {
        //holder.imageView.findViewById(R.id.imageView);
        holder.nomeCena.setText("Fime: " + mDataset.get(position).nomeCena);
        holder.cenaCena.setText("Cena: " + mDataset.get(position).cenaCena);
        holder.duracaoCena.setText("Duração: " + mDataset.get(position).duracaoCena);
        holder.botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TabActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
