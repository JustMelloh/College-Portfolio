package org.keyin.S4Sprint1.Passengers;

import org.keyin.S4Sprint1.Aircraft.Aircraft;
import org.keyin.S4Sprint1.Airports.Airports;
import org.keyin.S4Sprint1.Airports.AirportsService;
import org.keyin.S4Sprint1.Cities.Cities;
import org.keyin.S4Sprint1.Cities.CitiesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassengersService {
    private final Map<Integer, Passengers> allPassengers = new HashMap<>();
    private int nextPassenger = 1;

    private AirportsService airportsService;
    private CitiesService citiesService;

    public PassengersService(AirportsService airportsService, CitiesService citiesService) {
        this.airportsService = airportsService;
        this.citiesService = citiesService;

    }

    public List<Passengers> getPassengers() {
        return new ArrayList<>(allPassengers.values());
    }

    public Passengers addPassenger(Passengers passenger) {
        passenger.setId(nextPassenger++);
        allPassengers.put(passenger.getId(), passenger);
        System.out.println("Passenger added successfully");
        return passenger;
    }

    public Passengers getPassengerById(int id) {
        return allPassengers.get(id);
    }

    public Passengers updatePassengers(int id, Passengers passenger) {
        passenger.setId(id);
        allPassengers.put(id, passenger);
        System.out.println("Passenger updated successfully");
        return passenger;
    }

    public void deletePassenger(int id) {
        allPassengers.remove(id);
        System.out.println("Passenger deleted successfully");
    }

    public void addAircraftToPassenger(Passengers passengers, Long aircraft) {
        passengers.addAircraft(aircraft);
    }

    public List<Aircraft> getAircraftForPassenger(int passenger) {
        List<Aircraft> aircrafts = new ArrayList<>();
        Passengers passengers = getPassengerById(passenger);
        for (Long aircraftId : passengers.getAircrafts()) {
            Aircraft aircraft = new Aircraft();
            aircraft.setAircraftID(aircraftId);
            aircrafts.add(aircraft);
        }
        return aircrafts;
    }

    public Airports addAirportToPassenger(int passengerID, int airports) {
        Passengers passenger = getPassengerById(passengerID);
        passenger.addAirport(airports);
        return airportsService.getAirportById(airports);
    }

    public List<Airports> getAirportsForPassenger(int passenger) {
        List<Airports> airports = new ArrayList<>();
        Passengers passengers = getPassengerById(passenger);
        for (int airportId : passengers.getAirports()) {
            Airports airport = airportsService.getAirportById(airportId);
            airports.add(airport);
        }
        return airports;
    }

    public void deleteAircraftFromPassenger(Passengers passengers, Long aircraftId) {
        passengers.getAircrafts().remove(aircraftId);
    }

    public void deleteAirportFromPassenger(Passengers passengers, Integer airport) {
        passengers.getAirports().remove(airport);
    }

    public Cities getCityForPassenger(int id) {
        Passengers passenger = getPassengerById(id);
        Long cityID = passenger.getCity();
        return citiesService.getCityById(cityID);
    }

    public Cities addCityToPassenger(int id, Long city) {
        Passengers passengers = getPassengerById(id);
        passengers.setCity(city);
        return citiesService.getCityById(city);
    }
}
