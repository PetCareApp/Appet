package cap7.com.br.petcare.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cap7.com.br.petcare.Util.MedicacaoConstants;
import cap7.com.br.petcare.dao.DatabaseHelper;
import cap7.com.br.petcare.model.Medicacao;

/**
 * Created by antonio on 16/09/2016.
 */
public class MedicacaoController {

    private SQLiteDatabase db;
    private DatabaseHelper banco;

    public MedicacaoController(Context context) {
        banco = DatabaseHelper.getHelper(context);
    }

    public boolean cadastrar(Medicacao medicacao, int idAnimal) {
        db = banco.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MedicacaoConstants.MED_NOME, medicacao.getNome());
        values.put(MedicacaoConstants.MED_DATA, medicacao.getData());
        values.put(MedicacaoConstants.MED_MEDICADO, 0);
        values.put(MedicacaoConstants.MED_ANIMAL_ID, idAnimal);

        long resultado = db.insert(MedicacaoConstants.MED_TABELA, null, values);
        db.close();

        return resultado != -1;

    }

    public List<Medicacao> getByAnimalId(int id) {
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MedicacaoConstants.MED_TABELA + " WHERE "
                + MedicacaoConstants.MED_ANIMAL_ID + " = " + id, null);

        List<Medicacao> medicacoes = new ArrayList<Medicacao>();
        if(cursor.moveToFirst()) {
            do {
                Medicacao medicacao = new Medicacao();
                medicacao.setId(cursor.getInt(cursor.getColumnIndex(MedicacaoConstants.MED_ID)));
                medicacao.setNome(cursor.getString(cursor.getColumnIndex(MedicacaoConstants.MED_NOME)));
                medicacao.setData(cursor.getString(cursor.getColumnIndex(MedicacaoConstants.MED_DATA)));
                int medicado = cursor.getInt(cursor.getColumnIndex(MedicacaoConstants.MED_MEDICADO));
                medicacao.setMedicado(medicado == 0 ? false : true);
                medicacoes.add(medicacao);

            } while (cursor.moveToNext());
        }

        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return medicacoes;
    }
}

