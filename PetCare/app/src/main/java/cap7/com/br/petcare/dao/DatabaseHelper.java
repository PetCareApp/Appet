package cap7.com.br.petcare.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cap7.com.br.petcare.Util.AnimalConstants;
import cap7.com.br.petcare.Util.MedicacaoConstants;
import cap7.com.br.petcare.Util.ScriptDB;
import cap7.com.br.petcare.Util.VacinaConstants;
import cap7.com.br.petcare.Util.VermifugacaoConstants;

/**
 * Created by Virginia on 02/03/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Current version of database
    public static final int DATABASE_VERSION = 6;

    private static DatabaseHelper instance;


    public static synchronized DatabaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context);
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, ScriptDB.DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(ScriptDB.CREATE_TABLE_ANIMAL);
        db.execSQL(ScriptDB.CREATE_TABLE_PROPRIETARIO);
        db.execSQL(AnimalConstants.ANIMAL_TABLE_CREATE);
        db.execSQL(VacinaConstants.VACINA_TABLE_CREATE);
        db.execSQL(MedicacaoConstants.MED_TABLE_CREATE);
        db.execSQL(VermifugacaoConstants.VERM_TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ScriptDB.TAB_PROPRIETARIO_NOVO);
        db.execSQL("DROP TABLE IF EXISTS " + ScriptDB.TAB_ANIMAL);
        onCreate(db);
    }
}
