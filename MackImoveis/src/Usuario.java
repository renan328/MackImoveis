import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    private ArrayList<Propriedade> propPropria;
    private ArrayList<Reserva> resRealizada;

    public Usuario(){
        this.propPropria = new ArrayList<>();
        this.resRealizada = new ArrayList<>();
    }

    public Usuario (String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.propPropria = new ArrayList<>();
        this.resRealizada = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha  = senha;
    }

    public ArrayList<Propriedade> getPropriedades(){
        return propPropria;
    }


    public ArrayList<Reserva> getReservas(){
        return resRealizada;
    }

    public void adicionarPropriedades(Propriedade propriedade){
        propPropria.add(propriedade);
    }

    public void listarProProprias(){
        if(propPropria.isEmpty()){
            System.out.println("Nenhuma propriedade cadastrada.");
        }else{
            System.out.println("Propriedades do usuário: ");
            for(Propriedade p : propPropria){
                System.out.println(p);
            }
        }
    }

    public void realizarReserva(Reserva reserva){
        resRealizada.add(reserva);
    }

    public void listarReserva(){
        if (resRealizada.isEmpty()){
            System.out.println("Nenhuma Reserva realizada.");
        }else{
            System.out.println("Reserva do usuário: ");
            for (Reserva r : resRealizada){
                System.out.println(r);
            }
        }
    }

    public void imprimirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
    }
}
