package sistema;

public class Backlog {
    private String nome;
    private String plataforma;
    private Float preco;


    @Override
    public String toString() {return "Jogo: "+ nome + "\nPlataforma: "+ plataforma + "\nPreço pago:"+ preco;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getPlataforma() {return plataforma;}
    public void setPlataforma(String plataforma) {this.plataforma = plataforma;}

    public Float getPreco() {return preco;}
    public void setPreco(Float preco) {this.preco = preco;}





}
