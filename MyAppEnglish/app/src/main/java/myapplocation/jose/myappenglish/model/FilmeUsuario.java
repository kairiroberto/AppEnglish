package myapplocation.jose.myappenglish.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by JOSE on 10-6-18.
 */

public class FilmeUsuario implements Serializable {

    private int id;
    private int filme;
    private int cena;
    private int personagem;
    private Date data;

    public FilmeUsuario(int filme, int cena, int personagem, Date data) {
        this.filme = filme;
        this.cena = cena;
        this.data = data;
        this.personagem = personagem;
    }

    public FilmeUsuario(int id, int filme, int cena, int personagem, Date data) {
        this.id = id;
        this.filme = filme;
        this.cena = cena;
        this.personagem = personagem;
        this.data = data;
    }

    public FilmeUsuario() {
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

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPersonagem() {
        return personagem;
    }

    public void setPersonagem(int personagem) {
        this.personagem = personagem;
    }

}
