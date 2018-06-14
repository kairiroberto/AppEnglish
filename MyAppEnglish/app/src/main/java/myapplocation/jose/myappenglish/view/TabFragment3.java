package myapplocation.jose.myappenglish.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.controll.layout.PagerAdapter;
import myapplocation.jose.myappenglish.model.Fala;
import myapplocation.jose.myappenglish.model.FalaUsuario;
import myapplocation.jose.myappenglish.model.FilmeUsuario;

public class TabFragment3 extends Fragment {

    private Button btGravacaoOuvir;
    private Button btGravacaoGravar;
    private Button btGravacaoSalvar;
    private Button btGravacaoCancelar;
    private VideoView vvGravacao;
    private RadioButton rb1Personagem;
    private RadioButton rb2Personagem;
    private RadioGroup rgPersonagens;
    private Context context;
    private int personagemSelecionado = 1;
    private int personagem = 1;
    private int usuario = 0;
    private int falaQuantidade = 0;
    private int cena = 0;
    private FilmeUsuario filmeUsuario = null;
    private FalaUsuario falaUsuario = null;
    private List<FalaUsuario> falaUsuarios = new ArrayList<FalaUsuario>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_tab3, container, false);

        context = view.getContext();

        this.cena = PagerAdapter.getCena();

        this.falaQuantidade = MainActivity.listarFalasIdCena(this.cena).size();

        vvGravacao = (VideoView) view.findViewById(R.id.vvGravacao);

        rb1Personagem = (RadioButton) view.findViewById(R.id.rb1Personagem);
        rb2Personagem = (RadioButton) view.findViewById(R.id.rb2Personagem);

        btGravacaoOuvir = (Button) view.findViewById(R.id.btGravacaoOuvir);
        btGravacaoOuvir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb1Personagem.setEnabled(false);
                rb2Personagem.setEnabled(false);
                onOuvirVideo();
            }
        });

        btGravacaoGravar = (Button) view.findViewById(R.id.btGravacaoGravar);
        btGravacaoGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb1Personagem.setEnabled(false);
                rb2Personagem.setEnabled(false);
                onGravarVideo();
            }
        });

        btGravacaoSalvar = (Button) view.findViewById(R.id.btGravacaoSalvar);
        btGravacaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb1Personagem.setEnabled(true);
                rb2Personagem.setEnabled(true);
                personagemSelecionado = 1;
                personagem = 1;
                usuario = 0;
                rb1Personagem.setFocusable(true);
                rb1Personagem.requestFocus();
                onSalvarFilme();
                onSalvarFala();
                atualizarTextoBotoes();
                vvGravacao.stopPlayback();
            }
        });

        btGravacaoCancelar = (Button) view.findViewById(R.id.btGravacaoCancelar);
        btGravacaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb1Personagem.setEnabled(true);
                rb2Personagem.setEnabled(true);
                personagemSelecionado = 1;
                personagem = 1;
                usuario = 0;
                rb1Personagem.setFocusable(true);
                rb1Personagem.requestFocus();
                atualizarTextoBotoes();
                vvGravacao.stopPlayback();
            }
        });

        rgPersonagens = (RadioGroup) view.findViewById(R.id.rgPersonagens);
        rgPersonagens.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                boolean personagem1 = R.id.rb1Personagem == checkedId;
                boolean personagem2 = R.id.rb2Personagem == checkedId;
                if (personagem1) {
                    personagemSelecionado = 1;
                    personagem = 1;
                    usuario = 0;
                } if (personagem2) {
                    personagemSelecionado = 2;
                    personagem = 0;
                    usuario = 1;
                }
                atualizarTextoBotoes();
            }
        });

        return view;

    }

    private void onOuvirVideo() {
        try {
            if (personagem < falaQuantidade && usuario < falaQuantidade) {
                TabFragment1.onStopVideoAssistir();
                TabFragment2.onStopVideoPraticar();
                TabFragment4.onStopMeuVideoAssistir();
                String video = MainActivity.listarFalasIdCena(this.cena).get(personagem).getVideo();
                vvGravacao.setVideoURI(Uri.parse(video));
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
            if (personagem < falaQuantidade && usuario < falaQuantidade) {
                String local = "/storage/extSdCard/w1-";
                String falaUsuarioQuantidade = String.valueOf(MainActivity.listarFalasUsuario().size());
                String extensao = ".mp4";
                String arquivo = local + falaUsuarioQuantidade + String.valueOf(usuario) + extensao;
                File file = new File(arquivo);
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent, 0);
                if (filmeUsuario == null) {
                    int idfilme = MainActivity.listarFilmesUsuario().size()+1;
                    int filmeid = MainActivity.listarCenasIdCena(this.cena).get(0).getFilme();
                    int cenaid = MainActivity.listarCenasIdCena(this.cena).get(0).getId();
                    filmeUsuario = new FilmeUsuario(idfilme, filmeid, cenaid, personagemSelecionado, new Date());
                }
                int idfala = MainActivity.listarFalasUsuario().size();
                int filmeidUsuario = filmeUsuario.getId();
                falaUsuario = new FalaUsuario(idfala, filmeidUsuario, arquivo);
                falaUsuarios.add(falaUsuario);
                usuario+=2;
                personagem+=2;
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

    private void onSalvarFala() {
        for (FalaUsuario fu : falaUsuarios) {
            MainActivity.addFalasUsuario(fu);
        }
        falaUsuarios.clear();
    }

    private void onSalvarFilme() {
        MainActivity.addFilmesUsuario(filmeUsuario);
        filmeUsuario = null;
    }

    private void atualizarTextoBotoes() {
        btGravacaoGravar.setText("Gravar (Fala: " + (usuario + 1) + ")");
        btGravacaoOuvir.setText("Ouvir Personagem (Fala: " + (personagem + 1) + ")");
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
