package myapplocation.jose.myappenglish.model.dao;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.Cena;

/**
 * Created by JOSE on 8-7-18.
 */

public class CenaDao {

    public static List<Cena> listarCenas() {
        List<Cena> myDataset = new ArrayList<Cena>();

        myDataset.add(new Cena(1, 1, "Filme 1", "1", "10:00", R.drawable.vaivsluk));
        myDataset.add(new Cena(2, 2, "Filme 2", "1", "20:00", R.drawable.ha));
        myDataset.add(new Cena(3, 3, "Filme 3", "1", "30:00", R.drawable.br));
        myDataset.add(new Cena(4, 4, "Filme 4", "1", "40:00", R.drawable.mm));
        myDataset.add(new Cena(5, 5, "Filme 5", "1", "50:00", R.drawable.sp));
        myDataset.add(new Cena(6, 5, "Filme 5", "2", "50:00", R.drawable.sp));
        myDataset.add(new Cena(7, 5, "Filme 5", "3", "50:00", R.drawable.sp));

        return myDataset;
    }

    public static List<Cena> listarCenasIdFilme(int id) {
        List<Cena> myDataset = new ArrayList<Cena>();
        for (Cena c : listarCenas()) {
            if (c.getFilme() == id) {
                myDataset.add(c);
            }
        }
        return myDataset;
    }

    public static List<Cena> listarCenasIdCena(int id) {
        List<Cena> myDataset = new ArrayList<Cena>();
        for (Cena c : listarCenas()) {
            if (c.getId() == id) {
                myDataset.add(c);
            }
        }
        return myDataset;
    }

}
