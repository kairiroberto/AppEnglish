package myapplocation.jose.myappenglish;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by JOSE on 24-5-18.
 */

class TabFragment1Adapter extends RecyclerView.Adapter<TabFragment1Adapter.Tab1ViewHolder> {

    private List<String> mDataset;
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
            cv = (CardView)v.findViewById(R.id.cvTab1);
            frase = (TextView)v.findViewById(R.id.tvTab1);
        }

        public void alterarCor(int position) {
            frase.setBackgroundColor(Color.GREEN);
        }

    }

    public TabFragment1Adapter(List<String> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public Tab1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.layout_tab1_card, parent, false);
        Tab1ViewHolder vh = new Tab1ViewHolder(view, this.context);
        return vh;
    }

    @Override
    public void onBindViewHolder(final Tab1ViewHolder holder, final int position) {
        //holder.imageView.findViewById(R.id.imageView);
        holder.frase.setText(mDataset.get(position));
        if (position % 2 == 0) {
            holder.frase.setTextColor(Color.RED);
        } else {
            holder.frase.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
