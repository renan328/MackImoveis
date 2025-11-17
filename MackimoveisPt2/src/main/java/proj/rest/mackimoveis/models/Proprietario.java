package proj.rest.mackimoveis.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proprietarios")
public class Proprietario extends Usuario {

    @OneToMany(mappedBy = "proprietario")
    private List<Propriedade> propriedades = new ArrayList<>();

    public Proprietario() {}

    public Proprietario(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    @Override
    public void imprimirDados() {
        System.out.println("Proprietário: " + getNome() + " - " + getEmail());
    }
}
