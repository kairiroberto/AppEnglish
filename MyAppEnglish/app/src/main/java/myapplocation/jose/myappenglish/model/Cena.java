package myapplocation.jose.myappenglish.model;

import java.io.Serializable;

/**
 * Created by JOSE on 27-5-18.
 */

public class Cena implements Serializable {

    private int id;
    private int filme;
    private String nomeCena;
    private String cenaCena;
    private String duracaoCena;
    private int imagem;

    public Cena (int id, int filme, String nomeCena, String cenaCena, String duracaoCena, int imagem) {
        this.id = id;
        this.filme = filme;
        this.nomeCena = nomeCena;
        this.cenaCena = cenaCena;
        this.duracaoCena = duracaoCena;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilme() {
        return filme;
    }

    public void setFilme(int filme) {
        this.filme = filme;
    }

    public String getNomeCena() {
        return nomeCena;
    }

    public void setNomeCena(String nomeCena) {
        this.nomeCena = nomeCena;
    }

    public String getCenaCena() {
        return cenaCena;
    }

    public void setCenaCena(String cenaCena) {
        this.cenaCena = cenaCena;
    }

    public String getDuracaoCena() {
        return duracaoCena;
    }

    public void setDuracaoCena(String duracaoCena) {
        this.duracaoCena = duracaoCena;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
