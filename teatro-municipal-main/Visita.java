import java.util.Arrays;

public class Visita {
    private String[] horariosDisponiveis;
    private int[] vagasDisponiveis;
    private int numHorarios;

    public Visita(int numHorarios) {
        this.numHorarios = numHorarios;
        this.horariosDisponiveis = new String[numHorarios];
        this.vagasDisponiveis = new int[numHorarios];
        Arrays.fill(horariosDisponiveis, "");
    }

    public void adicionarHorario(String horario, int vagasDisponiveis) {
        int indice = procurarIndiceVazio(horariosDisponiveis);
        if (indice != -1) {
            this.horariosDisponiveis[indice] = horario;
            this.vagasDisponiveis[indice] = vagasDisponiveis;
        } else {
            System.out.println("Limite de horários atingido. Não é possível adicionar mais horários.");
        }
    }

    private int procurarIndiceVazio(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) {
                return i;
            }
        }
        return -1;
    }

    public boolean agendarVisita(String horario) {
        int indice = Arrays.asList(horariosDisponiveis).indexOf(horario);
        if (indice != -1) {
            if (vagasDisponiveis[indice] > 0) {
                vagasDisponiveis[indice]--;
                return true;
            } else {
                System.out.println("Não há mais vagas disponíveis para o horário selecionado.");
                return false;
            }
        } else {
            System.out.println("Horário selecionado não está disponível para visitas.");
            return false;
        }
    }
    
    public String[] getHorariosDisponiveis() {
        return horariosDisponiveis;
    }
    public void setHorariosDisponiveis(String[] horariosDisponiveis){
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public int[] getVagasDisponiveis() {
        return vagasDisponiveis;
    }
    public void setVagasDisponiveis(int[] vagasDisponiveis){
        this.vagasDisponiveis = vagasDisponiveis;
    }
}