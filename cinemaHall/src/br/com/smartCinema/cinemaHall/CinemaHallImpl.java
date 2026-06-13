package br.com.smartCinema.cinemaHall;
import br.com.smartCinema.clientImpl.ClientImpl;
import br.com.smartCinema.interfaces.CinemaHall;

import java.util.List;
import java.util.Locale;

public class CinemaHallImpl implements CinemaHall {

    private int cinemaHallNumber;
    private int cinemaHallseats;
    private int aisle;

    private String clientFirstName;
    private String clientMidlleName;
    private String clientLastName;
    private long clientId;
    private long clientTicket;

    static List<ClientImpl> clientList = getClientList();

    Locale localeBr = Locale.forLanguageTag("pt-BR");

    private CinemaHallImpl[][] cinemaHalls;

    public CinemaHallImpl() {}

    private CinemaHallImpl(int cinemaHallseats, int aisle, int cinemaHallNumber) {
        this.cinemaHallseats = cinemaHallseats;
        this.aisle = aisle;
        this.cinemaHallNumber = cinemaHallNumber;
    }

    private CinemaHallImpl(String clientFirstName, String clientMidlleName, String clientLastName, int clientTicket, int clientId) {
        this.clientFirstName = clientFirstName;
        this.clientMidlleName = clientMidlleName;
        this.clientLastName = clientLastName;
        this.clientTicket = clientTicket;
        this.clientId = clientId;
    }


    protected int getCinemaHallNumber() {
        return cinemaHallNumber;
    }

    
    protected int getCinemaHallseats() {
        return cinemaHallseats;
    }

    
    protected int getAisle() {
        return aisle;
    }



    public static List<ClientImpl> getClientList() {
        return clientList;
    }

    @Override
    public void createCinemaHall(int cinemaHallseats, int aisle) {
        this.cinemaHallseats = cinemaHallseats;
        this.aisle = aisle;
        this.cinemaHalls = new CinemaHallImpl[cinemaHallseats][aisle];
    }

    @Override
    public void putClientInHall(long clientId, int cinemaHallseats, int aisle) {
        for (var c : clientList) {
            if ( c.getClientId() == clientId) {
                CinemaHallImpl cinemaHall = new CinemaHallImpl(c.getClientFirstName(), c.getClientMidlleName(), c.getClientLastName(), (int) c.getClientTicket(), (int) c.getClientId());
                cinemaHalls[cinemaHallseats][aisle] = cinemaHall;
            }
        }
    }

    @Override
    public void printCinemaHall() {
        for (int i = 0; i < cinemaHallseats; i++) {
            for (int j = 0; j < aisle; j++) {
                System.out.print(cinemaHalls[i][j].clientFirstName);
            }

            System.out.println();
        }
    }

    @Override
    public String toString() {
        return String.format(localeBr, "Corredor: %d | Assento: %d | Sala de Cinema %d", aisle, cinemaHallseats, cinemaHallNumber);
    }
}
