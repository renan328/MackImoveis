import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.INDENTITY)
    private Long id;
    private Propriedade propriedade;
    private Usuario usuario;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int dias;
    private double custoTotal;

    public Reserva(Propriedade propriedade, Usuario usuario, String checkIn, String checkOut, int dias) {
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

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
        this.custoTotal = calcularCustoTotal();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
        this.custoTotal = calcularCustoTotal();
    }

    public double getCustoTotal() {
        return custoTotal;
    }
}
