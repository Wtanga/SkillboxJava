import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ParseException {
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        LocalDateTime localMinus2Hours = LocalDateTime.now().minusHours(2);
        LocalDateTime localPlus2Hours = LocalDateTime.now().plusHours(2);
        List<Terminal> listOfTerminals = airport.getTerminals();
        listOfTerminals.forEach(flight -> flight.getFlights()
                .forEach(System.out::println));
        for (Terminal listOfTerminal : listOfTerminals) {
            for (Flight f : listOfTerminal.getFlights()) {
                if (f.getType() == Flight.Type.ARRIVAL && toLocalDateTime(f.getDate()).isAfter(localMinus2Hours) && toLocalDateTime(f.getDate()).isBefore(localPlus2Hours) ) {
                    System.out.println("Прибывает");
                    System.out.println("Date: " + toLocalDateTime(f.getDate()) + "\nType: " +f.getAircraft());

                }
            }
        }
        // Stream FlatMap
        Stream<Flight> arrivalList = listOfTerminals.stream()
                .flatMap(terminal -> terminal.getFlights().stream());
        arrivalList.forEach(flight -> {
            if(flight.getType() == Flight.Type.ARRIVAL
                    && toLocalDateTime(flight.getDate()).isAfter(localMinus2Hours)
                    && toLocalDateTime(flight.getDate()).isBefore(localPlus2Hours))
                System.out.println("Дата: " + toLocalDateTime(flight.getDate()) + "\nТип: " +flight.getAircraft());
        });

    }
    public static LocalDateTime toLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();


    }
}

