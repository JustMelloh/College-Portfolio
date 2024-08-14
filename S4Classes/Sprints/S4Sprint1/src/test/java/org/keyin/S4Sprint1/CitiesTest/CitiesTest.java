package org.keyin.S4Sprint1.CitiesTest;

import org.junit.jupiter.api.Test;
import org.keyin.S4Sprint1.Airports.Airports;
import org.keyin.S4Sprint1.Cities.Cities;
import org.keyin.S4Sprint1.Passengers.Passengers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitiesTest {

    @Test
    void testCitiesConstructorAndGetters() {
        // Arrange
        Long id = 1L;
        String name = "Sample City";
        String state = "Sample State";
        int population = 100000;
        List<Airports> airportsList = new ArrayList<>();
        List<Passengers> passengersList = new ArrayList<>();

        // Act
        Cities city = new Cities(id, name, state, population, airportsList, passengersList);

        // Assert
        assertEquals(id, city.getId());
        assertEquals(name, city.getName());
        assertEquals(state, city.getState());
        assertEquals(population, city.getPopulation());
        assertEquals(airportsList, city.getAirports());
        assertEquals(passengersList, city.getPassengers());
    }

    @Test
    void testCitiesSetters() {
        // Arrange
        Cities city = new Cities();
        Long id = 1L;
        String name = "Sample City";
        String state = "Sample State";
        int population = 100000;
        List<Airports> airportsList = new ArrayList<>();
        List<Passengers> passengersList = new ArrayList<>();

        // Act
        city.setId(id);
        city.setName(name);
        city.setState(state);
        city.setPopulation(population);
        city.setAirports(airportsList);
        city.setPassengers(passengersList);

        // Assert
        assertEquals(id, city.getId());
        assertEquals(name, city.getName());
        assertEquals(state, city.getState());
        assertEquals(population, city.getPopulation());
        assertEquals(airportsList, city.getAirports());
        assertEquals(passengersList, city.getPassengers());

        System.out.print("Cities setters test passed" + "\n" + "City ID: " + city.getId() + "\n" + "Name: " + city.getName() + "\n" + "State: " + city.getState() + "\n" + "Population: " + city.getPopulation());
    }
}
