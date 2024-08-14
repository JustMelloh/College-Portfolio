package org.keyin.S4Sprint1.Cities;

import org.keyin.S4Sprint1.Airports.Airports;
import org.keyin.S4Sprint1.Passengers.Passengers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    private final CitiesService citiesService;

    @Autowired
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    // Endpoint to get all cities
    @GetMapping
    public List<Cities> getAllCities() {
        return citiesService.getAllCities();
    }

    // Endpoint to get a specific city by ID
    @GetMapping("/{id}")
    public Cities getCityById(@PathVariable Long id) {
        return citiesService.getCityById(id);
    }

    // Endpoint to add a new city
    @PostMapping
    public Cities addCity(@RequestBody Cities city) {
        return citiesService.addCity(city);
    }

    // Endpoint to update an existing city
    @PutMapping("/{id}")
    public Cities updateCity(@PathVariable Long id, @RequestBody Cities city) {
        return citiesService.updateCity(id, city);
    }

    // Endpoint to delete a city
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        citiesService.deleteCity(id);
    }

    // Endpoint to add an airport to a city
    @PostMapping("/{cityId}/airports")
    public Cities addAirportToCity(@PathVariable Long cityId, @RequestBody Airports airport) {
        return citiesService.addAirportToCity(cityId, airport);
    }

    // Endpoint to add a passenger to a city
    @PostMapping("/{cityId}/passengers")
    public Cities addPassengerToCity(@PathVariable Long cityId, @RequestBody Passengers passenger) {
        return citiesService.addPassengerToCity(cityId, passenger);
    }

    // Endpoint to search for cities by name
    @GetMapping("/search")
    public List<Cities> searchCitiesByName(@RequestParam String name) {
        return citiesService.searchCitiesByName(name);
    }


}

