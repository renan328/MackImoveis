package proj.rest.mackimoveis.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Propriedade propriedade;

    @ManyToOne
    private Usuario usuario;

    private LocalDate checkIn;
    private LocalDate checkOut;
    private double custoTotal;

    public Reserva() {
    }

    public Reserva(Long id, Propriedade propriedade, Inquilino usuario, LocalDate checkin, LocalDate checkout) {
        this.propriedade = propriedade;
        this.usuario = usuario;
        this.checkIn = checkin;
        this.checkOut = checkout;
        calcularCustoTotal();
    }

    public void calcularCustoTotal() {
        if (checkIn != null && checkOut != null && propriedade != null) {
            long dias = ChronoUnit.DAYS.between(checkIn, checkOut);
            if (dias <= 0)
                dias = 1;
            this.custoTotal = dias * propriedade.getPrecoPorNoite();
        }
    }

    public Long getId() {
        return id;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }
}