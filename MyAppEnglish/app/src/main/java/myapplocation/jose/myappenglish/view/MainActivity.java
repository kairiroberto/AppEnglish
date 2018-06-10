package myapplocation.jose.myappenglish.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.Cena;
import myapplocation.jose.myappenglish.model.Fala;
import myapplocation.jose.myappenglish.model.Filme;
import myapplocation.jose.myappenglish.view.FilmesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        criarFilmes();

        criarCenas();

        criarFalas();

        Intent intent = new Intent(this, FilmesActivity.class);
        startActivity(intent);
    }

    public static List<Filme> criarFilmes() {
        List<Filme> myDataset = new ArrayList<Filme>();
        myDataset.add(new Filme(1, "Filme 1", "10", "10:00", R.drawable.vaivsluk));
        myDataset.add(new Filme(2, "Filme 2", "20", "20:00", 0));
        myDataset.add(new Filme(3, "Filme 3", "30", "30:00", 0));
        myDataset.add(new Filme(4, "Filme 4", "40", "40:00", 0));
        myDataset.add(new Filme(5, "Filme 5", "50", "50:00", 0));
        return myDataset;
    }

    public static List<Cena> criarCenas() {
        List<Cena> myDataset = new ArrayList<Cena>();
        myDataset.add(new Cena(1, 1, "Filme 1", "1", "10:00", R.drawable.vaivsluk));
        myDataset.add(new Cena(1, 2, "Filme 1", "2", "20:00", 0));
        myDataset.add(new Cena(1, 3, "Filme 1", "3", "30:00", 0));
        myDataset.add(new Cena(1, 4, "Filme 1", "4", "40:00", 0));
        myDataset.add(new Cena(1, 5, "Filme 1", "5", "50:00", 0));
        return myDataset;
    }

    public static List<Fala> criarFalas() {
        List<Fala> myDataset = new ArrayList<Fala>();
        myDataset.add(new Fala(1, 1, "Fala 1: Vaider: No I am your father. \n(Vaider: Não Eu sou o seu pai.)"));
        myDataset.add(new Fala(1, 2, "Fala 2: Luke: No. No. No. That's not true. It's impossible. \n(Luke: Não. Não. Não é verdade. É impossível.)"));
        myDataset.add(new Fala(1, 3, "Fala 3: Vaider: Listen your heart. You know it's true. \n(Vaider: Ouça o seu coração. Sabe que é verdade.)"));
        myDataset.add(new Fala(1, 4, "Fala 4: Luke: No. No. \n(Luke: Não. Não.)"));
        myDataset.add(new Fala(1, 5, "Fala 5: Vaider: Luke, you can destroy the Emperor. He already foresaw this. \n(Vaider: Luke, você pode destruir o Imperador. Ele já previu isso.)"));
        myDataset.add(new Fala(1, 6, "Fala 6: Vaider: It is your destiny. Join me. \n(Vaider: É o seu destino. Junte-se a mim.)"));
        myDataset.add(new Fala(1, 7, "Fala 7: Vaider: Together we can rule the galaxy as father and son. \n(Vaider: Juntos poderemos governar a galáxia como pai e filho.)"));
        myDataset.add(new Fala(1, 8, "Fala 8: ... \n(...)"));
        myDataset.add(new Fala(1, 9, "Fala 9: Vaider: Come with me. \n(Vaider: Venha comigo.)"));
        myDataset.add(new Fala(1, 10, "Fala 10: Vaider: It's your only way out. \n(Vaider: É sua única saída.)"));
        return myDataset;
    }

}
