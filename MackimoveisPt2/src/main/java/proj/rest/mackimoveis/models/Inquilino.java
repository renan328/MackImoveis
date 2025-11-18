package proj.rest.mackimoveis.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Inquilino extends Usuario {
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)

    private List<Reserva> reservas;

    public Inquilino() {}

    public Inquilino(Long id, String nome, String email, String senha) {
        super();
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
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
