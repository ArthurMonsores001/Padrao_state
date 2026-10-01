package estado;

public class TicketResolvido implements IEstadoTicket {

    @Override
    public String getNome() {
        return "Resolvido";
    }

    @Override
    public void reabrir(Ticket ticket) {
        ticket.setEstado(new TicketAberto());
    }

    @Override
    public void fechar(Ticket ticket) {
        ticket.setEstado(new TicketFechado());
    }
}