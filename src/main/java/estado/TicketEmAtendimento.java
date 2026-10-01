package estado;

public class TicketEmAtendimento implements IEstadoTicket {

    @Override
    public String getNome() {
        return "Em Atendimento";
    }

    @Override
    public void solicitarInformacao(Ticket ticket) {
        ticket.setEstado(new TicketAguardandoCliente());
    }

    @Override
    public void resolver(Ticket ticket) {
        ticket.setEstado(new TicketAberto.TicketResolvido());
    }
}