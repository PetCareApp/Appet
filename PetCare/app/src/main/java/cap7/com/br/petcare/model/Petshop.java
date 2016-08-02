package cap7.com.br.petcare.model;

import java.io.Serializable;

/**
 * Created by antonio on 29/07/2016.
 */
public class Petshop implements Serializable {

    public double lat;
    public double lng;
    public String nome;
    public String descricao;
    public String site;
    public int id;

    public Petshop(int id, String nome, String descricao, double lat, double lng, String site){
        this.lat = lat;
        this.lng = lng;
        this.nome = nome;
        this.descricao = descricao;
        this.site = site;
        this.id = id;
    }

    @Override
    public String toString(){ return nome; }
}
