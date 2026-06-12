package br.com.smartCinema.clientImpl;

import br.com.smartCinema.interfaces.Client1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ClientImpl implements Client1 {

    private String clientFirstName;
    private String clientMidlleName;
    private String clientLastName;
    private long clientTicket = clientTicketStatic;
    private static int clientTicketStatic = 400;
    private long clientId = clientIdStatic;
    private static int clientIdStatic = 100000;
    Locale localeBr = Locale.forLanguageTag("pt-BR");

    private ClientImpl(String clientFirstName, String clientMidlleName, String clientLastName, int clientTicket, int clientId) {
        this.clientFirstName = clientFirstName;
        this.clientMidlleName = clientMidlleName;
        this.clientLastName = clientLastName;
        this.clientTicket = clientTicket;
        this.clientId = clientId;
    }

    static List<ClientImpl> clientList = new ArrayList<>();

    public ClientImpl() {}

    protected String getClientFirstName() {
        return clientFirstName;
    }

    protected String getClientMidlleName() {
        return clientMidlleName;
    }

    protected String getClientLastName() {
        return clientLastName;
    }

    protected long getClientTicket() {
        return clientTicket;
    }

    protected long getClientId() {
        return clientId;
    }

    public static List<ClientImpl> getClientList() {
        return clientList;
    }

    @Override
    public void createClient(String clientFirstName, String clientMidlleName, String clientLastName) {
        ClientImpl client = new ClientImpl(clientFirstName, clientMidlleName, clientLastName, clientIdStatic++, clientTicketStatic++);
        clientList.add(client);
    }

    @Override
    public void printClient() {
        for (var c : clientList) {
            IO.println(c);
        }
    }

    @Override
    public String toString() {
        return String.format(localeBr, "Id: %d | Nome: %-15s %-15s %-15s | Ingresso: %d", clientId ,clientFirstName, clientMidlleName, clientLastName, clientTicket);
    }
}
