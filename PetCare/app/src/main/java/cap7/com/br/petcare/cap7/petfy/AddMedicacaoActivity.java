package cap7.com.br.petcare.cap7.petfy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cap7.com.br.petcare.R;
import cap7.com.br.petcare.controller.MedicacaoController;
import cap7.com.br.petcare.model.Medicacao;

public class AddMedicacaoActivity extends AppCompatActivity {

    private EditText nome;
    private EditText data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nome = (EditText) findViewById(R.id.edit_med_nome);
        data = (EditText) findViewById(R.id.edit_med_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void onSalvar(View view) {
        MedicacaoController medicacaoController = new MedicacaoController(getBaseContext());
        Medicacao medicacao = new Medicacao();
        medicacao.setNome(nome.getText().toString());
        medicacao.setData(data.getText().toString());

        Bundle bundle = getIntent().getExtras();
        bundle.putInt("aba", 2);
        boolean resultado = medicacaoController.cadastrar(medicacao, bundle.getInt("animal_id"));
        Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(resultado), Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(view.getContext(), AnimalDetalheActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent it = new Intent(AddMedicacaoActivity.this, AnimalListagemActivity.class);
                startActivity(it);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
