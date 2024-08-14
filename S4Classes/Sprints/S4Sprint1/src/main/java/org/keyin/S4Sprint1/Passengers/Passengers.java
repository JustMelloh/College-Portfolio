package org.keyin.S4Sprint1.Passengers;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.keyin.S4Sprint1.Airports.Airports;

import java.util.ArrayList;
import java.util.List;

@JsonInclude (JsonInclude.Include.NON_NULL)
public class Passengers {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Long> aircrafts = new ArrayList<>();
    private List<Integer> airports = new ArrayList<>();
    private Long city;


    public Passengers(int id, String firstName, String lastName, String phoneNumber, List<Long> aircrafts, List<Integer> airports, Long city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.aircrafts = aircrafts;
        this.airports = airports;
        this.city = city;
    }

    public Passengers(String firstName, String lastName, String phoneNumber, List<Long> aircrafts, List<Integer> airports, Long city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.aircrafts = aircrafts;
        this.airports = airports;
        this.city = city;
    }

    public Passengers(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Passengers() {

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Long> getAircrafts() {
        return aircrafts;
    }

    public void addAircraft(Long aircraft) {
        aircrafts.add(aircraft);
    }

    public List<Integer> getAirports() {
        return airports;
    }

    public void addAirport(Integer airport) {
        airports.add(airport);
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public String getPassengerID() {
        return null;
    }

    public String getPhone() {
        return null;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "passengerID=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
