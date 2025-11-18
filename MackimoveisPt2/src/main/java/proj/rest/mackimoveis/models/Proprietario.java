package proj.rest.mackimoveis.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Proprietario extends Usuario {

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    private List<Propriedade> propriedades;

    public Proprietario() {}

    public Proprietario(Long id, String nome, String email, String senha) {
        super();
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
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
