package br.com.smartCinema.cinemaHall;
import br.com.smartCinema.clientImpl.ClientImpl;
import br.com.smartCinema.interfaces.CinemaHall;

import java.util.List;
import java.util.Locale;

public class CinemaHallImpl implements CinemaHall {

    private int cinemaHallNumber;
    private int cinemaHallseats;
    private int aisle;

    static List<ClientImpl> clientList;

    Locale localeBr = Locale.forLanguageTag("pt-BR");

    private CinemaHallImpl[][] cinemaHalls;

    public CinemaHallImpl() {}

    private CinemaHallImpl(int cinemaHallseats, int aisle, int cinemaHallNumber) {
        this.cinemaHallseats = cinemaHallseats;
        this.aisle = aisle;
        this.cinemaHallNumber = cinemaHallNumber;
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
    public void createCinemaHall(int cinemaHallseats, int aisle, int cinemaHallNumber) {
        for (int i = 0; i < cinemaHallseats; i++) {
            for (int j = 0; j < aisle; i++) {
                cinemaHalls[i][j] = new CinemaHallImpl(i+ 1, j + 1, cinemaHallNumber);
            }
        }
    }

    @Override
    public void printCinemaHall() {
        for (int i = 0; i < cinemaHallseats; i++) {
            System.out.print(i);
            for (int j = 0; j < aisle; i++) {
                System.out.println(j);
            }
        }
    }

    @Override
    public String toString() {
        return String.format(localeBr, "Corredor: %d | Assento: %d | Sala de Cinema %d", aisle, cinemaHallseats, cinemaHallNumber);
    }
}
