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

        myDataset.add(new Filme(1, "Star War: \nThe Empire Strikes Back", "1", "10:00", R.drawable.vaivsluk));
        myDataset.add(new Filme(2, "Spider-Man: \nHomecoming", "1", "20:00", R.drawable.ha));
        myDataset.add(new Filme(3, "Blade Runner", "1", "30:00", R.drawable.br));
        myDataset.add(new Filme(4, "Mulher \nMaravilha", "1", "40:00", R.drawable.mm));
        myDataset.add(new Filme(5, "Seven Pounds", "3", "50:00", R.drawable.sp));

        return myDataset;
    }

}
