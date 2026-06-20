package br.com.smartCinema.clientImpl;

import br.com.smartCinema.interfaces.Client1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.stream.Collectors;


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

    public String getClientFirstName() {
        return clientFirstName;
    }

    public String getClientMidlleName() {
        return clientMidlleName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public long getClientTicket() {
        return clientTicket;
    }

    public long getClientId() {
        return clientId;
    }

    public static List<ClientImpl> getClientList() {
        return clientList;
    }

    @Override
    public void createClient(String clientFirstName, String clientMidlleName, String clientLastName) {
        Locale localeBr = Locale.forLanguageTag("pt-BR");
        for (var c : clientList) {
            if (c.clientFirstName.equalsIgnoreCase(clientFirstName) && c.clientMidlleName.equalsIgnoreCase(clientMidlleName) && c.clientLastName.equalsIgnoreCase(clientLastName)) {
                IO.println("------------------------------------------------------------------------------------------------------------------");
                IO.println(String.format(localeBr, "Cliente: %s %s %s -> Já cadastrado anteriormente e por isso não pôde ser cadastrado.", clientFirstName, clientMidlleName, clientLastName));
                IO.println("------------------------------------------------------------------------------------------------------------------");
                return;
            }
        }

        ClientImpl client = new ClientImpl(clientFirstName.trim().toUpperCase(), clientMidlleName.trim().toUpperCase(), clientLastName.trim().toUpperCase(), clientIdStatic++, clientTicketStatic++);
        clientList.add(client);
    }

    @Override
    public void findClient(long clientId) {
        if (!clientList.isEmpty()) {
           boolean foundClientId = clientList
                    .stream()
                            .anyMatch(c -> c.clientId == clientId);

           if (foundClientId == true) {
               IO.println("----------------------------------------------------------------------------------------------");
               IO.println("Cliente encontrado(a):");
               clientList
                       .stream()
                       .filter(c -> c.clientId == clientId)
                       .forEach(c -> IO.println(c));
               IO.println("----------------------------------------------------------------------------------------------");
           } else {
               if (foundClientId == false) {
                   IO.println("----------------------------------------------------------------------------------------------");
                   IO.println(String.format(localeBr, "Cliente Id %d -> Não encontrado!", clientId));
                   IO.println("----------------------------------------------------------------------------------------------");
               }
           }
        } else {
            if (clientList.isEmpty()) {
                IO.println("Clientes ainda não cadastrados.");
            }
        }

    }

    @Override
    public void printClient() {
        if (!clientList.isEmpty()) {
            IO.println("----------------------------------------------------------------------------------------------");
            IO.println("> Lista de Clientes <");
            for (var c : clientList) {
                IO.println(c);
            }
            IO.println("----------------------------------------------------------------------------------------------");
        } else {
            if (clientList.isEmpty()) {
                IO.println("Nada a mostrar -> Clientes não cadastrados!");
            }
        }
    }

    @Override
    public void printClientToSort() {
        if (!clientList.isEmpty()) {
            IO.println("----------------------------------------------------------------------------------------------");
            IO.println("> Lista de clientes / Ordem alfabética <");
            clientList
                    .stream()
                    .collect(Collectors.groupingBy(c -> c.clientFirstName.charAt(0), TreeMap::new, Collectors.toList()))
                    .forEach((m, l) -> IO.println("-> " + m + " " + l));
            IO.println("----------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void deletClientForId(long clientId) {
       boolean removeClientBoolean = clientList.removeIf(c -> c.clientId == clientId);
       if (removeClientBoolean == true) {
           IO.println("-------------------------------------------------------------------------------------");
           IO.println(String.format(localeBr, "Cliente com o Id %d -> Deletado com sucesso!", clientId));
           IO.println("-------------------------------------------------------------------------------------");
       } else {
           if (removeClientBoolean == false) {
               IO.println("-------------------------------------------------------------------------------------");
               IO.println(String.format(localeBr, "Cliente com o Id %d -> Inexistente", clientId));
               IO.println("-------------------------------------------------------------------------------------");
           }
       }
    }

    @Override
    public String toString() {
        return String.format(localeBr, "Id: %d | Nome: %-15s %-15s %-10s | Ingresso: %d", clientId ,clientFirstName, clientMidlleName, clientLastName, clientTicket);
    }
}
