package estado;

public interface IEstadoTicket {

    String getNome();

    default void atribuir(Ticket ticket) {
        acaoInvalida("atribuir", ticket);
    }

    default void solicitarInformacao(Ticket ticket) {
        acaoInvalida("solicitar informacao", ticket);
    }

    default void receberResposta(Ticket ticket) {
        acaoInvalida("receber resposta", ticket);
    }

    default void resolver(Ticket ticket) {
        acaoInvalida("resolver", ticket);
    }

    default void reabrir(Ticket ticket) {
        acaoInvalida("reabrir", ticket);
    }

    default void fechar(Ticket ticket) {
        acaoInvalida("fechar", ticket);
    }

    private void acaoInvalida(String acao, Ticket ticket) {
        throw new IllegalStateException(
                "Nao e possivel " + acao + " o ticket #" + ticket.getId()
                        + " no estado " + getNome());
    }
}