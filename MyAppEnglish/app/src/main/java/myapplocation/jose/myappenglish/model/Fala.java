package myapplocation.jose.myappenglish.model;

import java.io.Serializable;

/**
 * Created by JOSE on 10-6-18.
 */

public class Fala implements Serializable {

    private int id;
    private int cena;
    private String fala;

    public Fala(int id, int cena, String fala) {
        this.id = id;
        this.cena = cena;
        this.fala = fala;
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
}
