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
import myapplocation.jose.myappenglish.view.TabFragment1;
import myapplocation.jose.myappenglish.view.TabFragment2;

/**
 * Created by JOSE on 24-5-18.
 */

public class AdapterTabFragment2 extends RecyclerView.Adapter<AdapterTabFragment2.Tab1ViewHolder> {

    private List<Fala> mDataset;
    private Context context;
    private final Handler handler = new Handler();
    private int positionCorBlue = 0;

    public static class Tab1ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cv;
        TextView frase;
        Context context;

        public Tab1ViewHolder(View v, Context context) {
            super(v);
            this.context = context;
            cv = (CardView)v.findViewById(R.id.cvTab2);
            frase = (TextView)v.findViewById(R.id.tvTab2);
        }

        public void alterarCor(int position) {
            frase.setBackgroundColor(Color.GREEN);
        }

    }

    public AdapterTabFragment2(List<Fala> myDataset, Context context) {
        this.mDataset = myDataset;
        this.context = context;
    }

    @Override
    public Tab1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.layout_tab2_card, parent, false);
        Tab1ViewHolder vh = new Tab1ViewHolder(view, this.context);
        return vh;
    }

    @Override
    public void onBindViewHolder(final Tab1ViewHolder holder, final int position) {
        //holder.imageView.findViewById(R.id.imageView);
        holder.frase.setText(mDataset.get(position).getFala());
        if (position % 2 == 0) {
            holder.frase.setTextColor(Color.RED);
        } else {
            holder.frase.setTextColor(Color.BLACK);
        }
        holder.frase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabFragment2.onPlayVideoPraticar(position);
                holder.frase.setTextColor(Color.BLUE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
