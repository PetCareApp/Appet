package cap7.com.br.petcare.cap7.petfy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import cap7.com.br.petcare.R;
import cap7.com.br.petcare.adapter.ViewPagerAdapter;
import cap7.com.br.petcare.fragments.DetalhesFragment;
import cap7.com.br.petcare.fragments.MedicacaoFragment;
import cap7.com.br.petcare.fragments.VacinaFragment;
import cap7.com.br.petcare.fragments.VermifugacaoFragment;

public class AnimalDetalheActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detalhe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        Fragment detalhes = new DetalhesFragment();
        detalhes.setArguments(bundle);
        Fragment vacinacao = new VacinaFragment();
        vacinacao.setArguments(bundle);
        Fragment medicacao = new MedicacaoFragment();
        medicacao.setArguments(bundle);
        Fragment vermifugacao = new VermifugacaoFragment();
        vermifugacao.setArguments(bundle);
        viewPagerAdapter.addFragments(detalhes, "Detalhes");
        viewPagerAdapter.addFragments(vacinacao, "Vacinação");
        viewPagerAdapter.addFragments(medicacao, "Medicação");
        viewPagerAdapter.addFragments(vermifugacao, "Vermifugação");

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(bundle.getInt("aba"));
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent it = new Intent(AnimalDetalheActivity.this, AnimalListagemActivity.class);
                startActivity(it);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
