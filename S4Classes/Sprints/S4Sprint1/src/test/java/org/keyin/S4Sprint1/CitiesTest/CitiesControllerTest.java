package org.keyin.S4Sprint1.CitiesTest;

import org.junit.jupiter.api.Test;
import org.keyin.S4Sprint1.Airports.Airports;
import org.keyin.S4Sprint1.Cities.Cities;
import org.keyin.S4Sprint1.Cities.CitiesService;
import org.keyin.S4Sprint1.Passengers.Passengers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CitiesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CitiesService citiesService;

    @Test
    public void testGetAllCities() throws Exception {
        // Arrange
        Cities city1 = new Cities(1L, "Sample City 1", "Sample State 1", 100000, List.of(new Airports()), List.of(new Passengers()));
        Cities city2 = new Cities(2L, "Sample City 2", "Sample State 2", 200000, List.of(new Airports()), List.of(new Passengers()));
        List<Cities> citiesList = Arrays.asList(city1, city2);

        when(citiesService.getAllCities()).thenReturn(citiesList);

        // Act and Assert
        mockMvc.perform(get("/api/cities"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1, 'name': 'Sample City 1', 'state': 'Sample State 1', 'population': 100000}, {'id': 2, 'name': 'Sample City 2', 'state': 'Sample State 2', 'population': 200000}]"));

        System.out.println("Get all cities test passed" + "\n" + "City 1: " + city1 + "\n" + "City 2: " + city2);
    }

    @Test
    public void testGetCityById() throws Exception {
        // Arrange
        Cities city = new Cities(1L, "Sample City", "Sample State", 100000, List.of(new Airports()), List.of(new Passengers()));

        when(citiesService.getCityById(1L)).thenReturn(city);

        // Act and Assert
        mockMvc.perform(get("/api/cities/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1, 'name': 'Sample City', 'state': 'Sample State', 'population': 100000}"));

        System.out.println("Get city by ID test passed" + "\n" + "City: " + city);
    }

    @Test
    public void testAddCity() throws Exception {
        // Arrange
        Cities city = new Cities(1L, "Sample City", "Sample State", 100000, List.of(new Airports()), List.of(new Passengers()));

        when(citiesService.addCity(any(Cities.class))).thenReturn(city);

        // Act and Assert
        mockMvc.perform(post("/api/cities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Sample City\", \"state\": \"Sample State\", \"population\": 100000}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1, 'name': 'Sample City', 'state': 'Sample State', 'population': 100000}"));

        System.out.println("Add city test passed" + "\n" + "City: " + city);
    }

    @Test
    public void testUpdateCity() throws Exception {
        // Arrange
        Cities updatedCity = new Cities(1L, "Updated City", "Updated State", 150000, List.of(new Airports()), List.of(new Passengers()));

        when(citiesService.updateCity(eq(1L), any(Cities.class))).thenReturn(updatedCity);

        // Act and Assert
        mockMvc.perform(put("/api/cities/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Updated City\", \"state\": \"Updated State\", \"population\": 150000}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1, 'name': 'Updated City', 'state': 'Updated State', 'population': 150000}"));

        System.out.println("Update city test passed" + "\n" + "Updated City: " + updatedCity);
    }

    @Test
    public void testDeleteCity() throws Exception {
        // Act and Assert
        mockMvc.perform(delete("/api/cities/1"))
                .andExpect(status().isOk());

        verify(citiesService, times(1)).deleteCity(1L);

        System.out.println("Delete city test passed");
    }

    @Test
    public void testAddAirportToCity() throws Exception {
        // Arrange
        Cities cityWithNewAirport = new Cities(1L, "Sample City", "Sample State", 100000, List.of(new Airports()), List.of(new Passengers()));
        Airports airport = new Airports(1, cityWithNewAirport, List.of());

        when(citiesService.addAirportToCity(eq(1L), any(Airports.class))).thenReturn(cityWithNewAirport);

        // Act and Assert
        mockMvc.perform(post("/api/cities/1/airports")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"airportID\": 1}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1, 'name': 'Sample City', 'state': 'Sample State', 'population': 100000}"));

        System.out.println("Add airport to city test passed" + "\n" + "City with new airport: " + cityWithNewAirport);
    }

    @Test
    public void testAddPassengerToCity() throws Exception {
        // Arrange
        Cities cityWithNewPassenger = new Cities(1L, "Sample City", "Sample State", 100000, List.of(new Airports()), List.of(new Passengers()));
        Passengers passenger = new Passengers();

        when(citiesService.addPassengerToCity(eq(1L), any(Passengers.class))).thenReturn(cityWithNewPassenger);

        // Act and Assert
        mockMvc.perform(post("/api/cities/1/passengers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"passengerID\": 1}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1, 'name': 'Sample City', 'state': 'Sample State', 'population': 100000}"));

        System.out.println("Add passenger to city test passed" + "\n" + "City with new passenger: " + cityWithNewPassenger);
    }
}

