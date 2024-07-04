import java.util.ArrayList;

public class Evento {
    private String nome;
    private String data;
    private String horario;
    private String descricao;
    private double precoIngresso;
    private int capacidadeMaxima;
    private int assentosDisponiveis;
    private ArrayList<Assento> assentos;

    public Evento(String nome, String data, String horario, String descricao, double precoIngresso, int capacidadeMaxima, int assentosDisponiveis) {
        this.nome = nome;
        this.data = data;
        this.horario = horario;
        this.descricao = descricao;
        this.precoIngresso = precoIngresso;
        this.capacidadeMaxima = capacidadeMaxima;
        this.assentosDisponiveis = assentosDisponiveis;
    }
    
    public boolean diminuirAssentosDisponiveis(int quantidade) {
        if (quantidade <= assentosDisponiveis) {
            assentosDisponiveis -= quantidade;
            return true;
        } else {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getData() {
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario){
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    

    public double getPrecoIngresso() {
        return precoIngresso;
    }
    public void setPrecoIngresso(double precoIngresso){
        this.precoIngresso = precoIngresso;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    public void setCapacidadeMaxima(int capacidadeMaxima){
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }
    public void setAssentosDisponiveis(int assentosDisponiveis){
        this.assentosDisponiveis = assentosDisponiveis;
    }
}

