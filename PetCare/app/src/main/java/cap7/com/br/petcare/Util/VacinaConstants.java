package cap7.com.br.petcare.Util;

/**
 * Created by antonio on 16/09/2016.
 */
public class VacinaConstants {
    // Colunas da tabela vacina
    public static final String VACINA_TABELA = "vacina";
    public static final String VACINA_ID = "_id";
    public static final String VACINA_NOME = "nome";
    public static final String VACINA_DATA = "data";
    public static final String VACINA_VACINADO = "vacinado";
    public static final String VACINA_ANIMAL_ID = "animal_id";

    // Script de criação da tabela vacina
    public static final String VACINA_TABLE_CREATE = "CREATE TABLE " + VACINA_TABELA +
            "(" + VACINA_ID + " integer primary key autoincrement,"
            + VACINA_NOME + " text,"
            + VACINA_DATA + " text,"
            + VACINA_VACINADO + " integer,"
            + VACINA_ANIMAL_ID + " integer,"
            + "FOREIGN KEY(" + VACINA_ANIMAL_ID + ") REFERENCES "
            + AnimalConstants.ANIMAL_TABELA + "(" + AnimalConstants.ANIMAL_ID + ")"
            +")";
}
