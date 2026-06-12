package br.com.smartCinema.app;

import br.com.smartCinema.interfaces.Client1;
import br.com.smartCinema.clientImpl.ClientImpl;

public class App1Test {

    static void main(String[] args) {

         Client1 client1 = new ClientImpl();
         client1.createClient("Alícia", "Ferreira","da Silva");
         client1.createClient("Paola", "Oliveira", "Guimarães");
         client1.createClient("Cristina", "Almeida", "Soares");
         client1.printClient();
    }

}
