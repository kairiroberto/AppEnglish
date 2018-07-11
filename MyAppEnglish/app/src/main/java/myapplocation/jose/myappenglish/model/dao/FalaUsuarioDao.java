package myapplocation.jose.myappenglish.model.dao;

import java.util.ArrayList;
import java.util.List;

import myapplocation.jose.myappenglish.model.FalaUsuario;

/**
 * Created by JOSE on 8-7-18.
 */

public class FalaUsuarioDao {

    private static List<FalaUsuario> myDatasetFala = new ArrayList<FalaUsuario>();

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

}
