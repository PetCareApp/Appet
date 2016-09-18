package cap7.com.br.petcare.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cap7.com.br.petcare.Util.AnimalConstants;
import cap7.com.br.petcare.dao.DatabaseHelper;
import cap7.com.br.petcare.model.Animal;

/**
 * Created by antonio on 16/09/2016.
 */
public class AnimalController {

    private SQLiteDatabase db;
    private DatabaseHelper banco;

    public AnimalController(Context context) {
        banco = DatabaseHelper.getHelper(context);
    }

    public boolean cadastrar(Animal animal) {
        db = banco.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AnimalConstants.ANIMAL_NOME, animal.getNome());
        values.put(AnimalConstants.ANIMAL_NASCIMENTO, animal.getNascimento());
        values.put(AnimalConstants.ANIMAL_SEXO, animal.getSexo());
        values.put(AnimalConstants.ANIMAL_ESPECIE, animal.getEspecie());

        long resultado = db.insert(AnimalConstants.ANIMAL_TABELA, null, values);
        db.close();

        return resultado != -1;

    }

    public List<Animal> getAll() {
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(AnimalConstants.ANIMAL_SELECT_ALL, null);
        List<Animal> animais = new ArrayList<Animal>();

        if(cursor.moveToFirst()) {
            do {
                Animal animal = new Animal();
                animal.setId(cursor.getInt(cursor.getColumnIndex(AnimalConstants.ANIMAL_ID)));
                animal.setNome(cursor.getString(cursor.getColumnIndex(AnimalConstants.ANIMAL_NOME)));
                animal.setNascimento(cursor.getString(cursor.getColumnIndex(AnimalConstants.ANIMAL_NASCIMENTO)));
                animal.setSexo(cursor.getString(cursor.getColumnIndex(AnimalConstants.ANIMAL_SEXO)));
                animal.setEspecie(cursor.getString(cursor.getColumnIndex(AnimalConstants.ANIMAL_ESPECIE)));
                animais.add(animal);

            } while (cursor.moveToNext());
        }

        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return animais;
    }

    public Animal getById(int id) {
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + AnimalConstants.ANIMAL_TABELA + " WHERE "
                + AnimalConstants.ANIMAL_ID + " = " + id, null);
        Animal animal = new Animal();

        if(cursor.moveToFirst()) {
            do {
                animal.setId(cursor.getInt(cursor.getColumnIndex(AnimalConstants.ANIMAL_ID)));
                animal.setNome(cursor.getString(cursor.getColumnIndex(AnimalConstants.ANIMAL_NOME)));
                animal.setNascimento(cursor.getString(cursor.getColumnIndex(AnimalConstants.ANIMAL_NASCIMENTO)));
                animal.setSexo(cursor.getString(cursor.getColumnIndex(AnimalConstants.ANIMAL_SEXO)));
                animal.setEspecie(cursor.getString(cursor.getColumnIndex(AnimalConstants.ANIMAL_ESPECIE)));

            } while (cursor.moveToNext());
        }

        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return animal;
    }
}

