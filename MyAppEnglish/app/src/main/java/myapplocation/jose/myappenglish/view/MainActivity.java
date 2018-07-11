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
import myapplocation.jose.myappenglish.model.dao.CenaDao;
import myapplocation.jose.myappenglish.model.dao.FalaDao;
import myapplocation.jose.myappenglish.model.dao.FilmeDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FilmeDao.listarFilmes();

        CenaDao.listarCenas();

        FalaDao.listarFalas();
        
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

}
