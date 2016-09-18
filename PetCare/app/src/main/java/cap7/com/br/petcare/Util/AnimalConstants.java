package cap7.com.br.petcare.Util;

/**
 * Created by antonio on 16/09/2016.
 */
public class AnimalConstants {
    // Colunas da tabela animal
    public static final String ANIMAL_TABELA = "animal";
    public static final String ANIMAL_ID = "_id";
    public static final String ANIMAL_NOME = "nome";
    public static final String ANIMAL_NASCIMENTO = "nascimento";
    public static final String ANIMAL_SEXO = "sexo";
    public static final String ANIMAL_ESPECIE = "especie";

    // Script de criação da tabela animal
    public static final String ANIMAL_TABLE_CREATE = "CREATE TABLE " + ANIMAL_TABELA +
            "(" + ANIMAL_ID + " integer primary key autoincrement,"
            + ANIMAL_NOME + " text,"
            + ANIMAL_NASCIMENTO + " text,"
            + ANIMAL_SEXO + " text,"
            + ANIMAL_ESPECIE + " text"
            +")";

    public static final String ANIMAL_SELECT_ALL = "SELECT * FROM " + ANIMAL_TABELA;

}
