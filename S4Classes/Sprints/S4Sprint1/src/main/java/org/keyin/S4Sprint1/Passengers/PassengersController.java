package org.keyin.S4Sprint1.Passengers;

import org.keyin.S4Sprint1.Aircraft.Aircraft;
import org.keyin.S4Sprint1.Airports.Airports;
import org.keyin.S4Sprint1.Airports.AirportsService;
import org.keyin.S4Sprint1.Cities.Cities;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengersController {
    private PassengersService passengersService;
    private AirportsService AirportsService;


    public PassengersController(PassengersService passengersService, AirportsService AirportsService) {
        this.passengersService = passengersService;
        this.AirportsService = AirportsService;

    }

    @GetMapping
    public List<Passengers> getPassengers() {
        return passengersService.getPassengers();
    }

    @PostMapping
    public Passengers addPassenger(@RequestBody Passengers passenger) {
        return passengersService.addPassenger(passenger);
    }

    @GetMapping("/{id}")
    public Passengers getPassengerById(@PathVariable int id) {
        return passengersService.getPassengerById(id);
    }

    @PutMapping("/{id}")
    public Passengers updatePassengers(@PathVariable int id, @RequestBody Passengers passenger) {
        return passengersService.updatePassengers(id, passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable int id) {
        passengersService.deletePassenger(id);
    }

    @GetMapping("/{id}/aircraft")
    public List<Aircraft> getAircraftsForPassenger(@PathVariable int id) {
        return passengersService.getAircraftForPassenger(id);
    }

    @PostMapping("/{id}/aircraft/{aircraftId}")
    public void addAircraftToPassenger(@PathVariable int id, @PathVariable Long aircraftId) {
        Passengers passenger = passengersService.getPassengerById(id);
        passenger.addAircraft(aircraftId);
    }

    @DeleteMapping("/{id}/aircraft/{aircraftId}")
    public void deleteAircraftFromPassenger(@PathVariable int id, @PathVariable Long aircraftId) {
        Passengers passenger = passengersService.getPassengerById(id);
        passengersService.deleteAircraftFromPassenger(passenger, aircraftId);
    }

    @GetMapping("/{id}/airport")
    public List<Airports> getAirportsForPassenger(@PathVariable int id) {
        return passengersService.getAirportsForPassenger(id);
    }

    @PostMapping("/{id}/airport/{airportID}")
    public Airports addAirportToPassenger(@PathVariable int id, @PathVariable int airportID) {
        return passengersService.addAirportToPassenger(id, airportID);
    }

    @DeleteMapping("/{id}/airport/{airportID}")
    public void deleteAirportFromPassenger(@PathVariable int id, @PathVariable int airportID) {
        Passengers passenger = passengersService.getPassengerById(id);
        passengersService.deleteAirportFromPassenger(passenger, airportID);
    }

    @GetMapping("/{id}/cities")
    public Cities getCity(@PathVariable int id) {
        return passengersService.getCityForPassenger(id);
    }

    @PostMapping("/{id}/cities/{city}")
    public void setCity(@PathVariable int id, @PathVariable Long city) {
        Passengers passenger = passengersService.getPassengerById(id);
        passenger.setCity(city);
    }
}
