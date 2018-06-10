package myapplocation.jose.myappenglish.model;

import java.io.Serializable;

/**
 * Created by JOSE on 10-6-18.
 */

public class Fala implements Serializable {

    private int id;
    private int cena;
    private String fala;
    private String video;

    public Fala(int id, int cena, String fala, String video) {
        this.id = id;
        this.cena = cena;
        this.fala = fala;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getFala() {
        return fala;
    }

    public void setFala(String fala) {
        this.fala = fala;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

}
