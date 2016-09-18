package cap7.com.br.petcare.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cap7.com.br.petcare.Util.VermifugacaoConstants;
import cap7.com.br.petcare.dao.DatabaseHelper;
import cap7.com.br.petcare.model.Vermifugacao;

/**
 * Created by antonio on 16/09/2016.
 */
public class VermifugacaoController {

    private SQLiteDatabase db;
    private DatabaseHelper banco;

    public VermifugacaoController(Context context) {
        banco = DatabaseHelper.getHelper(context);
    }

    public boolean cadastrar(Vermifugacao vermifugacao, int idAnimal) {
        db = banco.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VermifugacaoConstants.VERM_NOME, vermifugacao.getNome());
        values.put(VermifugacaoConstants.VERM_DATA, vermifugacao.getData());
        values.put(VermifugacaoConstants.VERM_VERMIFUGADO, 0);
        values.put(VermifugacaoConstants.VERM_ANIMAL_ID, idAnimal);

        long resultado = db.insert(VermifugacaoConstants.VERM_TABELA, null, values);
        db.close();

        return resultado != -1;

    }

    public List<Vermifugacao> getByAnimalId(int id) {
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + VermifugacaoConstants.VERM_TABELA + " WHERE "
                + VermifugacaoConstants.VERM_ANIMAL_ID + " = " + id, null);

        List<Vermifugacao> vermifugacoes = new ArrayList<Vermifugacao>();
        if(cursor.moveToFirst()) {
            do {
                Vermifugacao vermifugacao = new Vermifugacao();
                vermifugacao.setId(cursor.getInt(cursor.getColumnIndex(VermifugacaoConstants.VERM_ID)));
                vermifugacao.setNome(cursor.getString(cursor.getColumnIndex(VermifugacaoConstants.VERM_NOME)));
                vermifugacao.setData(cursor.getString(cursor.getColumnIndex(VermifugacaoConstants.VERM_DATA)));
                int vermifugado = cursor.getInt(cursor.getColumnIndex(VermifugacaoConstants.VERM_VERMIFUGADO));
                vermifugacao.setVermifugado(vermifugado == 0 ? false : true);
                vermifugacoes.add(vermifugacao);

            } while (cursor.moveToNext());
        }

        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return vermifugacoes;
    }
}

