import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        LocalDateTime LocalMinus2Hours = LocalDateTime.now().minusHours(2);
        LocalDateTime LocalPlus2Hours = LocalDateTime.now().plusHours(2);
        List<Terminal> listOfTerminals = airport.getTerminals();
        listOfTerminals.forEach(flight -> flight.getFlights()
                .forEach(System.out::println));
        for (Terminal listOfTerminal : listOfTerminals) {
            for (Flight f : listOfTerminal.getFlights()) {
                if (f.getType() == Flight.Type.ARRIVAL && toLocalDateTime(f.getDate()).isAfter(LocalMinus2Hours) && toLocalDateTime(f.getDate()).isBefore(LocalPlus2Hours) ) {
                    System.out.println("Прибывает");
                    System.out.println("Date: " + toLocalDateTime(f.getDate()) + "\nType: " +f.getAircraft());

                }
            }
        }
    }
    public static LocalDateTime toLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();


    }
}

