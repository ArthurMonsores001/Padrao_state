package estado;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketTest {

    @Test
    void ticketNovoComecaAberto() {
        Ticket ticket = new Ticket("Teste");
        assertEquals("Aberto", ticket.getNomeEstado());
    }

    @Test
    void fluxoNormalAteFechar() {
        Ticket ticket = new Ticket("Teste");

        ticket.atribuir();
        assertEquals("Em Atendimento", ticket.getNomeEstado());

        ticket.resolver();
        assertEquals("Resolvido", ticket.getNomeEstado());

        ticket.fechar();
        assertEquals("Fechado", ticket.getNomeEstado());
    }

    @Test
    void solicitarInformacaoEReceberRespostaVoltaParaAtendimento() {
        Ticket ticket = new Ticket("Teste");
        ticket.atribuir();

        ticket.solicitarInformacao();
        assertEquals("Aguardando Cliente", ticket.getNomeEstado());

        ticket.receberResposta();
        assertEquals("Em Atendimento", ticket.getNomeEstado());
    }

    @Test
    void ticketAguardandoClientePodeSerFechadoPorInatividade() {
        Ticket ticket = new Ticket("Teste");
        ticket.atribuir();
        ticket.solicitarInformacao();

        ticket.fechar();
        assertEquals("Fechado", ticket.getNomeEstado());
    }

    @Test
    void ticketResolvidoPodeSerReaberto() {
        Ticket ticket = new Ticket("Teste");
        ticket.atribuir();
        ticket.resolver();

        ticket.reabrir();
        assertEquals("Aberto", ticket.getNomeEstado());
    }

    @Test
    void ticketAbertoNaoPodeSerResolvidoDiretamente() {
        Ticket ticket = new Ticket("Teste");
        assertThrows(IllegalStateException.class, ticket::resolver);
        assertEquals("Aberto", ticket.getNomeEstado());
    }

    @Test
    void ticketFechadoNaoAceitaNenhumaAcao() {
        Ticket ticket = new Ticket("Teste");
        ticket.atribuir();
        ticket.resolver();
        ticket.fechar();

        assertThrows(IllegalStateException.class, ticket::atribuir);
        assertThrows(IllegalStateException.class, ticket::solicitarInformacao);
        assertThrows(IllegalStateException.class, ticket::receberResposta);
        assertThrows(IllegalStateException.class, ticket::resolver);
        assertThrows(IllegalStateException.class, ticket::reabrir);
        assertThrows(IllegalStateException.class, ticket::fechar);
    }

    @Test
    void historicoRegistraTransicoes() {
        Ticket ticket = new Ticket("Teste");
        ticket.atribuir();
        ticket.resolver();

        assertEquals(3, ticket.getHistorico().size());
        assertEquals("Aberto -> Em Atendimento", ticket.getHistorico().get(1));
        assertEquals("Em Atendimento -> Resolvido", ticket.getHistorico().get(2));
    }
}