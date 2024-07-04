import java.util.Scanner;

public class Main {
    
    private static Visita visitaTeatro;
    private static String[] horariosVisita = {"10:00", "14:00", "16:00", "18:00", "20:00"};
    
    
    public static void main(String[] args) {
        
        Evento evento1 = new Evento("Romeu e Julieta ", "07-07-2024", "20:00", " história sobre dois adolescentes cuja morte acaba unindo suas famílias.", 50.0, 150, 150);
        Evento evento2 = new Evento("O Auto da Compadecida", "16-08-2024", "19:30", "É um drama nordestino apresentado em três atos. Contém elementos da literatura de cordel e está inserido no gênero da comédia, se aproximando, nos traços, do barroco católico brasileiro. ", 35.0, 100, 100);
        Evento evento3 = new Evento("Matilda", "11-11-2024", "16:00", "Matilda conta a história de uma garotinha inteligente, mas negligenciada pelos pais que encontra refúgio nos livros.", 25.0, 90, 90);
        Evento evento4 = new Evento("Hamlet", "23-12-2024", "19:00", "A peça gira em torno do príncipe da Dinamarca, Hamlet, que busca vingar a morte de seu pai e confrontar a corrupção que assola o reino.", 60.0, 180, 180);
        Evento evento5 = new Evento("Esperando Godot", "05-01-2025", "20:30", "É uma peça do teatro do absurdo que segue dois personagens, Vladimir e Estragon, enquanto eles esperam indefinidamente pela chegada de alguém chamado Godot.", 45.0, 75, 75);

        visitaTeatro = new Visita(horariosVisita.length);
        for (String horario : horariosVisita) {
            visitaTeatro.adicionarHorario(horario, 20);
        }

        exibirMenu(evento1, evento2, evento3, evento4, evento5);
    }
    

    public static void exibirMenu(Evento... eventos) {
    Scanner scanner = new Scanner(System.in);
    int opcao;
    do {
        System.out.println("---------------------");
        System.out.println("1. Eventos");
        System.out.println("2. Visita");
        System.out.println("3. Relatório");
        System.out.println("4. Sair");
        System.out.println("---------------------");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                exibirTodosEventos(eventos);
                break;
            case 2:
                exibirMenuVisita();
                break;
            case 3:
                relatorio(eventos);
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Escolha novamente.");
        }
    } while (opcao != 4);

    scanner.close();
}

