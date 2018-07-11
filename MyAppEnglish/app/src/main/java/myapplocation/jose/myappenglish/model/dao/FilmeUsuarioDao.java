package myapplocation.jose.myappenglish.model.dao;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.model.FilmeUsuario;

/**
 * Created by JOSE on 8-7-18.
 */

public class FilmeUsuarioDao {

    private static List<FilmeUsuario> myDatasetFilme = new ArrayList<FilmeUsuario>();

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

}
