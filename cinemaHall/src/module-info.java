import br.com.smartCinema.cinemaHall.CinemaHallImpl;
import br.com.smartCinema.interfaces.CinemaHall;

module cinemaHallImpl {

    requires br.com.smartCinema.clientImpl.ClientImpl;
    requires br.com.smartCinema.interfaces.interfaces;

    provides CinemaHall with CinemaHallImpl;


}