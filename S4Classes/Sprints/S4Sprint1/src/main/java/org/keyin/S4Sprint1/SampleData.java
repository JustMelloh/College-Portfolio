package org.keyin.S4Sprint1;
import org.keyin.S4Sprint1.Aircraft.*;
import org.keyin.S4Sprint1.Airports.*;
import org.keyin.S4Sprint1.Cities.*;
import org.keyin.S4Sprint1.Passengers.*;
import org.springframework.stereotype.Service;

@Service
public class SampleData {
    private CitiesService citiesService;
    private AirportsService airportsService;
    private AircraftService aircraftService;
    private PassengersService passengersService;

    public SampleData(CitiesService citiesService, AirportsService airportsService, AircraftService aircraftService, PassengersService passengersService) {
        this.citiesService = citiesService;
        this.airportsService = airportsService;
        this.aircraftService = aircraftService;
        this.passengersService = passengersService;
    }

    public void createSampleData() {
        Cities city1 = new Cities(null, "New York", "NY", 1000000, null, null);
        Cities city2 = new Cities(null, "Los Angeles", "CA", 2000000, null, null);
        Cities city3 = new Cities(null, "Chicago", "IL", 3000000, null, null);
        Cities city4 = new Cities(null, "Houston", "TX", 4000000, null, null);
        Cities city5 = new Cities(null, "Phoenix", "AZ", 5000000, null, null);


        citiesService.addCity(city1);
        citiesService.addCity(city2);
        citiesService.addCity(city3);
        citiesService.addCity(city4);
        citiesService.addCity(city5);

        Airports airport1 = new Airports(1, city1, null, null);
        Airports airport2 = new Airports(2, city2, null, null);
        Airports airport3 = new Airports(3, city3, null, null);
        Airports airport4 = new Airports(4, city4, null, null);
        Airports airport5 = new Airports(5, city5, null, null);


        airportsService.addAirport(airport1);
        airportsService.addAirport(airport2);
        airportsService.addAirport(airport3);
        airportsService.addAirport(airport4);
        airportsService.addAirport(airport5);

        Aircraft aircraft1 = new Aircraft(city1, 100, 100);
        Aircraft aircraft2 = new Aircraft(city2, 200, 200);
        Aircraft aircraft3 = new Aircraft(city3, 300, 300);
        Aircraft aircraft4 = new Aircraft(city4, 400, 400);
        Aircraft aircraft5 = new Aircraft(city5, 500, 500);

        aircraftService.addAircraft(aircraft1);
        aircraftService.addAircraft(aircraft2);
        aircraftService.addAircraft(aircraft3);
        aircraftService.addAircraft(aircraft4);
        aircraftService.addAircraft(aircraft5);

        Passengers passenger1 = new Passengers("John", "Doe", "7097463612");
        Passengers passenger2 = new Passengers("Jane", "Doe", "7097463613");
        Passengers passenger3 = new Passengers("John", "Smith", "7097463614");
        Passengers passenger4 = new Passengers("Jane", "Smith", "7097463615");
        Passengers passenger5 = new Passengers("John", "Johnson", "7097463616");

        passengersService.addPassenger(passenger1);
        passengersService.addPassenger(passenger2);
        passengersService.addPassenger(passenger3);
        passengersService.addPassenger(passenger4);
        passengersService.addPassenger(passenger5);
}
}