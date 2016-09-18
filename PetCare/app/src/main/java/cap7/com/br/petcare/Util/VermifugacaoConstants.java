package cap7.com.br.petcare.Util;

/**
 * Created by antonio on 16/09/2016.
 */
public class VermifugacaoConstants {
    // Colunas da tabela vacina
    public static final String VERM_TABELA = "vermifugacao";
    public static final String VERM_ID = "_id";
    public static final String VERM_NOME = "nome";
    public static final String VERM_DATA = "data";
    public static final String VERM_VERMIFUGADO = "vermifugado";
    public static final String VERM_ANIMAL_ID = "animal_id";

    // Script de criação da tabela vacina
    public static final String VERM_TABLE_CREATE = "CREATE TABLE " + VERM_TABELA +
            "(" + VERM_ID + " integer primary key autoincrement,"
            + VERM_NOME + " text,"
            + VERM_DATA + " text,"
            + VERM_VERMIFUGADO + " integer,"
            + VERM_ANIMAL_ID + " integer,"
            + "FOREIGN KEY(" + VERM_ANIMAL_ID + ") REFERENCES "
            + AnimalConstants.ANIMAL_TABELA + "(" + AnimalConstants.ANIMAL_ID + ")"
            +")";
}
