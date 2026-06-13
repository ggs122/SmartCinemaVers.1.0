package br.com.smartCinema.interfaces;

public interface CinemaHall {

    void createCinemaHall(int cinemaHallseats, int aisle);
    void putClientInHall(long clientId, int cinemaHallseats, int aisle);
    void printCinemaHall();

}
