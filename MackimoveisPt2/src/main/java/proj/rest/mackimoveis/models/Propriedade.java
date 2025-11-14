package proj.rest.mackimoveis.models;
public class Propriedade {
    private boolean disponivel;
    private String titulo;
    private String descricao;
    private String localizacao;
    private int capacidade;
    private double precoPorNoite;
    private Usuario proprietario;

    public Propriedade(String titulo, String descricao, String localizacao, int capacidade, double precoPorNoite, Usuario proprietario) {
        this.disponivel = true;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.precoPorNoite = precoPorNoite;
        this.proprietario = proprietario;
    }

    public void imprimirDados() {
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Localização: " + localizacao);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Preço por noite: R$" + precoPorNoite);
        System.out.println("Prorietario: " + proprietario.getNome());
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
    }

    public boolean disponibilidade() {
        return disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public Usuario getProprietario() {
        return proprietario;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setPrecoPorNoite(double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }
}