package myapplocation.jose.myappenglish.model.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JOSE on 6-8-18.
 */

public class ConexaoBD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myappenglish";
    public static final String TABLE_NAME_FALA_USUARIO = "fala_usuario";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME_FILME_USUARIO = "filme_usuario";
    public static final String COLUMN_LOCAL_GRAVACAO = "local_gravacao";

    private static final String SQL_CREATE_FALA_USUARIO =
            "CREATE TABLE " + TABLE_NAME_FALA_USUARIO + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_FILME_USUARIO + " INTEGER," +
                    COLUMN_LOCAL_GRAVACAO + " TEXT)";

    private static final String SQL_DELETE_FALA_USUARIO =
            "DROP TABLE IF EXISTS " + TABLE_NAME_FALA_USUARIO;

    public ConexaoBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public ConexaoBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_DELETE_FALA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
