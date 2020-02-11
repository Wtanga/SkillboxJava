import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Airport airport = Airport.getInstance();
//        airport.getTerminals()
//                .forEach(flight -> flight.getFlights().stream()
//                        .forEach(System.out::println));
        Airport airport = Airport.getInstance();

        airport.getAllAircrafts();


        List<Terminal> listOfTerminals = airport.getTerminals();
       listOfTerminals.forEach(flight -> flight.getFlights().//.forEach(System.out::println));
    }
}
