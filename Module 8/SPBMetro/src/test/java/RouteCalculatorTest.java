/**
 * Metro scheme that used in tests:
 * <pre>{@code
 *
 *       (Line 1)
 *      Station A
 *          ↓
 *      Station B → Station E → Station G → Station H (Line 2)
 *          ↓
 *      Station C
 *          ↓
 *      Station D → Station J → Station K → Station Q (Line 3)
 *                                 ↓
 *                              Station L
 *                              (Line 4)
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
    List<Station> connectionStations2 = new ArrayList<>();
    List<Station> connectionStations3 = new ArrayList<>();
    Station A, B, C, D, Q, E, G, H, J, K, L;

    @Before
    public void mySetUp() throws Exception {
        route = new ArrayList<>();

        Line line1 = new Line(1, "1");
        Line line2 = new Line(2, "2");
        Line line3 = new Line(3, "3");
        Line line4 = new Line(4, "4");

        A = new Station("A", line1);
        B = new Station("B", line1);
        C = new Station("C", line1);
        D = new Station("D", line1);
        E = new Station("E", line2);
        G = new Station("G", line2);
        H = new Station("H", line2);
        J = new Station("J", line3);
        K = new Station("K", line3);
        Q = new Station("Q", line3);
        L = new Station("L", line4);

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
        line4.addStation(L);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addLine(line4);

        connectionStations.add(B);
        connectionStations.add(E);
        connectionStations2.add(D);
        connectionStations2.add(J);
        connectionStations3.add(K);
        connectionStations3.add(L);

        stationIndex.addConnection(connectionStations);
        stationIndex.addConnection(connectionStations2);
        stationIndex.addConnection(connectionStations3);
    }

    @Test
    public void calculate_duration() {
        route.add(A);
        route.add(B);
        route.add(E);
        route.add(G);

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    @Test
    public void get_shortest_route_without_transfer() {
        List<Station> expected = Arrays.asList(A, B, C, D);
        List<Station> actual = calculator.getShortestRoute(A, D);
        assertEquals(expected, actual);
    }

    @Test
    public void get_shortest_route_with_one_transfer() {
        List<Station> expected = Arrays.asList(A, B, C, D, J);
        List<Station> actual = calculator.getShortestRoute(A, J);
        assertEquals(expected, actual);
    }

    @Test
    public void get_shortest_route_with_two_transfers() {
        List<Station> expected = Arrays.asList(B, C, D, J, K, L);
        List<Station> actual = calculator.getShortestRoute(B, L);
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
    public void getRouteWithOneConnection() {
        List<Station> expected = new ArrayList<>();
        expected.add(A);
        expected.add(B);
        expected.add(C);
        expected.add(D);
        expected.add(J);
        List<Station> actual = calculator.getRouteWithOneConnection(A, J);
        assertEquals(expected, actual);
        actual.clear();
        actual = calculator.getRouteWithOneConnection(A, B);
        assertEquals(null, actual);
    }

    @Test
    public void getRouteWithTwoConnections() {
        List<Station> expected = new ArrayList<>();
        expected.add(B);
        expected.add(C);
        expected.add(D);
        expected.add(J);
        expected.add(K);
        expected.add(L);
        List<Station> actual = calculator.getRouteWithTwoConnections(B, L);
        assertEquals(expected, actual);
        actual.clear();
        actual = calculator.getRouteWithTwoConnections(A, B);
        assertEquals(null, actual);
    }

    @Test
    public void getRouteOnTheLine() {
        List<Station> actual = calculator.getRouteOnTheLine(L, A);
        assertEquals(null, actual);
        actual = calculator.getRouteOnTheLine(A, A);
        List<Station> expected = new ArrayList<>();
        expected.add(A);
        assertEquals(expected, actual);
        actual.clear();
        expected.clear();
        actual = calculator.getRouteOnTheLine(D, A);
        expected.add(D);
        expected.add(C);
        expected.add(B);
        expected.add(A);
        assertEquals(expected, actual);

    }
}
