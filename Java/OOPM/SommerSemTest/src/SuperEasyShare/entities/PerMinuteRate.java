package SuperEasyShare.entities;

public class PerMinuteRate extends Rate{
    private int perMinute;

    public PerMinuteRate(int perMinute) {
        this.perMinute = perMinute;
    }

    @Override
    public String toString() {
        return "PerMinuteRate{" +
                "perMinute=" + perMinute +
                '}';
    }
    public int total(Trip t){
        return t.duration()/60 * perMinute;
    }
}
