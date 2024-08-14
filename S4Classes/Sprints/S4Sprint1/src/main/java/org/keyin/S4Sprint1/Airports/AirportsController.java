package org.keyin.S4Sprint1.Airports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is the controller class for the Airports entity.
 * It handles HTTP requests and responses for the Airports entity.
 */
@RestController
@RequestMapping("/api/airports")
public class AirportsController {

    private final AirportsService airportsService;

    /**
     * Constructor for the AirportsController class.
     * It initializes the AirportsService object.
     * @param airportsService The service class for the Airports entity.
     */
    @Autowired
    public AirportsController(AirportsService airportsService) {
        this.airportsService = airportsService;
    }

    /**
     * This method handles the GET request to fetch all airports.
     * @return A list of all airports.
     */
    @GetMapping("/all")
    public List<Airports> getAllAirports(){
        return airportsService.getAllAirports();
    }

    /**
     * This method handles the GET request to fetch an airport by its ID.
     * @param id The ID of the airport.
     * @return The airport with the given ID.
     */
    @GetMapping("/{id}")
    public Airports getAirportById(@PathVariable int id){
        return airportsService.getAirportById(id);
    }

    /**
     * This method handles the POST request to add a new airport.
     * @param airport The airport to be added.
     * @return The added airport.
     */
    @PostMapping("/add")
    public Airports addAirport(@RequestBody Airports airport){
        return airportsService.addAirport(airport);
    }

    /**
     * This method handles the PUT request to update an existing airport.
     * @param id The ID of the airport to be updated.
     * @param airport The updated airport.
     * @return The updated airport.
     */
    @PutMapping("/update/{id}")
    public Airports updateAirport(@PathVariable int id, @RequestBody Airports airport){
        return airportsService.updateAirport(id, airport);
    }

    /**
     * This method handles the DELETE request to delete an airport.
     * @param id The ID of the airport to be deleted.
     * @return A boolean indicating whether the deletion was successful.
     */
    @DeleteMapping("/{id}")
    public boolean deleteAirport(@PathVariable int id){
        return airportsService.deleteAirport(id);
    }


}