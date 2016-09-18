package cap7.com.br.petcare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cap7.com.br.petcare.R;
import cap7.com.br.petcare.model.Animal;

/**
 * Created by antonio on 16/09/2016.
 */
public class AdapterListViewAnimal extends ArrayAdapter<Animal> {

    public AdapterListViewAnimal(Context context, List<Animal> itens) {
        super(context, 0, itens);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal animal = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_animal, parent, false);
        }

        TextView txtNome = (TextView) convertView.findViewById(R.id.txt_item_animal_nome);
        txtNome.setText(animal.getNome());
        return convertView;
    }
}

