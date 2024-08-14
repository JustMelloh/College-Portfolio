package org.keyin.S4Sprint1.Cities;

import org.keyin.S4Sprint1.Airports.Airports;
import org.keyin.S4Sprint1.Passengers.Passengers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CitiesService {

    private final Map<Long, Cities> citiesMap = new HashMap<>();
    private Long nextId = 1L;

    // Method to retrieve all cities
    public List<Cities> getAllCities() {
        return new ArrayList<>(citiesMap.values());
    }

    // Method to retrieve a city by ID
    public Cities getCityById(Long id) {
        return citiesMap.get(id);
    }

    // Method to add a new city
    public Cities addCity(Cities city) {
        city.setId(nextId++);
        citiesMap.put(city.getId(), city);
        return city;
    }

    // Method to update an existing city
    public Cities updateCity(Long id, Cities city) {
        city.setId(id);
        citiesMap.put(id, city);
        return city;
    }

    // Method to delete a city
    public void deleteCity(Long id) {
        citiesMap.remove(id);
    }

    // Method to add an airport to a city
    public Cities addAirportToCity(Long cityId, Airports airport) {
        Cities city = citiesMap.get(cityId);
        if (city != null) {
            List<Airports> airports = city.getAirports();
            airports.add(airport);
            city.setAirports(airports);
        }
        return city;
    }

//     Method to add a passenger to a city
    public Cities addPassengerToCity(Long cityId, Passengers passenger) {
        Cities city = citiesMap.get(cityId);
        if (city != null) {
            List<Passengers> passengers = city.getPassengers();
            passengers.add((Passengers) passengers);
            city.setPassengers(passengers);
        }
        return city;
    }

    // Method to search cities by name
    public List<Cities> searchCitiesByName(String name) {
        return citiesMap.values().stream()
                .filter(city -> city.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}

