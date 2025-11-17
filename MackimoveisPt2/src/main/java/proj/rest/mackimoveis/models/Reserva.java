package proj.rest.mackimoveis.models;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Propriedade propriedade;
    private Usuario usuario;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int dias;
    private double custoTotal;

    public Reserva(){}

    public Reserva(Propriedade propriedade, Usuario usuario, String checkIn, String checkOut) {
        this.propriedade = propriedade;
        this.usuario = usuario;
        // localDate.parse serve para converter (nesse caso string para data)
        this.checkIn = LocalDate.parse(checkIn);
        this.checkOut = LocalDate.parse(checkOut);
        this.dias = calcularDias();
        this.custoTotal = calcularCustoTotal();
    }

    private int calcularDias(){
        // força o resultado ser um int 
        return (int) ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    private double calcularCustoTotal() {
        return dias * propriedade.getPrecoPorNoite();
    }

    public void imprimirDados() {
        System.out.println("=== Reserva ===");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Propriedade: " + propriedade.getTitulo());
        System.out.println("Check-in: " + checkIn);
        System.out.print("Check-out: " + checkOut);
        System.out.println("Dias de estadia: " + dias);
        System.out.println("Custo total: R$ " + custoTotal);
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

    public int getDias() {
        return dias;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
        this.custoTotal = calcularCustoTotal();

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

    public void setDias(int dias) {
        this.dias = dias;
        this.custoTotal = calcularCustoTotal();
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }
}