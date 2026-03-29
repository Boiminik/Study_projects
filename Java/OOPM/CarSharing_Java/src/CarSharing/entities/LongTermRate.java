package CarSharing.entities;

import CarSharing.provided.TripStatus;

public class LongTermRate extends Rate {
    private int baseDuration;
    private int baseAmount;
    private int perDay;

    public LongTermRate(int baseAmount, int perDay) {
        this.baseAmount = baseAmount;
        this.perDay = perDay;
    }

    @Override
    public String toString() {
        return "LongTermRate{" +
                "baseDuration=" + baseDuration +
                ", baseAmount=" + baseAmount +
                ", perDay=" + perDay +
                '}';
    }
    public int total (Trip t){
        if (t.getStatus() == TripStatus.COMPLETED)
            return baseAmount + (perDay * (t.duration()*60*60*24-baseDuration));

        return 0;
    }
}
