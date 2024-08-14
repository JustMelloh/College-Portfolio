package org.keyin.S4Sprint1.Airports;

import org.keyin.S4Sprint1.Aircraft.Aircraft;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirportsService {

    /**
     * A map to store all airports, where the key is the airport ID and the value is the airport object.
     */
    private final Map<Integer, Airports> airportsMap = new HashMap<>();

    /**
     * Returns a list of all airports.
     *
     * @return a list of all airports
     */
    public List<Airports> getAllAirports() {
        return new ArrayList<>(airportsMap.values());
    }

    /**
     * Returns a list of all aircraft at a specific airport.
     *
     * @param id the ID of the airport
     * @return a list of all aircraft at the airport
     */
    public List<Aircraft> getAircraftAtAirport(Integer id) {
        Airports airport = airportsMap.get(id);
        return airport.getAircraft();
    }

    /**
     * Returns the airport with the specified ID.
     *
     * @param id the ID of the airport
     * @return the airport with the specified ID
     */
    public Airports getAirportById(Integer id) {
        return airportsMap.get(id);
    }

    /**
     * Adds a new airport to the map.
     *
     * @param airport the airport to add
     * @return the added airport
     * @throws IllegalArgumentException if an airport with the same ID already exists
     */
    public Airports addAirport(Airports airport) {
        if (airportsMap.containsKey(airport.getAirportID())) {
            throw new IllegalArgumentException("Airport already exists");
        }

        airportsMap.put(airport.getAirportID(), airport);
        return airport;
    }

    /**
     * Updates the airport with the specified ID.
     *
     * @param id      the ID of the airport to update
     * @param airport the airport to update
     * @return the updated airport
     * @throws IllegalArgumentException if no airport with the specified ID exists
     */
    public Airports updateAirport(Integer id, Airports airport) {
        if (!airportsMap.containsKey(id)) {
            throw new IllegalArgumentException("Airport does not exist");
        }
        airportsMap.put(id, airport);
        return airport;
    }

    /**
     * Deletes the airport with the specified ID.
     *
     * @param id the ID of the airport to delete
     * @return true if the airport was deleted, false otherwise
     */
    public boolean deleteAirport(Integer id) {
        return airportsMap.remove(id) != null;
    }

    /**
     * Adds an aircraft to the airport with the specified ID.
     *
     * @param id       the ID of the airport
     * @param aircraft the aircraft to add
     * @return the airport to which the aircraft was added
     */
    public Airports addAircraftToAirport(int id, Aircraft aircraft) {
        Airports airport = airportsMap.get(id);
        if (airport != null) {
            List<Aircraft> aircraftList = airport.getAircraft();
            if (aircraftList == null) {
                aircraftList = new ArrayList<>();
            }
            aircraftList.add(aircraft);
            airport.setAircraft(aircraftList);

            airportsMap.put(id, airport);
        }
        return airport;

    }
}