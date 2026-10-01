package estado;

public class TicketAguardandoCliente implements IEstadoTicket {

    @Override
    public String getNome() {
        return "Aguardando Cliente";
    }

    @Override
    public void receberResposta(Ticket ticket) {
        ticket.setEstado(new TicketEmAtendimento());
    }

    @Override
    public void fechar(Ticket ticket) {
        ticket.setEstado(new TicketFechado());
    }
}