package proj.rest.mackimoveis.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locatarios")
public class Locatario extends Usuario {

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas = new ArrayList<>();

    public Locatario() {}

    public Locatario(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public void imprimirDados() {
        System.out.println("Locatário: " + getNome() + " - " + getEmail());
    }
}
