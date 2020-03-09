/**
 * Metro scheme that used in tests:
 * <pre>{@code
 *
 *       (Line 1)
 *      Station1.1A
 *          ↓
 *      Station1.2B → Station2.1E → Station2.2G → Station2.3H (Line 2)
 *          ↓
 *      Station1.3C
 *          ↓
 *      Station1.4D → Station3.1J → Station 3.2K → Station3.3Q (Line 3)
 *
 * }</pre>
 */

import core.Line;
import core.Station;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class RouteCalculatorTest {
    List<Station> route;
    StationIndex stationIndex = new StationIndex();
    RouteCalculator calculator = new RouteCalculator(stationIndex);
    List<Station> connectionStations = new ArrayList<>();
    Station A, B, C, D, Q, E, G, H, J, K;

    @Before
    public void mySetUp() throws Exception {
        route = new ArrayList<>();

        Line line1 = new Line(1, "1");
        Line line2 = new Line(2, "2");
        Line line3 = new Line(3, "3");


        A = new Station("1.1", line1);
        B = new Station("1.2", line1);
        C = new Station("1.3", line1);
        D = new Station("1.4", line1);
        E = new Station("2.1", line2);
        G = new Station("2.2", line2);
        H = new Station("2.3", line2);
        J = new Station("3.1", line3);
        K = new Station("3.2", line3);
        Q = new Station("3.3", line3);
        line1.addStation(A);
        line1.addStation(B);
        line1.addStation(C);
        line1.addStation(D);
        line2.addStation(E);
        line2.addStation(G);
        line2.addStation(H);
        line3.addStation(J);
        line3.addStation(K);
        line3.addStation(Q);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);


        connectionStations.add(B);
        connectionStations.add(E);
        connectionStations.add(D);
        connectionStations.add(J);
        stationIndex.addConnection(connectionStations);
    }

    @Test
    public void calculateDuration() {
        route.add(A);
        route.add(B);
        route.add(E);
        route.add(G);

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    @Test
    public void getShortestRoute_with_one_transfer() {
        List<Station> expected = Arrays.asList(A, B, C, D, J, K);
        List<Station> actual = calculator.getShortestRoute(A, K);
        assertEquals(expected, actual);
    }

    @Test
    public void isConnected() {
        boolean actual = calculator.isConnected(B, E);
        assertEquals(true, actual);
        actual = calculator.isConnected(D, J);
        assertEquals(true, actual);
        actual = calculator.isConnected(B, J);
        assertEquals(false, actual);
    }

    @Test
    public void getRouteWithOneConnection()
    {
        List<Station> expected = new ArrayList<>();
        expected.add(A);
        expected.add(B);
        expected.add(C);
        expected.add(D);
        expected.add(J);
        List<Station> actual = calculator.getRouteWithOneConnection(A, J);
        assertEquals(expected, actual);
    }
}
