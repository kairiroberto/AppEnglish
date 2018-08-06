package myapplocation.jose.myappenglish.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/*import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;*/

import java.io.File;
import java.io.IOException;
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

    /*private StorageReference mStorageRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final File folder = new File(Environment.getExternalStorageDirectory() + "/myAppEnglish");

        if (!folder.exists()) {
            folder.mkdir();
        }

        //doAuthentication();

        FilmeDao.listarFilmes();

        CenaDao.listarCenas();

        FalaDao.listarFalas();

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    /*private void doAuthentication() {


        mAuth = FirebaseAuth.getInstance();

        String email = "kairiroberto@gmail.com";
        String password = "123456";

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("TAG", "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.d("TAG", "signInWithEmail:failed", task.getException());

                        } else {
                            doDownload();
                        }

                        // ...
                    }
                });
    }

    private void doDownload() {
        mStorageRef = FirebaseStorage.getInstance().getReference();

        mStorageRef = mStorageRef.child("video/f1-1.mp4");

        final File folder = new File(Environment.getExternalStorageDirectory() + "/myAppEnglish/f1-1.mp4");
        if (!folder.exists()) {
            folder.mkdir();
        }

        mStorageRef.getFile(folder)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
                Log.d("TAG", "signInWithEmail:failed", exception);
            }
        });
    }*/

    @Override
    protected void onStart() {
        super.onStart();
    }
}
