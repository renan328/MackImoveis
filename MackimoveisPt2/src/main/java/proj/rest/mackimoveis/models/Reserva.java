package proj.rest.mackimoveis.models;
public class Reserva {

    private Propriedade propriedade;
    private Usuario usuario;
    // private String checkIn;
    // private String checkOut;
    private int dias;
    private double custoTotal;

    public Reserva(Propriedade propriedade, Usuario usuario, String checkIn, String checkOut, int dias) {
        this.propriedade = propriedade;
        this.usuario = usuario;
        // this.checkIn = checkIn;
        // this.checkOut = checkOut;
        this.dias = dias;
        this.custoTotal = calcularCustoTotal();
    }

    private double calcularCustoTotal() {
        // dias = checkIn - checkOut;
        return dias * propriedade.getPrecoPorNoite();
    }

    public void imprimirDados() {
        System.out.println("=== Reserva ===");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Propriedade: " + propriedade.getTitulo());
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
