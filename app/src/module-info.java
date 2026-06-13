import br.com.smartCinema.interfaces.CinemaHall;
import br.com.smartCinema.interfaces.Client1;

module app {


    requires br.com.smartCinema.interfaces.interfaces;

    uses Client1;
    uses CinemaHall;

}