package myapplocation.jose.myappenglish.model.dao;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.Cena;
import myapplocation.jose.myappenglish.model.Fala;
import myapplocation.jose.myappenglish.model.Filme;

/**
 * Created by JOSE on 8-7-18.
 */

public class FilmeDao {

    public static List<Filme> listarFilmes() {
        List<Filme> myDataset = new ArrayList<Filme>();

        myDataset.add(new Filme(1, "Filme 1", "10", "10:00", R.drawable.vaivsluk));
        //myDataset.add(new Filme(2, "Filme 2", "20", "20:00", 0));
        //myDataset.add(new Filme(3, "Filme 3", "30", "30:00", 0));
        //myDataset.add(new Filme(4, "Filme 4", "40", "40:00", 0));
        //myDataset.add(new Filme(5, "Filme 5", "50", "50:00", 0));

        return myDataset;
    }

}
