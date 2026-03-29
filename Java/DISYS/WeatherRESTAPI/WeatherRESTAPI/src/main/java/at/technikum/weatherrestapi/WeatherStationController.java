package at.technikum.weatherrestapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stations")
public class WeatherStationController {

    /**
     * receives weather data from a weather station and updates the database.
     *
     * @param weatherData The weather data sent by the weather station.
     *
     * @return confirmation message, indicating successfull data transfer
     */
    @PostMapping("/update")
    public String updateWeatherData(@RequestBody WeatherData weatherData) {
        // fetch weather data and insert into database
        // check for inconsistencies in the received data
        return "Weather data received and updated successfully";
    }
}