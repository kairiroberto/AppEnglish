package myapplocation.jose.myappenglish.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.Cena;
import myapplocation.jose.myappenglish.model.Fala;
import myapplocation.jose.myappenglish.model.FalaUsuario;
import myapplocation.jose.myappenglish.model.Filme;
import myapplocation.jose.myappenglish.model.FilmeUsuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listarFilmes();

        listarCenas();

        listarFalas();
        
        Intent intent = new Intent(this, FilmesActivity.class);
        startActivity(intent);
    }

    private static List<FilmeUsuario> myDatasetFilme = new ArrayList<FilmeUsuario>();
    private static List<FalaUsuario> myDatasetFala = new ArrayList<FalaUsuario>();

    public static void addFilmesUsuario(FilmeUsuario filmeUsuario) {
        myDatasetFilme.add(filmeUsuario);
    }

    public static List<FilmeUsuario> listarFilmesUsuario() {
        return myDatasetFilme;
    }

    public static List<FilmeUsuario> listarFilmesUsuarioIdFilme(int id) {
        List<FilmeUsuario> myDataset = new ArrayList<FilmeUsuario>();
        for (FilmeUsuario fu : listarFilmesUsuario()) {
            myDataset.add(fu);
        }
        return myDataset;
    }

    public static void addFalasUsuario(FalaUsuario falaUsuario) {
        myDatasetFala.add(falaUsuario);
    }

    public static List<FalaUsuario> listarFalasUsuario() {
        return myDatasetFala;
    }

    public static List<FalaUsuario> listarFalasUsuarioIdFilme(int id) {
        List<FalaUsuario> myDataset = new ArrayList<FalaUsuario>();
        for (FalaUsuario fu : listarFalasUsuario()) {
            if (fu.getFilmeUsuario() == id) {
                myDataset.add(fu);
            }
        }
        return myDataset;
    }










    public static List<Filme> listarFilmes() {
        List<Filme> myDataset = new ArrayList<Filme>();

        myDataset.add(new Filme(1, "Filme 1", "10", "10:00", R.drawable.vaivsluk));
        myDataset.add(new Filme(2, "Filme 2", "20", "20:00", 0));
        myDataset.add(new Filme(3, "Filme 3", "30", "30:00", 0));
        myDataset.add(new Filme(4, "Filme 4", "40", "40:00", 0));
        myDataset.add(new Filme(5, "Filme 5", "50", "50:00", 0));

        return myDataset;
    }

    public static List<Cena> listarCenas() {
        List<Cena> myDataset = new ArrayList<Cena>();

        myDataset.add(new Cena(1, 1, "Filme 1", "1", "10:00", R.drawable.vaivsluk));
        myDataset.add(new Cena(2, 1, "Filme 1", "2", "20:00", 0));
        myDataset.add(new Cena(3, 1, "Filme 1", "3", "30:00", 0));

        myDataset.add(new Cena(4, 2, "Filme 1", "4", "40:00", 0));
        myDataset.add(new Cena(5, 2, "Filme 1", "5", "50:00", 0));

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
