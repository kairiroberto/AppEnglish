package myapplocation.jose.myappenglish;

import java.io.Serializable;

/**
 * Created by JOSE on 27-5-18.
 */

public class Cena implements Serializable {

    String nomeCena;
    String cenaCena;
    String duracaoCena;
    int imagem;

    public Cena (String nomeCena, String cenaCena, String duracaoCena, int imagem) {
        this.nomeCena = nomeCena;
        this.cenaCena = cenaCena;
        this.duracaoCena = duracaoCena;
        this.imagem = imagem;
    }

}
