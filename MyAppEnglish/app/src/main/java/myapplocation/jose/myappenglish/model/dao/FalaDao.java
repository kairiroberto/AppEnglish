package myapplocation.jose.myappenglish.model.dao;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.model.Fala;

/**
 * Created by JOSE on 8-7-18.
 */

public class FalaDao {

    public static List<Fala> listarFalas() {

        List<Fala> myDataset = new ArrayList<Fala>();

        String video1 = "storage/emulated/0/myAppEnglish/f1-";
        myDataset.add(new Fala(1, 1, "Fala 1: Vaider: No I am your father. \n(Vaider: Não Eu sou o seu pai.)", video1 + "1.mp4"));
        myDataset.add(new Fala(2, 1, "Fala 2: Luke: No. No. No. That's not true. It's impossible. \n(Luke: Não. Não. Não é verdade. É impossível.)", video1 + "2.mp4"));
        myDataset.add(new Fala(3, 1, "Fala 3: Vaider: Listen your heart. You know it's true. \n(Vaider: Ouça o seu coração. Sabe que é verdade.)", video1 + "3.mp4"));
        myDataset.add(new Fala(4, 1, "Fala 4: Luke: No. No. \n(Luke: Não. Não.)", video1 + "4.mp4"));
        myDataset.add(new Fala(5, 1, "Fala 5: Vaider: Luke, you can destroy the Emperor. He already foresaw this. \n(Vaider: Luke, você pode destruir o Imperador. Ele já previu isso.)", video1 + "5.mp4"));
        myDataset.add(new Fala(6, 1, "Fala 6: Vaider: It is your destiny. Join me. \n(Vaider: É o seu destino. Junte-se a mim.)", video1 + "6.mp4"));
        myDataset.add(new Fala(7, 1, "Fala 7: Vaider: Together we can rule the galaxy as father and son. \n(Vaider: Juntos poderemos governar a galáxia como pai e filho.)", video1 + "7.mp4"));
        myDataset.add(new Fala(8, 1, "Fala 8: ... \n(...)", video1 + "8.mp4"));
        myDataset.add(new Fala(9, 1, "Fala 9: Vaider: Come with me. \n(Vaider: Venha comigo.)", video1 + "9.mp4"));
        myDataset.add(new Fala(10, 1, "Fala 10: Vaider: It's your only way out. \n(Vaider: É sua única saída.)", video1 + "10.mp4"));

        String video2 = "storage/emulated/0/myAppEnglish/f2-";
        myDataset.add(new Fala(11, 2, "Fala 8: ... \n(...)", video2));
        myDataset.add(new Fala(12, 2, "Fala 8: ... \n(...)", video2));

        String video3 = "storage/emulated/0/myAppEnglish/f3-";
        myDataset.add(new Fala(13, 3, "Fala 8: ... \n(...)", ""));

        String video4 = "storage/emulated/0/myAppEnglish/f4-";
        myDataset.add(new Fala(14, 4, "Fala 8: ... \n(...)", ""));

        return myDataset;
    }

    public static List<Fala> listarFalasIdCena(int id) {
        List<Fala> myDataset = new ArrayList<Fala>();
        for (Fala f : listarFalas()) {
            if (f.getCena() == id) {
                myDataset.add(f);
            }
        }
        return myDataset;
    }

}
