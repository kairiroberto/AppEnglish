package myapplocation.jose.myappenglish.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.controll.layout.PagerAdapter;

public class TabFragment3 extends Fragment {

    private Button btGravacaoOuvir, btGravacaoGravar, btGravacaoSalvar;
    private VideoView vvGravacao;
    private Context context;
    private int i = 1;
    private int cena = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab3, container, false);
        context = view.getContext();
        vvGravacao = (VideoView) view.findViewById(R.id.vvGravacao);

        btGravacaoOuvir = (Button) view.findViewById(R.id.btGravacaoOuvir);
        btGravacaoOuvir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOuvirVideo();
            }
        });

        btGravacaoGravar = (Button) view.findViewById(R.id.btGravacaoGravar);
        btGravacaoGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGravarVideo();
            }
        });

        btGravacaoSalvar = (Button) view.findViewById(R.id.btGravacaoSalvar);

        this.cena = PagerAdapter.getCena();

        return view;
    }

    private void onOuvirVideo() {
        try {
            if (i <= MainActivity.listarFalas().size()) {
                TabFragment1.onStopVideoAssistir();
                TabFragment2.onStopVideoPraticar();
                vvGravacao.setVideoURI(Uri.parse(MainActivity.listarFalasIdCena(this.cena).get(i-1).getVideo() + String.valueOf(i) + ".mp4"));
                vvGravacao.start();
            } else {
                Toast.makeText(context, "O vídeo não tem mais falas. Salve ou cancele!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void onGravarVideo() {
        try {
            if (i <= MainActivity.listarFalasIdCena(this.cena).size()) {
                i++;
                File file = new File("/storage/extSdCard/w1-" + String.valueOf(MainActivity.listarFalas().size()) + "-" + String.valueOf(i) + ".mp4");
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent, 0);
                i++;
            } else {
                Toast.makeText(context, "O vídeo não tem mais falas. Salve ou cancele!", Toast.LENGTH_SHORT).show();
                btGravacaoGravar.setText("Gravar (Não)");
                btGravacaoOuvir.setText("Ouvir Personagem (Não)");
                btGravacaoSalvar.setText("Salvar (Sim)");
            }
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void atualizarTextoBotoes() {
        btGravacaoGravar.setText("Gravar (" + i + ")");
        btGravacaoOuvir.setText("Ouvir Personagem (" + i + ")");
        btGravacaoSalvar.setText("Salvar (" + i + ")");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 0) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                atualizarTextoBotoes();
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }
    }

}
