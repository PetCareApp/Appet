package cap7.com.br.petcare.model;

/**
 * Created by antonio on 16/09/2016.
 */
public class Medicacao {
    private int id;

    private String nome;

    private String data;

    private boolean medicado;

    private Animal animal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isMedicado() {
        return medicado;
    }

    public void setMedicado(boolean medicado) {
        this.medicado = medicado;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicacao medicacao = (Medicacao) o;

        return id == medicacao.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
