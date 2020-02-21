import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        String elements[];
        ArrayList<String> arrival = new ArrayList<>();
        LocalTime LocalMinus2Hours = LocalTime.now().minusHours(2);
        LocalTime LocalPlus2Hours = LocalTime.now().plusHours(2);
        String minus2Hours = LocalMinus2Hours.format(DateTimeFormatter.ofPattern("HH:mm"));
        String plus2Hours = LocalPlus2Hours.format(DateTimeFormatter.ofPattern("HH:mm"));
        DateFormat format = new SimpleDateFormat("HH:mm");
        Date dateMinus2Hours = format.parse(minus2Hours);
        Date datePlus2Hours = format.parse(plus2Hours);
        List<Terminal> listOfTerminals = airport.getTerminals();
        listOfTerminals.forEach(flight -> flight.getFlights()
                .forEach(System.out::println));
        for (Terminal listOfTerminal : listOfTerminals) {
            elements = listOfTerminal.getFlights().toString().split(" ");
            for (int i = 5; i < elements.length; i += 6) {
                Date dateOfArrival = format.parse(elements[i - 5].replace("[","").replace("]",""));
                if (elements[i].contains("ARRIVAL") && dateOfArrival.after(dateMinus2Hours) && dateOfArrival.before(datePlus2Hours)) {
                    arrival.add(elements[i - 5] + elements[i - 4] + elements[i - 3] + " " + elements[i - 2]);
                }
            }
        }
        for (String name : arrival) {
            System.out.println(name);
        }
    }
}

