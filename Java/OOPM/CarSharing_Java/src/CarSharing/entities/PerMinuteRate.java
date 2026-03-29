package CarSharing.entities;

import CarSharing.provided.TripStatus;

public class PerMinuteRate extends Rate {

    private final int perMinute;

    public PerMinuteRate(int perMinute) {
        if (perMinute <= 0)
            throw new IllegalArgumentException("per Minute rate must be positive");
        this.perMinute = perMinute;
    }

    @Override
    public String toString() {
        return "PerMinuteRate{" +
                "perMinute=" + perMinute +
                '}';
    }
    public int total (Trip t){
        return perMinute * t.duration();
    }
}
