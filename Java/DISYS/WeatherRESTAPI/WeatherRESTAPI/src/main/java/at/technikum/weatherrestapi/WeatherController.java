package at.technikum.weatherrestapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    /**
     * This route returns the temperature for a specific city
     *
     * @param city The name of the city,
     *  returns temperature according to city data
     *
     * @return the current temperature of the
     * @param city
     * The Get Method is used because no city data should be altered
     */
    @GetMapping("/{city}")
    public String getTemperature(@PathVariable String city) {
        // fetch temperature data from a weather service or database here
        // Return temperature data
        return "The current temperature in " + city + " is " + temp + "°C";
    }
}