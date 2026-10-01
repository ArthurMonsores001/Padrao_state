package estado;

public class TicketFechado implements IEstadoTicket {

    @Override
    public String getNome() {
        return "Fechado";
    }
}