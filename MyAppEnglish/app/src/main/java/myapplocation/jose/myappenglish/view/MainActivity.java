package myapplocation.jose.myappenglish.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.view.FilmesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = new Intent(this, FilmesActivity.class);
        startActivity(intent);
    }
}
