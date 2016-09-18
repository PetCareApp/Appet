package cap7.com.br.petcare.Util;

/**
 * Created by antonio on 16/09/2016.
 */
public class MedicacaoConstants {
    // Colunas da tabela vacina
    public static final String MED_TABELA = "medicacao";
    public static final String MED_ID = "_id";
    public static final String MED_NOME = "nome";
    public static final String MED_DATA = "data";
    public static final String MED_MEDICADO = "medicado";
    public static final String MED_ANIMAL_ID = "animal_id";

    // Script de criação da tabela vacina
    public static final String MED_TABLE_CREATE = "CREATE TABLE " + MED_TABELA +
            "(" + MED_ID + " integer primary key autoincrement,"
            + MED_NOME + " text,"
            + MED_DATA + " text,"
            + MED_MEDICADO + " integer,"
            + MED_ANIMAL_ID + " integer,"
            + "FOREIGN KEY(" + MED_ANIMAL_ID + ") REFERENCES "
            + AnimalConstants.ANIMAL_TABELA + "(" + AnimalConstants.ANIMAL_ID + ")"
            +")";
}
