package br.com.smartCinema.app;

import br.com.smartCinema.interfaces.CinemaHall;
import br.com.smartCinema.interfaces.Client1;

import java.util.ServiceLoader;


public class App1Test {

    static void main(String[] args) {

         Client1 client1 = ServiceLoader.load(Client1.class)
                         .findFirst()
                                 .orElseThrow();
         client1.createClient("Alícia", "Ferreira","da Silva");
         client1.createClient("Alana", "Soares", "Da Silva");
         client1.createClient("Paola", "Oliveira", "Guimarães");
         client1.createClient("Cristina", "Almeida", "Soares");
         client1.printClient();
         client1.findClient(400);
         client1.printClientToSort();

        CinemaHall cinemaHall1 = ServiceLoader.load(CinemaHall.class)
                .findFirst()
                .orElseThrow();

        cinemaHall1.createCinemaHall(10, 3);
        cinemaHall1.putClientInHall(400, 0, 0);
        cinemaHall1.putClientInHall(401, 0, 1);
        cinemaHall1.putClientInHall(402, 0, 2);
        cinemaHall1.printCinemaHall();
    }

}
