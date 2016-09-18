package cap7.com.br.petcare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cap7.com.br.petcare.R;
import cap7.com.br.petcare.model.Vacina;

/**
 * Created by antonio on 16/09/2016.
 */
public class AdapterListViewVacina extends ArrayAdapter<Vacina> {

    public AdapterListViewVacina(Context context, List<Vacina> itens) {
        super(context, 0, itens);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Vacina vacina = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_vacina, parent, false);
        }

        TextView txtNome = (TextView) convertView.findViewById(R.id.txt_item_vacina_nome);
        txtNome.setText(vacina.getNome());
        TextView txtData = (TextView) convertView.findViewById(R.id.txt_item_vacina_data);
        txtData.setText(vacina.getData());
        return convertView;
    }
}

