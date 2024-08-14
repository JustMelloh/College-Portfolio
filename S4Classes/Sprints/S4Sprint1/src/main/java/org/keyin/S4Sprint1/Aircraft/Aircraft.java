/**
 * This class represents an Aircraft entity for a server-side API.
 * It incorporates properties such as the aircraft ID, city, seating, passengers, and a list of associated airports.
 * Created by: Austin R.
 */
package org.keyin.S4Sprint1.Aircraft;

import org.keyin.S4Sprint1.Airports.Airports;
import org.keyin.S4Sprint1.Passengers.Passengers;
import org.keyin.S4Sprint1.Cities.Cities;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    // Variables representing the properties of an Aircraft
    private int aircraftID;
    private Cities city;
    private int seating;
    private int capacity;
    private List<Integer> airports = new ArrayList<>();
    private List<Passengers> passengersList = new ArrayList<>();
    private List<Long> aircrafts = new ArrayList<>();

    /**
     * Default constructor for the Aircraft entity.
     */
    public Aircraft() {
    }

    /**
     * Constructor for the Aircraft entity with parameters.
     * @param aircraftID The ID of the aircraft.
     * @param city The city where the aircraft is located.
     * @param seating The seating capacity of the aircraft.
     * @param passengersList The number of passengers in the aircraft.
     */
    public Aircraft(Long aircraftID, Cities city, int seating, List<Passengers> passengersList, int capacity, List<Integer> airports) {
        this.aircraftID = Math.toIntExact(aircraftID);
        this.city = city;
        this.seating = seating;
        this.passengersList = passengersList;
        this.capacity = capacity;
        this.airports = airports;
    }

    public Aircraft(Cities city, int seating, int capacity) {
        this.city = city;
        this.seating = seating;
        this.capacity = capacity;
    }

    // Getters and Setters for the Aircraft entity

    /**
     * @return The ID of the aircraft.
     */
    public Long getAircraftID() {
        return (long) aircraftID;
    }

    /**
     * @param aircraftID The ID to set for the aircraft.
     */
    public void setAircraftID(Long aircraftID) {
        this.aircraftID = Math.toIntExact(aircraftID);
    }

    /**
     * @return The city where the aircraft is located.
     */
    public Cities getCity() {
        return city;
    }

    /**
     * @param city The city to set for the aircraft.
     */
    public void setCity(Cities city) {
        this.city = city;
    }

    /* Passenger Relational Methods */

    /**
     * Removes a passenger from the aircraft.
     *
     * @param passengerId The ID of the passenger to remove.
     */
    public void deletePassenger(int passengerId) {
        passengersList.removeIf(passenger -> passenger.getId() == passengerId);
    }

    /**
     * @return The seating capacity of the aircraft.
     */
    public int getSeating() {
        return seating;
    }

    /**
     * @param seating The seating capacity to set for the aircraft.
     */
    public void setSeating(int seating) {
        this.seating = seating;
    }

    /**
     * @return The number of passengers in the aircraft.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity The number of passengers to set for the aircraft.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    /* Methods for Passengers*/
    public void addPassenger(Passengers passenger) {
        passengersList.add(passenger);
    }

    public List<Passengers> getPassengers() {
        return passengersList;
    }




    // Methods for the Service class

    /**
     * This method is used to add an airport to the aircraft's list of airports.
     * @param airport The airport to be added.
     */
    public void addAirport(Integer airport) {
        airports.add(airport);
    }

    /**
     * @return A list of airports associated with the aircraft.
     */
    public List<Integer> getAirports() {
        return airports;
    }

    /**
     * This method removes an airport from the aircraft's list of airports.
     * It takes the ID of the airport and removes the corresponding Airports object from the list.
     * @param airportId The ID of the airport to be removed.
     */
    public void deleteAirport(int airportId) {
        airports.removeIf(airport -> airport == airportId);
    }

    /**
     * @return A string representation of the Aircraft entity.
     */
    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftID=" + aircraftID +
                ", city='" + city + '\'' +
                ", seating=" + seating +
                ", passengers=" + passengersList +
                '}';
    }

    public Object getCities() {
        return city;
    }

}

