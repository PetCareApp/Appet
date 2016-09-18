package cap7.com.br.petcare.cap7.petfy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import cap7.com.br.petcare.R;
import cap7.com.br.petcare.controller.AnimalController;
import cap7.com.br.petcare.model.Animal;

public class AnimalCadastroActivity extends AppCompatActivity {

    private EditText nome;
    private EditText nascimento;
    private RadioGroup sexo;
    private RadioGroup especie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_cadastro);

        nome = (EditText) findViewById(R.id.edit_animal_nome);
        nascimento = (EditText) findViewById(R.id.edit_animal_nasc);
        sexo = (RadioGroup) findViewById(R.id.rd_animal_sexo);
        especie = (RadioGroup) findViewById(R.id.rd_animal_especie);

        Button btnSalvar = (Button) findViewById(R.id.btn_animal_salvar);

    }

    public void onSalvar(View view) {
        AnimalController animalController = new AnimalController(getBaseContext());
        int sexoSelectedId = sexo.getCheckedRadioButtonId();
        int especieSelectedId = especie.getCheckedRadioButtonId();
        Button sexoButton = (Button) findViewById(sexoSelectedId);
        Button especieButton = (Button) findViewById(especieSelectedId);

        Animal animal = new Animal();
        animal.setNome(nome.getText().toString());
        animal.setNascimento(nascimento.getText().toString());
        animal.setSexo(sexoButton.getText().toString());
        animal.setEspecie(especieButton.getText().toString());

        boolean resultado = animalController.cadastrar(animal);

        Intent intent = new Intent(view.getContext(), AnimalListagemActivity.class);
        startActivity(intent);
    }

}
