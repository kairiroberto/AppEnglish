package myapplocation.jose.myappenglish.model;

import java.io.Serializable;

/**
 * Created by JOSE on 10-6-18.
 */

public class FalaUsuario implements Serializable {

    private int id;
    private int filmeUsuario;
    private String localGravacao;

    public FalaUsuario(int id, int filmeUsuario, String localGravacao) {
        this.id = id;
        this.filmeUsuario = filmeUsuario;
        this.localGravacao = localGravacao;
    }

    public FalaUsuario(int filmeUsuario, String localGravacao) {
        this.filmeUsuario = filmeUsuario;
        this.localGravacao = localGravacao;
    }

    public FalaUsuario() {
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
