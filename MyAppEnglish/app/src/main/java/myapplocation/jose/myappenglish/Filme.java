package myapplocation.jose.myappenglish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOSE on 24-5-18.
 */

public class Filme implements Serializable {

    String nomeFilme;
    String cenasFilme;
    String duracaoFilme;

    public Filme (String nomeFilme, String cenasFilme, String duracaoFilme) {
        this.nomeFilme = nomeFilme;
        this.cenasFilme = cenasFilme;
        this.duracaoFilme = duracaoFilme;
    }

}
