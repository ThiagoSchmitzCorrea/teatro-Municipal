public class Assento {
    /*Quando concluimos o trabalho decidimos não usar os métodos de reserva, ocupado e de liberar, porque vimos que era conteúdo extra mas era requisito do trabalho.  
    Essa classe não é necessária para o funcionamento do programa.
    */
    private int numero;
    private boolean ocupado;

    public Assento(int numero) {
        this.numero = numero;
        this.ocupado = false;
    }
    
    public boolean Ocupado() {
        return ocupado;
    }

    public void reservar() {
        ocupado = true;
    }

    public void liberar() {
        ocupado = false;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
}
