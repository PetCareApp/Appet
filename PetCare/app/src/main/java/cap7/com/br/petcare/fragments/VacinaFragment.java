package cap7.com.br.petcare.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import cap7.com.br.petcare.R;
import cap7.com.br.petcare.adapter.AdapterListViewVacina;
import cap7.com.br.petcare.cap7.petfy.AddVacinaActivity;
import cap7.com.br.petcare.controller.VacinaController;

/**
 * Created by antonio on 16/09/2016.
 */
public class VacinaFragment extends Fragment {

    private FloatingActionButton btnAddVacina;

    public VacinaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vacina, container, false);
        btnAddVacina = (FloatingActionButton) view.findViewById(R.id.btn_add_vacina);
        btnAddVacina.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddVacinaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("animal_id", getArguments().getInt("animal_id"));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        VacinaController vacinaController = new VacinaController(getContext());
        AdapterListViewVacina adapter = new AdapterListViewVacina(getContext(), vacinaController.getByAnimalId(getArguments().getInt("animal_id")));
        ListView listView = (ListView) view.findViewById(R.id.list_vacina);
        listView.setAdapter(adapter);

        return view;
    }

}

