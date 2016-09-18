package cap7.com.br.petcare.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cap7.com.br.petcare.R;
import cap7.com.br.petcare.controller.AnimalController;
import cap7.com.br.petcare.model.Animal;

/**
 * Created by antonio on 16/09/2016.
 */
public class DetalhesFragment extends Fragment {

    private TextView txtNome;
    private TextView txtEspecie;
    private TextView txtNasc;
    private TextView txtSexo;

    public DetalhesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle bundle) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhes, container, false);
        int id = getArguments().getInt("animal_id");
        AnimalController animalController = new AnimalController(getContext());
        Animal animal = animalController.getById(id);
        txtNome = (TextView) view.findViewById(R.id.txt_frag_detalhe_nome_val);
        txtNome.setText(animal.getNome());
        txtEspecie = (TextView) view.findViewById(R.id.txt_frag_detalhe_especie_val);
        txtEspecie.setText(animal.getEspecie());
        txtNasc = (TextView) view.findViewById(R.id.txt_frag_detalhe_nasc_val);
        txtNasc.setText(animal.getNascimento());
        txtSexo = (TextView) view.findViewById(R.id.txt_frag_detalhe_sexo_val);
        txtSexo.setText(animal.getSexo());

        return view;
    }

}

