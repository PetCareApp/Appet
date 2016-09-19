package cap7.com.br.petcare.cap7.petfy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import cap7.com.br.petcare.R;
import cap7.com.br.petcare.controller.VermifugacaoController;
import cap7.com.br.petcare.model.Vermifugacao;

public class AddVermifugacaoActivity extends AppCompatActivity {

    private EditText nome;
    private EditText data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vermifugacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nome = (EditText) findViewById(R.id.edit_verm_nome);
        data = (EditText) findViewById(R.id.edit_verm_data);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void onSalvar(View view) {
        VermifugacaoController vermController = new VermifugacaoController(getBaseContext());
        Vermifugacao vermifugacao = new Vermifugacao();
        vermifugacao.setNome(nome.getText().toString());
        vermifugacao.setData(data.getText().toString());

        Bundle bundle = getIntent().getExtras();
        bundle.putInt("aba", 3);
        boolean resultado = vermController.cadastrar(vermifugacao, bundle.getInt("animal_id"));
        Intent intent = new Intent(view.getContext(), AnimalDetalheActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent it = new Intent(AddVermifugacaoActivity.this, AnimalListagemActivity.class);
                startActivity(it);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
