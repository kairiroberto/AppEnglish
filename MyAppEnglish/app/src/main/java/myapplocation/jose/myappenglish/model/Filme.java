package myapplocation.jose.myappenglish.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOSE on 24-5-18.
 */

public class Filme implements Serializable {

    private int id;
    private String nomeFilme;
    private String cenasFilme;
    private String duracaoFilme;
    private int imagem;

    public Filme (int id, String nomeFilme, String cenasFilme, String duracaoFilme, int imagem) {
        this.id = id;
        this.nomeFilme = nomeFilme;
        this.cenasFilme = cenasFilme;
        this.duracaoFilme = duracaoFilme;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getCenasFilme() {
        return cenasFilme;
    }

    public void setCenasFilme(String cenasFilme) {
        this.cenasFilme = cenasFilme;
    }

    public String getDuracaoFilme() {
        return duracaoFilme;
    }

    public void setDuracaoFilme(String duracaoFilme) {
        this.duracaoFilme = duracaoFilme;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
