package estado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticket {

    private static int proximoId = 1;

    private final int id;
    private final String titulo;
    private IEstadoTicket estado;
    private final List<String> historico = new ArrayList<>();

    public Ticket(String titulo) {
        this.id = proximoId++;
        this.titulo = titulo;
        this.estado = new TicketAberto();
        historico.add("Ticket criado no estado " + estado.getNome());
    }

    public void atribuir() {
        estado.atribuir(this);
    }

    public void solicitarInformacao() {
        estado.solicitarInformacao(this);
    }

    public void receberResposta() {
        estado.receberResposta(this);
    }

    public void resolver() {
        estado.resolver(this);
    }

    public void reabrir() {
        estado.reabrir(this);
    }

    public void fechar() {
        estado.fechar(this);
    }

    void setEstado(IEstadoTicket novoEstado) {
        historico.add(estado.getNome() + " -> " + novoEstado.getNome());
        this.estado = novoEstado;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNomeEstado() {
        return estado.getNome();
    }

    public List<String> getHistorico() {
        return Collections.unmodifiableList(historico);
    }

    @Override
    public String toString() {
        return "Ticket #" + id + " [" + titulo + "] estado: " + estado.getNome();
    }
}