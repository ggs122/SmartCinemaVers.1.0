import br.com.smartCinema.interfaces.Client1;
import br.com.smartCinema.clientImpl.ClientImpl;

module br.com.smartCinema.clientImpl.ClientImpl {

    requires br.com.smartCinema.interfaces.interfaces;

    exports br.com.smartCinema.clientImpl;

    provides Client1 with ClientImpl;

}