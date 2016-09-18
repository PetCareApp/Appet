package cap7.com.br.petcare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cap7.com.br.petcare.R;
import cap7.com.br.petcare.model.Vermifugacao;

/**
 * Created by antonio on 16/09/2016.
 */
public class AdapterListViewVermifugacao extends ArrayAdapter<Vermifugacao> {

    public AdapterListViewVermifugacao(Context context, List<Vermifugacao> itens) {
        super(context, 0, itens);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Vermifugacao verm = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_vermifugacao, parent, false);
        }

        TextView txtNome = (TextView) convertView.findViewById(R.id.txt_item_verm_nome);
        txtNome.setText(verm.getNome());
        TextView txtData = (TextView) convertView.findViewById(R.id.txt_item_verm_data);
        txtData.setText(verm.getData());
        return convertView;
    }
}

