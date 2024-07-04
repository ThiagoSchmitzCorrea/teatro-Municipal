public class Ingresso {
    private double preco;

    public Ingresso(double preco) {
        this.preco = preco;
    }

    public boolean comprarOnline(double valorPago, int quantidadeIngressos) {
        double total = preco * quantidadeIngressos;
        return valorPago == total;
    }

    public double comprarPresencial(double valorPago, int quantidadeIngressos) {
        double total = preco * quantidadeIngressos;
        if (valorPago >= total) {
            return valorPago - total;
        } else {
            return -1;
        }
    }
    
     public boolean verificarDisponibilidade(int quantidadeIngressos, int assentosDisponiveis) {
        return quantidadeIngressos <= assentosDisponiveis;
    }
    
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
}
