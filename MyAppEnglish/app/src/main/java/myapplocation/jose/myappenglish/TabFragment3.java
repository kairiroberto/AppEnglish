package myapplocation.jose.myappenglish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

public class TabFragment3 extends Fragment {

    private Button btGravacaoComecar, btGravacaoSalvar;
    private VideoView vvGravacao;
    private Context context;
    private int i = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab3, container, false);
        context = view.getContext();
        vvGravacao = (VideoView) view.findViewById(R.id.vvGravacao);
        btGravacaoComecar = (Button) view.findViewById(R.id.btGravacaoComecar);
        vvGravacao.setVideoURI(Uri.parse("sdcard/Download/f1-" + String.valueOf(1) + ".mp4"));
        vvGravacao.start();
        btGravacaoComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarVideo();
            }
        });
        btGravacaoSalvar = (Button) view.findViewById(R.id.btGravacaoSalvar);
        return view;
    }

    private void onPlayVideo() {
        if (i <= 10) {
            vvGravacao.setVideoURI(Uri.parse("sdcard/Download/f1-" + String.valueOf(i) + ".mp4"));
            vvGravacao.start();
        }
    }

    private void gravarVideo() {
        try {
            i++;
            File file = new File("/storage/extSdCard/w1" + String.valueOf(i) + ".mp4");
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
            startActivityForResult(intent, 0);
            i++;
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 0) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                onPlayVideo();
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }
    }

}
