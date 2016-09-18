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
import cap7.com.br.petcare.adapter.AdapterListViewMed;
import cap7.com.br.petcare.cap7.petfy.AddMedicacaoActivity;
import cap7.com.br.petcare.controller.MedicacaoController;

/**
 * Created by antonio on 16/09/2016.
 */
public class MedicacaoFragment extends Fragment {

    private FloatingActionButton btnAddMed;

    public MedicacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medicacao, container, false);
        btnAddMed = (FloatingActionButton) view.findViewById(R.id.btn_add_medicacao);
        btnAddMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddMedicacaoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("animal_id", getArguments().getInt("animal_id"));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        MedicacaoController medicacaoController = new MedicacaoController(getContext());
        AdapterListViewMed adapter = new AdapterListViewMed(getContext(), medicacaoController.getByAnimalId(getArguments().getInt("animal_id")));
        ListView listView = (ListView) view.findViewById(R.id.list_medicacao);
        listView.setAdapter(adapter);
        return view;
    }

}

