package estado;

public class Main {

    public static void main(String[] args) {
        Ticket ticket = new Ticket("Enviando Ticket");
        System.out.println(ticket);

        ticket.atribuir();
        System.out.println(ticket);

        ticket.solicitarInformacao();
        System.out.println(ticket);

        ticket.receberResposta();
        System.out.println(ticket);

        ticket.resolver();
        System.out.println(ticket);

        ticket.reabrir();
        System.out.println(ticket);

        ticket.atribuir();
        ticket.resolver();
       //tentando sem fechar  ticket.fechar();
        System.out.println(ticket);

        System.out.println("\nTentando reabrir um ticket fechado:");
        try {
            ticket.reabrir();
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\nHistorico:");
        ticket.getHistorico().forEach(linha -> System.out.println(" - " + linha));
    }
}