public static void exibirMenuVisita() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("---------------------");
    System.out.println("Visitas são feitas somente aos Sábados");
    System.out.println("Horários de Visita:");
    for (int i = 0; i < horariosVisita.length; i++) {
        System.out.println((i + 1) + ". " + horariosVisita[i] + " - " + visitaTeatro.getVagasDisponiveis()[i] + " vagas ");
    }
    System.out.println((horariosVisita.length + 1) + ". Voltar");
    System.out.println("---------------------");
    System.out.print("Escolha um horário de visita ou 'Voltar': ");
    int opcaoVisita = scanner.nextInt();
    if (opcaoVisita >= 1 && opcaoVisita <= horariosVisita.length) {
        if (visitaTeatro.agendarVisita(horariosVisita[opcaoVisita - 1])) {
            System.out.println("Visita agendada com sucesso!");
        }
    } else if (opcaoVisita != horariosVisita.length + 1) {
        System.out.println("Opção inválida. Escolha novamente.");
    }
}

    public static void exibirTodosEventos(Evento... eventos) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("---------------------");
            for (int i = 0; i < eventos.length; i++) {
                System.out.println((i + 1) + ". " + eventos[i].getNome());
            }
            System.out.println((eventos.length + 1) + ". Sair");
            System.out.println("---------------------");
            System.out.print("Escolha um evento ou 'Sair': ");
            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= eventos.length) {
                exibirInformacoesEvento(eventos[opcao - 1]);
                comprarIngresso(eventos[opcao - 1]);
            } else if (opcao != eventos.length + 1) {
                System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != eventos.length + 1);

        scanner.close();
    }

    public static void exibirInformacoesEvento(Evento evento) {
        System.out.println("------------------------------");
        System.out.println("Evento: " + evento.getNome());
        System.out.println("Descrição: " + evento.getDescricao());
        System.out.println("Data: " + evento.getData());
        System.out.println("Horário: " + evento.getHorario());
        System.out.println("Preço do Ingresso: " + evento.getPrecoIngresso());
        System.out.println("Capacidade Máxima: " + evento.getCapacidadeMaxima());
        System.out.println("Assentos Disponíveis: " + evento.getAssentosDisponiveis());
        System.out.println("------------------------------");
    }

    public static void comprarIngresso(Evento evento) {
        if (evento.getAssentosDisponiveis() == 0) {
            System.out.println("Desculpe, os assentos para este evento estão esgotados.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja comprar o ingresso online ou presencialmente?");
        System.out.println("1. Online");
        System.out.println("2. Presencial");
        System.out.println("3. Voltar");

        int opcaoCompra = scanner.nextInt();
        switch (opcaoCompra) {
            case 1:
                System.out.println("Digite a quantidade de ingressos desejada: ");
                int quantidadeIngressosOnline = scanner.nextInt();
                Ingresso ingressoOnline = new Ingresso(evento.getPrecoIngresso());

                if (!ingressoOnline.verificarDisponibilidade(quantidadeIngressosOnline, evento.getAssentosDisponiveis())) {
                    System.out.println("Desculpe, não há assentos suficientes disponíveis.");
                    return;
                }

                double valorTotalOnline = ingressoOnline.getPreco() * quantidadeIngressosOnline;
                System.out.println(quantidadeIngressosOnline + " ingressos serão por R$" + valorTotalOnline + ". Qual o valor desejado?");
                double valorPagoOnline = scanner.nextDouble();
                if (ingressoOnline.comprarOnline(valorPagoOnline, quantidadeIngressosOnline)) {
                    System.out.println("Pagamento confirmado. Ingresso(s) comprado(s) com sucesso!");
                    evento.diminuirAssentosDisponiveis(quantidadeIngressosOnline);
                } else {
                    System.out.println("Valor incorreto. O pagamento não pôde ser concluído.");
                }
                break;
            case 2:
                System.out.println("Digite a quantidade de ingressos desejada: ");
                int quantidadeIngressosPresencial = scanner.nextInt();
                Ingresso ingressoPresencial = new Ingresso(evento.getPrecoIngresso());
        
                if (!ingressoPresencial.verificarDisponibilidade(quantidadeIngressosPresencial, evento.getAssentosDisponiveis())) {
                    System.out.println("Desculpe, não há assentos suficientes disponíveis.");
                    return;
                }
    
                double valorTotalPresencial = ingressoPresencial.getPreco() * quantidadeIngressosPresencial;
                System.out.println(quantidadeIngressosPresencial + " ingressos serão por R$" + valorTotalPresencial + ". Qual o valor desejado?");
                double valorPagoPresencial = scanner.nextDouble();
                double troco = ingressoPresencial.comprarPresencial(valorPagoPresencial, quantidadeIngressosPresencial);
                if (troco >= 0) {
                    System.out.println("Pagamento confirmado. Seu troco é: R$ " + troco);
                    evento.diminuirAssentosDisponiveis(quantidadeIngressosPresencial);
                } else {
                    System.out.println("Valor insuficiente. O pagamento não pôde ser concluído.");
                }
                break;
            case 3:
                System.out.println("Voltando ao menu anterior...");
                break;
            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }

    public static void relatorio(Evento... eventos) {
        System.out.println("------------------------------");
        System.out.println("Relatório de Eventos:");
        System.out.println("------------------------------");
        for (Evento evento : eventos) {
            System.out.println("Evento: " + evento.getNome());
            System.out.println("Total arrecadado: R$" + (evento.getCapacidadeMaxima() - evento.getAssentosDisponiveis()) * evento.getPrecoIngresso());
            System.out.println("Assentos disponíveis: " + evento.getAssentosDisponiveis() + " / " + evento.getCapacidadeMaxima());
            System.out.println("------------------------------");
        }
    }
}
