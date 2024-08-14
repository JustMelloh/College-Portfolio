package org.keyin.S4Sprint1.Aircraft;
import org.keyin.S4Sprint1.Passengers.Passengers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AircraftService {
    /* Declaration of a HashMap that will be used to store AirCraft objects. */
    private final Map<Long, Aircraft> aircraftMap = new HashMap<>();
    private Long nextId = 1L;

    /* Retrieving all aircraft in airport*/
    public List<Aircraft> getAllAircraft() {
        return new ArrayList<>(aircraftMap.values());
    }

    /* Retrieving aircraft by ID*/

    public Aircraft getAircraftById(Long id) {
        return aircraftMap.get(id);
    }

    /* Adding an aircraft*/

    public Aircraft addAircraft(Aircraft aircraft) {
        aircraft.setAircraftID(nextId++);
        aircraftMap.put(aircraft.getAircraftID(), aircraft);
        return aircraft;
    }

    /* Updating an existing aircraft*/

    public Aircraft updateAircraft(Long id, Aircraft aircraft) {
        aircraft.setAircraftID(id);
        aircraftMap.put(id, aircraft);
        return aircraft;
    }

    /* Deleting an aircraft*/

    public void deleteAircraft(Long id) {
        aircraftMap.remove(id);
    }

    /* Adding an airport to a specific Aircraft*/

    public Aircraft addAirportToAircraft(Long id, int airports) {
        Aircraft aircraft = aircraftMap.get(id);
        aircraft.addAirport(airports);
        return aircraft;
    }


    public List<Integer> getAirportsForAircraft(Long id) {
        Aircraft aircraft = aircraftMap.get(id);
        return aircraft.getAirports();
    }

    public void deleteAirportFromAircraft(Long id, int airportId) {
        Aircraft aircraft = aircraftMap.get(id);
        aircraft.deleteAirport(airportId);
    }

    /* Setting up methods for getting seating and capacity of aircraft*/

    public int getSeating(Long id) {
        Aircraft aircraft = aircraftMap.get(id);
        return aircraft.getSeating();
    }

    public void setSeating(Long id, int seating) {
        Aircraft aircraft = aircraftMap.get(id);
        aircraft.setSeating(seating);
    }

    public int getCapacity(Long id) {
        Aircraft aircraft = aircraftMap.get(id);
        return aircraft.getCapacity();
    }

    public void setCapacity(Long id, int capacity) {
        Aircraft aircraft = aircraftMap.get(id);
        aircraft.setCapacity(capacity);
    }

    /* Methods for allowing passengers to be added to a craft based on the ID*/

    public Aircraft addPassengerToAircraft(Long id, Passengers passenger) {
        Aircraft aircraft = aircraftMap.get(id);
        aircraft.addPassenger(passenger);
        return aircraft;
    }

    public void deletePassengerFromAircraft(Long aircraftId, int passengerId) {
        Aircraft aircraft = aircraftMap.get(aircraftId);
        aircraft.deletePassenger(passengerId);
    }


    public List<Passengers> getPassengersForAircraft(Long id) {
        Aircraft aircraft = aircraftMap.get(id);
        return aircraft.getPassengers();
    }

    public Object getCitiesForAircraft(Long aircraftId) {
        Aircraft aircraft = aircraftMap.get(aircraftId);
        return aircraft.getCities();
    }
}
