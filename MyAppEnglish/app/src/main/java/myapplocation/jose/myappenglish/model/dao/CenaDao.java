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
        //myDataset.add(new Cena(2, 1, "Filme 1", "2", "20:00", 0));
        //myDataset.add(new Cena(3, 1, "Filme 1", "3", "30:00", 0));
        //myDataset.add(new Cena(4, 2, "Filme 1", "4", "40:00", 0));
        //myDataset.add(new Cena(5, 2, "Filme 1", "5", "50:00", 0));

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
