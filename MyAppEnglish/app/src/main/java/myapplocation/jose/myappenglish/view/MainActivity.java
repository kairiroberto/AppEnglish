package myapplocation.jose.myappenglish.view;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.R;
import myapplocation.jose.myappenglish.model.dao.CenaDao;
import myapplocation.jose.myappenglish.model.dao.FalaDao;
import myapplocation.jose.myappenglish.model.dao.FilmeDao;

public class MainActivity extends AppCompatActivity {

    /*private StorageReference mStorageRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;*/
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar.setMax(10);

        //doAuthentication();

        SharedPreferences sharedPreferences = getSharedPreferences("recOK", Context.MODE_PRIVATE);
        String result = sharedPreferences.getString("recOK", "NAO");

        if (result.equals("SIM")) {
            FilmeDao.listarFilmes();

            CenaDao.listarCenas();

            FalaDao.listarFalas();
            Intent i = new Intent(this, Main2Activity.class);
            startActivity(i);
        } else {
            DownloadAsync async = new DownloadAsync();
            async.execute();
        }

    }

    /*public void doAuthentication() {


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

    public void doDownload() {
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
    public void onStart() {
        super.onStart();
    }


    public class DownloadAsync extends AsyncTask<Void, Void, Void>{

        @Override
        public Void doInBackground(Void... voids) {
            try {
                /*
                String pasta = "/myAppEnglish/";
                File folder = new File(Environment.getExternalStorageDirectory().getPath() + pasta);
                if (!folder.exists() || folder.getUsableSpace() == 0 || folder.getTotalSpace() == 0) {
                    folder.mkdir();
                }
                */

                downloadLote();

            } catch (Exception e) {

            }
            return null;
        }

        public void downloadLote() {
            List<String> list = new ArrayList<String>();
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-1.mp4?alt=media&token=c1709be0-cc0c-4238-8fcd-5146bd837b67");
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-2.mp4?alt=media&token=181444d6-06fb-41ab-ae9e-b38f858a42b5");
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-3.mp4?alt=media&token=34fc4922-a0dd-4805-b5e1-20a21fdc4ac5");
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-4.mp4?alt=media&token=694fd851-7507-46b8-9f92-f668c49729de");
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-5.mp4?alt=media&token=c58f40c0-cfb6-4cc7-a87c-53ced6f3d046");
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-6.mp4?alt=media&token=f4f016ad-2e85-402e-b32f-4cd06ad4f062");
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-7.mp4?alt=media&token=9a96d2aa-4473-4efa-a428-1b6371f580b6");
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-8.mp4?alt=media&token=3af8eb8e-3696-4b15-8cfd-54dd9c30ae14");
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-9.mp4?alt=media&token=2b7912bb-4569-47fc-841a-1ae400274588");
            list.add("https://firebasestorage.googleapis.com/v0/b/myappenglish.appspot.com/o/f1%2Ff1-10.mp4?alt=media&token=7a551d8b-460d-47f7-920e-1c36ea9babe0");

            int i = 1;

            for (String s : list) {
                Uri uri = Uri.parse(s);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                }
                String arquivo = ("f1-x.mp4").replace("x", String.valueOf(i));
                request.setDestinationInExternalFilesDir(MainActivity.this, Environment.DIRECTORY_DOWNLOADS + "/myAppEnglish/", arquivo);
                DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Long referenceLong = downloadManager.enqueue(request);
                i++;
            }

        }

        @Override
        public void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            Thread thread = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );
            progressBar.setProgress(2);
        }

        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            FilmeDao.listarFilmes();

            CenaDao.listarCenas();

            FalaDao.listarFalas();
            SharedPreferences sharedPreferences = getSharedPreferences("recOK", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("recOK", "SIM");
            editor.apply();
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
