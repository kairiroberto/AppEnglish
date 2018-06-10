package myapplocation.jose.myappenglish.model;

import java.io.Serializable;

/**
 * Created by JOSE on 10-6-18.
 */

public class CenaUsuario implements Serializable {

    private int id;
    private int filmeUsuario;
    private String localGravacao;

    public CenaUsuario(int id, int filmeUsuario, String localGravacao) {
        this.id = id;
        this.filmeUsuario = filmeUsuario;
        this.localGravacao = localGravacao;
    }

    public CenaUsuario(int filmeUsuario, String localGravacao) {
        this.filmeUsuario = filmeUsuario;
        this.localGravacao = localGravacao;
    }

    public CenaUsuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmeUsuario() {
        return filmeUsuario;
    }

    public void setFilmeUsuario(int filmeUsuario) {
        this.filmeUsuario = filmeUsuario;
    }

    public String getLocalGravacao() {
        return localGravacao;
    }

    public void setLocalGravacao(String localGravacao) {
        this.localGravacao = localGravacao;
    }

}
